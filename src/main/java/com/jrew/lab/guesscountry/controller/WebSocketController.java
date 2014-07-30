package com.jrew.lab.guesscountry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Controller
public class WebSocketController extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("Connection has been established. Session id = {}", session.getId());
        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.debug("Following message for session id = {} has been received: {}", session.getId(), message.getPayload().toString());
        super.handleMessage(session, message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.debug("Connection has been closed. Session id = {}", session.getId());
        super.afterConnectionClosed(session, status);
    }
}
