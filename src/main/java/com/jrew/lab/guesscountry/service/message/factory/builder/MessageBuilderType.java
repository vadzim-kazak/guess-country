package com.jrew.lab.guesscountry.service.message.factory.builder;

import com.jrew.lab.guesscountry.model.message.GameMessage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Kazak_VV on 06.08.2014.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageBuilderType {

    /**
     *
     * @return
     */
    GameMessage.Type type();

}
