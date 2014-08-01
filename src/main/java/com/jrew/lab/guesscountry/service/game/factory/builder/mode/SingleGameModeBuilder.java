package com.jrew.lab.guesscountry.service.game.factory.builder.mode;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.GameReadyEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component(value = "SINGLE")
public class SingleGameModeBuilder extends AbstractGameModeBuilder {

    @Override
    void processCreatedGame(Game game, Player player) {
        getApplicationEventPublisher().publishEvent(new GameReadyEvent(game));
    }
}
