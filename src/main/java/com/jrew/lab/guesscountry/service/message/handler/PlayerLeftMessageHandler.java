package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.PlayerLeftPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Kazak_VV on 18.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.PLAYER_LEFT)
public class PlayerLeftMessageHandler implements GameMessageHandler<PlayerLeftPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<PlayerLeftPayload> message, Game game) {

        PlayerLeftPayload payload = message.getPayload();

        List<Player> players = game.getPlayers();
        if (players.size() == 1) {
            game.finish();
            payload.getFinishGameEvent().run();

        } else if (players.size() > 1) {

            String leftPlayerId = payload.getPlayerId();
            Optional<Player> leftPlayerOptional =
                    players.stream().filter(player -> player.getId().equalsIgnoreCase(leftPlayerId)).findFirst();

            leftPlayerOptional.ifPresent(leftPlayer -> {
                game.removePlayer(leftPlayer);
                players.stream().filter(player -> !player.getId().equalsIgnoreCase(leftPlayerId)).forEach(player ->
                        webSocketSender.sendMessage(message, player.getWebSocketSession())
                );
            });
        }
    }
}
