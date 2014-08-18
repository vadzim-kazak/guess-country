package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.AnswerTimeoutPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Kazak_VV on 18.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.ANSWER_TIMEOUT)
public class AnswerTimeoutGameMessageHandler implements GameMessageHandler<AnswerTimeoutPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<AnswerTimeoutPayload> message, Game game) {

        AnswerTimeoutPayload messagePayload = message.getPayload();

        game.getPlayers().stream().forEach(player -> {

            Optional<String> optionalAnswer = game.getQuestionAnswer().getAnswer(player.getLocale());
            optionalAnswer.ifPresent(answer -> {
                messagePayload.setAnswer(answer);
                webSocketSender.sendMessage(message, player.getWebSocketSession());
            });
        });

    }
}
