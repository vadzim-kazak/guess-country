package com.jrew.lab.guesscountry.service.game.factory.builder.type;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component(value = "CITIES")
public class CitiesTypeGameBuilder implements GameTypeBuilder {

    @Override
    public Game createGame(Player player) {
        return null;
    }
}
