package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.AnswerTimeoutPayload;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.message.handler.helper.AnswerRegistry;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 18.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.ANSWER_TIMEOUT)
public class AnswerTimeoutGameMessageHandler implements GameMessageHandler<AnswerTimeoutPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    /** **/
    @Autowired
    private AnswerRegistry answerRegistry;

    @Override
    public void handleMessage(GameMessage<AnswerTimeoutPayload> message, Game game) {

        AnswerTimeoutPayload messagePayload = message.getPayload();

        game.getPlayers().stream().forEach(player -> {
            QuestionAnswer questionAnswer = game.getQuestionAnswer();
            messagePayload.setQuestionAnswer(questionAnswer);

            if (answerRegistry.canAnswer(player, game)) {
                webSocketSender.sendMessage(message, player.getWebSocketSession());
            }
        });

        answerRegistry.reset(game);
    }
}
