package com.jrew.lab.guesscountry.service.game.messagehandler.helper;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 12.08.2014.
 */
public interface AnswerCounter {

    /**
     *
     * @param player
     * @param game
     * @return
     */
    public boolean canAnswer(Player player, Game game);

    /**
     *
     * @param player
     * @param game
     */
    public void countAnswer(Player player, Game game);

    /**
     *
     * @param game
     */
    public void reset(Game game);
}
