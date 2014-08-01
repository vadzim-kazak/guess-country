package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.event.GameMessageEvent;
import com.jrew.lab.guesscountry.service.game.helper.RoundProcessor;
import org.springframework.context.ApplicationListener;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface Game extends ApplicationListener<GameMessageEvent> {

    /**
     *
     */
    public void start();

    /**
     *
     * @param player
     */
    public void addPlayer(Player player);

    /**
     *
     * @param playerId
     * @param message
     */
    public void processMessage(String playerId, GameMessage message);

    /**
     *
     */
    public void setRoundProcessor(RoundProcessor roundProcessor);
}
