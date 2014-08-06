package com.jrew.lab.guesscountry.service.game.factory.message;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;

import java.util.Optional;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
public interface GameMessageFactory {

    /**
     *
     * @param type
     * @return
     */
    public GameMessage buildMessage(GameMessage.Type type);

    /**
     *
     * @param payload
     * @param player
     * @return
     */
    public GameMessage buildMessage(String payload, Player player);

}
