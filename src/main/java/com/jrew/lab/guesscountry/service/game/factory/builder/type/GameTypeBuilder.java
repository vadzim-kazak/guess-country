package com.jrew.lab.guesscountry.service.game.factory.builder.type;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameTypeBuilder {

    /**
     *
     * @param player
     * @return
     */
    public Game createGame(Player player);

}
