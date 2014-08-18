package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.GameFinishedPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Kazak_VV on 14.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.GAME_FINISHED)
public class GameFinishedHandler implements GameMessageHandler<GameFinishedPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<GameFinishedPayload> message, Game game) {

        OptionalInt maxScoresOptional =
                game.getPlayers().stream().mapToInt(player -> player.getScores()).max();

        maxScoresOptional.ifPresent(maxScores -> {

            GameFinishedPayload payload = message.getPayload();

            List<Player> winners = game.getPlayers().stream().filter(player -> player.getScores() == maxScores)
                    .collect(Collectors.toList());
            if (winners.size() > 1) {
                // there is draw between some players
                payload.setDraw(true);
            }

            List<GameFinishedPayload.PlayerResult> playersResult = payload.getPlayersResult();

            game.getPlayers().stream().forEach(player -> {

                GameFinishedPayload.PlayerResult playerResult = new GameFinishedPayload.PlayerResult();
                playerResult.setId(player.getId());
                playerResult.setPlayerName(player.getName());
                playerResult.setScores(player.getScores());

                if (!payload.isDraw() && player.getScores() == maxScores) {
                    playerResult.setWinner(true);
                }

                playersResult.add(playerResult);
            });

            game.getPlayers().stream().forEach(player -> {
                playersResult.stream().forEach(playerResult -> {
                    if (playerResult.getId().equalsIgnoreCase(player.getWebSocketSession().getId())) {
                        playerResult.setCurrentPlayer(true);
                    } else {
                        playerResult.setCurrentPlayer(false);
                    }
                });
                webSocketSender.sendMessage(message, player.getWebSocketSession());
            });

        });
    }
}
