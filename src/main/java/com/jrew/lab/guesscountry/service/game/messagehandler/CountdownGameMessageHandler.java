package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.CountdownPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 06.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.COUNTDOWN)
public class CountdownGameMessageHandler implements GameMessageHandler<CountdownPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<CountdownPayload> message, Game game) {

        CountdownPayload payload = message.getPayload();
        game.getPlayers().stream().forEach(player -> {
            webSocketSender.sendMessage(message, player.getWebSocketSession());
        });
    }
}
