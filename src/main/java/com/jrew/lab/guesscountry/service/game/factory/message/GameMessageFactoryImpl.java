package com.jrew.lab.guesscountry.service.game.factory.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.factory.message.builder.GameMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
@Component
public class GameMessageFactoryImpl implements GameMessageFactory {

    /** **/
    private Logger logger = LoggerFactory.getLogger(GameMessageFactoryImpl.class);

    /**
     *
     */
    public interface PayloadKeys {

        /** **/
        public static final String TYPE_KEY = "type";
    }

    /** **/
    @Autowired
    private ApplicationContext applicationContext;

    /** **/
    @Autowired
    private Map<String, GameMessageBuilder> messageBuilders;

    /** **/
    private ObjectMapper mapper;

    @PostConstruct
    private void init() {
        mapper = new ObjectMapper();
    }

    @Override
    public GameMessage buildMessage(GameMessage.Type type) {

        return (GameMessage) applicationContext.getBean(type.toString());
    }

    @Override
    public Optional<GameMessage> buildMessage(String payload, Player player) {

        try {
            JsonNode payloadJson = mapper.readTree(payload);

            if (payloadJson.has(PayloadKeys.TYPE_KEY)) {

                JsonNode typeKey = payloadJson.get(PayloadKeys.TYPE_KEY);
                String messageType = typeKey.textValue();

                return Optional.of(messageBuilders.get(messageType).build(payloadJson, player));
            }


        } catch (IOException exception) {
            logger.error(exception.getMessage(), exception);
        }

        return Optional.empty();
    }
}