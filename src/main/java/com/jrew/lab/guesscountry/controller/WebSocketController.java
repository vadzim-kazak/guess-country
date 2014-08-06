package com.jrew.lab.guesscountry.controller;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.GameServer;
import com.jrew.lab.guesscountry.util.HttpSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /** **/
    private Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    /** **/
    @Autowired
    private GameServer gameServer;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("Connection has been established. Session id = {}", session.getId());
        gameServer.handlePlayerConnection(updatePlayer(session));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        logger.debug("Following message for session id = {} has been received: {}", session.getId(), message.getPayload().toString());
        gameServer.handlePlayerMessage(session.getId(), message.getPayload().toString());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.debug("Connection has been closed. Session id = {}", session.getId());
        gameServer.handlePlayerDisconnection(session.getId());
    }

    /**
     *
     * @param session
     * @return
     */
    private Player updatePlayer(WebSocketSession session) {

        Player player = (Player) session.getAttributes().get(HttpSessionManager.SessionKey.PLAYER_KEY);
        player.setId(session.getId());
        player.setWebSocketSession(session);
        return player;
    }

}
