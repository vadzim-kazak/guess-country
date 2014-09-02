package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.PlayerLeftPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.factory.GameFactory;
import com.jrew.lab.guesscountry.service.message.factory.GameMessageFactory;
import com.jrew.lab.guesscountry.service.message.handler.MessageHandlerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Kazak_VV on 31.07.2014.
 */

@Service
public class GameServerImpl implements GameServer {

    /** **/
    private Logger logger = LoggerFactory.getLogger(GameServerImpl.class);

    /** **/
    @Autowired
    private GameFactory gameFactory;

    /** **/
    @Autowired
    private GameMessageFactory gameMessageFactory;

    /** **/
    @Autowired
    private MessageHandlerProvider messageHandlerProvider;

    /** **/
    private Map<String, Player> playersStorage = new ConcurrentHashMap<>();

    /** **/
    private List<Game> activeGames = new ArrayList<>();

    @Override
    public void handlePlayerConnection(Player player) {

       playersStorage.put(player.getId(), player);

       gameFactory.buildGame(player, gameReadyEvent -> {

           logger.debug("Game ready event has been received by game server...");
           Game game = (Game) gameReadyEvent.getSource();
           activeGames.add(game);
           game.start();
       });
    }

    @Override
    public void handlePlayerDisconnection(String playerId) {

        Optional<Game> gameOptional = activeGames.stream().filter(game -> game.hasPlayer(playerId)).findFirst();
        gameOptional.ifPresent(game -> {
            GameMessage<PlayerLeftPayload> gameMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.PLAYER_LEFT);
            PlayerLeftPayload payload = gameMessage.getPayload();
            payload.setPlayerId(playerId);
            payload.setFinishGameEvent(() -> {
                logger.debug("Finishing game...");
                activeGames.remove(game);
            });
            messageHandlerProvider.handleMessage(gameMessage, game);
        });

        playersStorage.remove(playerId);
    }

    @Override
    public void handlePlayerMessage(String playerId, String message) {

        Optional<Game> gameOptional = activeGames.stream().filter(game -> game.hasPlayer(playerId)).findFirst();
        gameOptional.ifPresent(game -> game.handleMessage(message, playersStorage.get(playerId)));
    }

}
