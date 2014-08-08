package com.jrew.lab.guesscountry.model.message;

import com.jrew.lab.guesscountry.model.player.Player;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
public interface GameMessage<T> {

    /** **/
    enum Type {QUESTION, ANSWER, RESULT, CHAT_MESSAGE, COUNTDOWN, GAME_FINISHED}

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

    /**
     *
     * @return
     */
    public T getPayload();

    /**
     *
     * @param payload
     */
    public void setPayload(T payload);

}
