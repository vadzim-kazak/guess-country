package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.player.Player;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface Game {

    /**
     *
     */
    public void start();

    /**
     *
     * @param player
     */
    public void addPlayer(Player player);
}
