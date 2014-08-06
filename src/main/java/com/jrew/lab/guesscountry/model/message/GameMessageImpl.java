package com.jrew.lab.guesscountry.model.message;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
public class GameMessageImpl<T> implements GameMessage<T> {

    /** **/
    private Type type;

    /** **/
    private T payload;

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public T getPayload() {
        return payload;
    }

    @Override
    public void setPayload(T payload) {
        this.payload = payload;
    }
}
