package com.jrew.lab.guesscountry.service.game.helper;

import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 08.08.2014.
 */
public interface CountDownHelper {

    /**
     *
     */
    public void performCountDown(Runnable action);

    /**
     *
     * @param game
     */
    public void setGame(Game game);
}
