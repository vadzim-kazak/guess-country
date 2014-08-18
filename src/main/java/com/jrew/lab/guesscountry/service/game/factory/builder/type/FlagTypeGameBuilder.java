package com.jrew.lab.guesscountry.service.game.factory.builder.type;

import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.service.game.Game;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component(value = "FLAGS")
public class FlagTypeGameBuilder implements GameTypeBuilder {

    @Override
    public Game createGame(GameSettings gameSettings) {
        return null;
    }
}
