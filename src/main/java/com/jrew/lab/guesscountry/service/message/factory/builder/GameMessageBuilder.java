package com.jrew.lab.guesscountry.service.message.factory.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;

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
