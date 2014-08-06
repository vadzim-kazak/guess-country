package com.jrew.lab.guesscountry.util.spring;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.service.game.messagehandler.GameMessageHandler;
import com.jrew.lab.guesscountry.service.game.messagehandler.MessageHandlerType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Map;

/**
 * Created by Kazak_VV on 06.08.2014.
 */
public class GameMessageHandlersBeanPostProcessor implements BeanPostProcessor {

    /** **/
    private Map<GameMessage.Type, GameMessageHandler> messageHandlers;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(MessageHandlerType.class)) {
            MessageHandlerType messageHandlerType = beanClass.getAnnotation(MessageHandlerType.class);
            GameMessageHandler messageHandler = (GameMessageHandler) bean;
            messageHandlers.put(messageHandlerType.type(), messageHandler);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     *
     * @param messageHandlers
     */
    public void setMessageHandlers(Map<GameMessage.Type, GameMessageHandler> messageHandlers) {
        this.messageHandlers = messageHandlers;
    }
}
