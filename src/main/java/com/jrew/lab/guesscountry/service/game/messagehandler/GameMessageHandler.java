package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;

import java.util.List;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
public interface GameMessageHandler {

    /**
     *
     * @param message
     * @param players
     */
    public void handleMessage(GameMessage message, List<Player> players);

}
