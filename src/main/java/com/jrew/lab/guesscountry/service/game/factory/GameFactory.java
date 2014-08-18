package com.jrew.lab.guesscountry.service.game.factory;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.event.GameReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.function.Consumer;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameFactory extends ApplicationListener<GameReadyEvent> {

    /**
     *
     * @param player
     * @return
     */
    public void buildGame(Player player, Consumer<GameReadyEvent> gameReadyHandler);
}
