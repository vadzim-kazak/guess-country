package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.player.Player;
import org.springframework.web.socket.TextMessage;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface GameServer {

    /**
     *
     * @param player
     */
    public void handlePlayerConnection(Player player);

    /**
     *
     * @param playerId
     */
    public void handlePlayerDisconnection(String playerId);

    /**
     *  @param playerId
     * @param message
     */
    public void handlePlayerMessage(String playerId, String message);

}
