package com.jrew.lab.guesscountry.service.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
@Component
public class WebSocketSenderImpl implements WebSocketSender {

    /** **/
    private Logger logger = LoggerFactory.getLogger(WebSocketSenderImpl.class);

    /** **/
    private ObjectMapper mapper;

    /** **/
    @PostConstruct
    private void init() {
        mapper = new ObjectMapper();
    }

    @Override
    public <T> void sendMessage(GameMessage<T> gameMessage, WebSocketSession webSocketSession) {

        try {

            String jsonMessage = mapper.writeValueAsString(gameMessage);
            webSocketSession.sendMessage(new TextMessage(jsonMessage));

        } catch (JsonProcessingException exception) {
            logger.error(exception.toString(), exception);
        } catch (IOException exception) {
            logger.error(exception.toString(), exception);
        }
    }
}
