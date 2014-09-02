package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.StartGamePayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 14.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.START_GAME)
public class StartGameMessageHandler implements GameMessageHandler<StartGamePayload>{

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<StartGamePayload> message, Game game) {

        StartGamePayload startGamePayload = message.getPayload();
        game.getPlayers().stream().forEach(player -> {
            startGamePayload.getPlayers().add(new StartGamePayload.PlayerInfo(player.getId(), player.getName()));
        });

        game.getPlayers().stream().forEach(player -> {
            webSocketSender.sendMessage(message, player.getWebSocketSession());
        });
    }
}
