package com.jrew.lab.guesscountry.service.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Component
public class WebSocketSessionStorageImpl implements WebSocketSessionStorage {

    /** **/
    private Logger logger = LoggerFactory.getLogger(WebSocketSessionStorageImpl.class);

    /** **/
    private Map<String, WebSocketSession> sessionStorage = new ConcurrentHashMap<>();

    /** **/
    private List<WebSocketSessionListener> listenersStorage = new LinkedList<>();

    @Override
    public void storeSession(WebSocketSession session) {

        sessionStorage.put(session.getId(), session);
        logger.debug("Session with id = {} has been stored into WebSocketSessionStorage.", session.getId());

        listenersStorage.stream().forEach(listener -> listener.sessionStored(session));
    }

    @Override
    public void releaseSession(WebSocketSession session) {

        sessionStorage.remove(session);
        logger.debug("Session with id = {} has been released from WebSocketSessionStorage.", session.getId());

        listenersStorage.stream().forEach(listener -> listener.sessionReleased(session));
    }

    @Override
    public Optional<WebSocketSession> getSession(String sessionId) {

        Optional<WebSocketSession> sessionOptional = Optional.of(sessionStorage.get(sessionId));
        sessionOptional.ifPresent(session -> logger.debug("Session with id = {} has been fetched from WebSocketSessionStorage."));

        return sessionOptional;
    }

    @Override
    public void registerSessionListener(WebSocketSessionListener listener) {
        listenersStorage.add(listener);
    }

    @Override
    public void unregisterSessionListener(WebSocketSessionListener listener) {
        listenersStorage.remove(listener);
    }
}
