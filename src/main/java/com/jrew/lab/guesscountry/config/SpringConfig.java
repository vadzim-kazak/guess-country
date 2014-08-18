package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.service.message.factory.builder.GameMessageBuilder;
import com.jrew.lab.guesscountry.service.message.handler.GameMessageHandler;
import com.jrew.lab.guesscountry.util.spring.GameMessageBuildersBeanPostProcessor;
import com.jrew.lab.guesscountry.util.spring.GameMessageHandlersBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Kazak_VV on 06.08.2014.
 */
@Configuration
public class SpringConfig {

    @Bean(name = "messageBuilders")
    public Map<GameMessage.Type, GameMessageBuilder> getGameMessageBuilders() {
        return new EnumMap<GameMessage.Type, GameMessageBuilder>(GameMessage.Type.class);
    }

    @Bean
    public BeanPostProcessor getGameMessageBuildersBeanFactoryPostProcessor() {

        GameMessageBuildersBeanPostProcessor gameMessageBuildersBeanPostProcessor = new GameMessageBuildersBeanPostProcessor();
        gameMessageBuildersBeanPostProcessor.setMessageBuilders(getGameMessageBuilders());

        return gameMessageBuildersBeanPostProcessor;
    }

    @Bean(name = "messageHandlers")
    public Map<GameMessage.Type, GameMessageHandler> getGameMessageHandlers() {
        return new EnumMap<GameMessage.Type, GameMessageHandler>(GameMessage.Type.class);
    }

    @Bean
    public BeanPostProcessor getGameMessageHandlersBeanFactoryPostProcessor() {

        GameMessageHandlersBeanPostProcessor gameMessageHandlersBeanPostProcessor = new GameMessageHandlersBeanPostProcessor();
        gameMessageHandlersBeanPostProcessor.setMessageHandlers(getGameMessageHandlers());

        return gameMessageHandlersBeanPostProcessor;
    }
}
