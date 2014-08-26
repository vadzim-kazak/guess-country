package com.jrew.lab.guesscountry.model.message.payload;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 06.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CountdownPayload {

    /**
     *
     */
    public enum CountdownType {

        /** **/
        PREPARE_TO_QUESTION,

        /** **/
        QUESTION_TIMEOUT
    };

    /** **/
    private int seconds;

    /** **/
    private CountdownType type;

    /**
     *
     * @return
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     *
     * @param seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     *
     * @return
     */
    public CountdownType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(CountdownType type) {
        this.type = type;
    }
}
