package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.StringPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 14.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.START_GAME)
public class StartGameMessageHandler implements GameMessageHandler<StringPayload>{

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<StringPayload> message, Game game) {

        game.getPlayers().stream().forEach(player -> {
            webSocketSender.sendMessage(message, player.getWebSocketSession());
        });
    }
}
