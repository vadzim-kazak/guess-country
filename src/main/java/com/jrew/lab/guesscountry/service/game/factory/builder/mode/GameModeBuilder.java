package com.jrew.lab.guesscountry.service.game.factory.builder.mode;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameModeBuilder {

    /**
     *
     * @param player
     * @return
     */
    public Game createGame(Player player);

}
