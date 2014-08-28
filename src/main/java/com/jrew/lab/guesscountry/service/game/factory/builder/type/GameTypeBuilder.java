package com.jrew.lab.guesscountry.service.game.factory.builder.type;

import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameTypeBuilder {

    /**
     *
     *
     * @param gameSettings
     * @return
     */
    public Game createGame(GameSettings gameSettings);

}
