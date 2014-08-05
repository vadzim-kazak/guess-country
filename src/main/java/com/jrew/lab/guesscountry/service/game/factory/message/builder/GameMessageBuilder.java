package com.jrew.lab.guesscountry.service.game.factory.message.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;

import java.util.Optional;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
public interface GameMessageBuilder<T> {

    /**
     *
     * @param payload
     * @param player
     * @return
     */
    public GameMessage<T> build(JsonNode payload, Player player);

}
