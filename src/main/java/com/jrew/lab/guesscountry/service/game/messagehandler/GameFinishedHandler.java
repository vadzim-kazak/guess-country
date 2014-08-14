package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.GameFinishedPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
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

        Optional<Player> winnerOptional =
                game.getPlayers().stream().max((firstPlayer, secondPlayer) ->
                        firstPlayer.getScores() - secondPlayer.getScores());

        winnerOptional.ifPresent(winner -> {

            GameFinishedPayload payload = message.getPayload();
            List<GameFinishedPayload.PlayerResult> playersResult = payload.getPlayersResult();

            game.getPlayers().stream().forEach(player -> {

                GameFinishedPayload.PlayerResult playerResult = new GameFinishedPayload.PlayerResult();
                playerResult.setPlayerName(player.getName());
                playerResult.setScores(player.getScores());
                if (player.equals(winner)) {
                    playerResult.setWinner(true);
                }

                playersResult.add(playerResult);
            });

            game.getPlayers().stream().forEach(player -> {
                webSocketSender.sendMessage(message, player.getWebSocketSession());
            });
        });
    }
}
