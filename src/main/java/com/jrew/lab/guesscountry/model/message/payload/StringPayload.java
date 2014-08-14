package com.jrew.lab.guesscountry.model.message.payload;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StringPayload {

    /** **/
    private String message;

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
}
