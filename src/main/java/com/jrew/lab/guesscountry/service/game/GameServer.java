package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.event.GameReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.TextMessage;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface GameServer extends ApplicationListener<GameReadyEvent> {

    /**
     *
     * @param player
     */
    public void handlePlayerConnection(Player player);

    /**
     *
     * @param playerId
     */
    public void handlePlayerDisconnection(String playerId);

    /**
     *
     * @param player
     */
    public void prepareGame(Player player);

    /**
     *
     * @param playerId
     * @param message
     */
    public void handlePlayerMessage(String playerId, TextMessage message);

}
