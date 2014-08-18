package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Kazak_VV on 06.08.2014.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageHandlerType {

    GameMessage.Type type();
}
