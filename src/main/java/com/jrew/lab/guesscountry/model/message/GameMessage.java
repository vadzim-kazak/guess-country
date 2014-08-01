package com.jrew.lab.guesscountry.model.message;

import com.jrew.lab.guesscountry.model.player.Player;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
public interface GameMessage {

    enum Type {QUESTION, ANSWER}

    /**
     *
     * @param player
     */
    public void setPlayer(Player player);

    /**
     *
     * @return
     */
    public Player getPlayer();

    /**
     *
     * @param type
     */
    public void setType(Type type);

    /**
     *
     * @return
     */
    public Type getType();

}
