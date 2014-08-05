package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;

import java.util.List;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
public interface GameMessageHandler<T> {

    /**
     *  @param message
     * @param game
     */
    public void handleMessage(GameMessage<T> message, Game game);

}
