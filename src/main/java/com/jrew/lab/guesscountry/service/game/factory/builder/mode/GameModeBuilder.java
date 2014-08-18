package com.jrew.lab.guesscountry.service.game.factory.builder.mode;

import com.jrew.lab.guesscountry.model.player.Player;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameModeBuilder extends ApplicationEventPublisherAware {

    /**
     *
     * @param player
     * @return
     */
    public void buildGame(Player player);

}
