package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.service.game.factory.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Kazak_VV on 31.07.2014.
 */

@Service
public class GameServerImpl implements GameServer {

    /** **/
    @Autowired
    private GameFactory gameFactory;

    /** **/
    private Map<String, Player> playersStorage = new ConcurrentHashMap<>();

    @Override
    public void handlePlayerConnection(Player player) {
       playersStorage.put(player.getId(), player);
    }

    @Override
    public void handlePlayerDisconnection(String playerId) {

    }

    @Override
    public void startGame(Player player) {
        // Future start...
        //Future<Game> ... gameFactory.createGame(player);
        // game.play....
    }
}
