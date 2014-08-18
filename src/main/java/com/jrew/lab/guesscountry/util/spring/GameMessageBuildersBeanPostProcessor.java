package com.jrew.lab.guesscountry.util.spring;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.service.message.factory.builder.GameMessageBuilder;
import com.jrew.lab.guesscountry.service.message.factory.builder.MessageBuilderType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by Kazak_VV on 06.08.2014.
 */
public class GameMessageBuildersBeanPostProcessor implements BeanPostProcessor {

    /** **/
    private Map<GameMessage.Type, GameMessageBuilder> messageBuilders;

    @Autowired
    ApplicationContext applciationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {

        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(MessageBuilderType.class)) {
            MessageBuilderType messageBuilderType = beanClass.getAnnotation(MessageBuilderType.class);
            GameMessageBuilder messageBuilder = (GameMessageBuilder) bean;
            messageBuilders.put(messageBuilderType.type(), messageBuilder);
        }

        return bean;
    }

    /**
     *
     * @param messageBuilders
     */
    public void setMessageBuilders(Map<GameMessage.Type, GameMessageBuilder> messageBuilders) {
        this.messageBuilders = messageBuilders;
    }
}
