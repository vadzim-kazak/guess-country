package com.jrew.lab.guesscountry.service.message.factory;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
public interface GameMessageFactory {

    /**
     *
     * @param type
     * @return
     */
    public GameMessage buildServerMessage(GameMessage.Type type);

    /**
     *
     * @param payload
     * @param player
     * @return
     */
    public GameMessage buildClientMessage(String payload, Player player);

}
