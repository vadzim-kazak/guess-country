package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.AnswerPayload;
import com.jrew.lab.guesscountry.model.message.payload.ResultPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.message.factory.GameMessageFactory;
import com.jrew.lab.guesscountry.service.message.handler.helper.AnswerCounter;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.ANSWER)
public class AnswerGameMessageHandler implements GameMessageHandler<AnswerPayload> {

    /** **/
    private Logger logger = LoggerFactory.getLogger(AnswerGameMessageHandler.class);

    /** **/
    @Autowired
    GameMessageFactory gameMessageFactory;

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    /** **/
    @Autowired
    private AnswerCounter answerCounter;

    @Override
    public void handleMessage(GameMessage<AnswerPayload> message, Game game) {

        AnswerPayload answerPayload = message.getPayload();
        Player answerOwner = answerPayload.getPlayer();

        if (answerCounter.canAnswer(answerOwner, game)) {

            answerCounter.countAnswer(answerOwner, game);

            LocalizedQuestionAnswer questionAnswer = game.getQuestionAnswer();
            boolean isAnswerCorrect = questionAnswer.checkAnswer(answerPayload.getAnswer(), answerOwner.getLocale());
            logger.debug("Player {} provided {} answer", answerOwner.getId(), isAnswerCorrect);

            if (isAnswerCorrect) {
                // Increment scores counter
                answerOwner.setScores(answerOwner.getScores() + 1);
            }

            GameMessage<ResultPayload> resultMessage = createResultMessage(answerPayload);

            sendResultMessageToPlayers(gameMessage -> {

                gameMessage.getPayload().setRightAnswer(isAnswerCorrect);
                game.getPlayers().stream().forEach(player -> {
                    if (!player.equals(answerOwner)) {
                        gameMessage.getPayload().setAnswerOwner(false);
                    } else {
                        gameMessage.getPayload().setAnswerOwner(true);
                    }

                    webSocketSender.sendMessage(gameMessage, player.getWebSocketSession());
                });

            }, resultMessage);

            if(isAnswerCorrect) {
                answerCounter.reset(game);
                game.nextRound();
            } else {

                Optional<Player> playerOptional = game.getPlayers().stream()
                                                      .filter(player -> answerCounter.canAnswer(player, game)).findAny();
                if (!playerOptional.isPresent()) {
                    answerCounter.reset(game);
                    game.nextRound();
                }
            }
        }
    }

    /**
     *
     * @param answerPayload
     * @return
     */
    private GameMessage<ResultPayload> createResultMessage(AnswerPayload answerPayload) {

        Player player = answerPayload.getPlayer();

        GameMessage<ResultPayload> resultMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.RESULT);
        ResultPayload resultPayload = resultMessage.getPayload();
        resultPayload.setAnswer(answerPayload.getAnswer());
        resultPayload.setPlayerName(player.getName());
        resultPayload.setLatLng(answerPayload.getLatLng());
        resultPayload.setScores(answerPayload.getPlayer().getScores());

        return resultMessage;
    }

    /**
     *
     * @param consumer
     * @param gameMessage
     */
    private void sendResultMessageToPlayers(Consumer<GameMessage<ResultPayload>> consumer, GameMessage<ResultPayload> gameMessage) {
        consumer.accept(gameMessage);
    }
}
