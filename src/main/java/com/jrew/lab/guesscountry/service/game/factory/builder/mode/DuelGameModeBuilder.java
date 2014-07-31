package com.jrew.lab.guesscountry.service.game.factory.builder.mode;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component(value = "DUEL")
public class DuelGameModeBuilder implements GameModeBuilder {

    @Override
    public Game createGame(Player player) {

        return null;
    }
}
