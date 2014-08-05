package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.factory.game.GameFactory;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
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
    GameMessageFactory gameMessageFactory;

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
    public void handlePlayerDisconnection(String playerId) {}

    @Override
    public void handlePlayerMessage(String playerId, String message) {

        Optional<Game> gameOptional = activeGames.stream().filter(game -> game.hasPlayer(playerId)).findFirst();
        gameOptional.ifPresent(game -> {
            Optional<GameMessage> gameMessageOptional = gameMessageFactory.buildMessage(message, playersStorage.get(playerId));
            gameMessageOptional.ifPresent(gameMessage -> game.handleMessage(gameMessage));
        });
    }

}
