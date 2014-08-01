package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.event.GameReadyEvent;
import com.jrew.lab.guesscountry.service.game.factory.GameFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private Map<String, Player> playersStorage = new ConcurrentHashMap<>();

    /** **/
    private List<Game> activeGames = new ArrayList<>();

    @Override
    public void handlePlayerConnection(Player player) {
       playersStorage.put(player.getId(), player);
       prepareGame(player);
    }

    @Override
    public void handlePlayerDisconnection(String playerId) {}

    @Override
    public void prepareGame(Player player) {
        gameFactory.buildGame(player);
    }

    @Override
    public void handlePlayerMessage(String playerId, TextMessage message) {}

    @Override
    public void onApplicationEvent(GameReadyEvent gameReadyEvent) {

        Game game = (Game) gameReadyEvent.getSource();
        activeGames.add(game);
        logger.debug("Game ready event has been received by game server...");

        game.start();
    }
}
