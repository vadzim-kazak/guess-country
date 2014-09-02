package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.QuestionPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.QUESTION)
public class QuestionGameMessageHandler implements GameMessageHandler<QuestionPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<QuestionPayload> message, Game game) {

        game.getPlayers().stream().forEach(player -> {
            webSocketSender.sendMessage(message, player.getWebSocketSession());
        });
    }
}
