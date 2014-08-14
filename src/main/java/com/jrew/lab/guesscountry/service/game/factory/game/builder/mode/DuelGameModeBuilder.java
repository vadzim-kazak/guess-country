package com.jrew.lab.guesscountry.service.game.factory.game.builder.mode;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.event.GameReadyEvent;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
import com.jrew.lab.guesscountry.service.game.messagehandler.MessageHandlerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component(value = "DUEL")
public class DuelGameModeBuilder extends AbstractGameModeBuilder {

    /** **/
    @Autowired
    private MessageHandlerProvider messageHandlerProvider;

    /** **/
    @Autowired
    private GameMessageFactory gameMessageFactory;

    /** **/
    private Logger logger = LoggerFactory.getLogger(DuelGameModeBuilder.class);

    /** **/
    private Map<GameSettings, Game> awaitingGames = new ConcurrentHashMap<>();

    @Override
    public void buildGame(Player player) {

        GameSettings gameSettings = player.getGameSettings();
        if (awaitingGames.containsKey(gameSettings)) {

            // Someone is waiting for second player connection to start game
            completeGameCreation(player, awaitingGames.get(gameSettings));

        } else {

            super.buildGame(player);
        }
    }

    @Override
    void processCreatedGame(Game game, Player player) {

        // Hold game until second player connected
        GameSettings gameSettings = player.getGameSettings();
        awaitingGames.put(gameSettings, game);
        logger.debug("Player {} is waiting for other player connection...", player.getName());

        GameMessage gameMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.WAITING_FOR_OTHER_PLAYER);
        messageHandlerProvider.handleMessage(gameMessage, game);
    }

    /**
     *
     * @param secondPlayer
     * @param heldGame
     */
    private void completeGameCreation(Player secondPlayer, Game heldGame){
        logger.debug("Second player {} has been connected to game. Game is ready to start.", secondPlayer.getName());
        heldGame.addPlayer(secondPlayer);

        //Remove game from held games list
        awaitingGames.remove(secondPlayer.getGameSettings());

        getApplicationEventPublisher().publishEvent(new GameReadyEvent(heldGame));
    }

}
