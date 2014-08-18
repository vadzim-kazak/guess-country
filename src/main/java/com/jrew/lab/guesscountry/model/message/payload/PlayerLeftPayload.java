package com.jrew.lab.guesscountry.model.message.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 18.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlayerLeftPayload {

    /** **/
    @JsonIgnore
    private String playerId;

    /** **/
    private String message;

    /** **/
    @JsonIgnore
    private Runnable finishGameEvent;

    /**
     *
     * @return
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     *
     * @param playerId
     */
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public Runnable getFinishGameEvent() {
        return finishGameEvent;
    }

    /**
     *
     * @param finishGameEvent
     */
    public void setFinishGameEvent(Runnable finishGameEvent) {
        this.finishGameEvent = finishGameEvent;
    }
}
