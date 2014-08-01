package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.player.Player;
import org.springframework.context.ApplicationListener;

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

}
