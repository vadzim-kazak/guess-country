package com.jrew.lab.guesscountry.service.game.factory;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameFactory {

    /**
     *
     * @param player
     * @return
     */
    public void buildGame(Player player);

}
