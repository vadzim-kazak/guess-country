package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.GameMessageImpl;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.factory.GameFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

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
    private ApplicationContext applicationContext;

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

        activeGames.stream().filter(game -> game.hasPlayer(playerId)).forEach(game -> {

            GameMessage gameMessage = applicationContext.getBean(GameMessage.class);
            gameMessage.setType(GameMessage.Type.ANSWER);
            gameMessage.setPlayer(playersStorage.get(playerId));
            gameMessage.setMessage(message);

            game.handleMessage(gameMessage);
        });
    }

}
