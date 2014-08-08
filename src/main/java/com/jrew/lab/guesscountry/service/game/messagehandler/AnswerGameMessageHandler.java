package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.AnswerPayload;
import com.jrew.lab.guesscountry.model.message.payload.ResultPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Override
    public void handleMessage(GameMessage<AnswerPayload> message, Game game) {

        AnswerPayload payload = message.getPayload();
        Player answerOwner = payload.getPlayer();

        LocalizedQuestionAnswer questionAnswer = game.getQuestionAnswer();
        boolean isAnswerCorrect = questionAnswer.checkAnswer(payload.getAnswer(), answerOwner.getLocale());
        logger.debug("Player {} provided {} answer", answerOwner.getId(), isAnswerCorrect);

        GameMessage<ResultPayload> resultMessage = createResultMessage(payload);

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
            // Increment scores counter
            answerOwner.setScores(answerOwner.getScores() + 1);

            game.nextRound();
        }
    }

    /**
     *
     * @param payload
     * @return
     */
    private GameMessage<ResultPayload> createResultMessage(AnswerPayload payload) {

        Player player = payload.getPlayer();

        GameMessage<ResultPayload> resultMessage = gameMessageFactory.buildMessage(GameMessage.Type.RESULT);
        ResultPayload resultPayload = resultMessage.getPayload();
        resultPayload.setAnswer(payload.getAnswer());
        resultPayload.setPlayerName(player.getName());

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
