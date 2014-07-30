package com.jrew.lab.guesscountry.service.socket;

import org.springframework.web.socket.WebSocketSession;

import java.util.Optional;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface WebSocketSessionStorage {

    /**
     *
     * @param session
     */
    public void storeSession(WebSocketSession session);

    /**
     *
     * @param session
     */
    public void releaseSession(WebSocketSession session);

    /**
     *
     * @param sessionId
     * @return
     */
    public Optional<WebSocketSession> getSession(String sessionId);

    /**
     *
     * @param listener
     */
    public void registerSessionListener(WebSocketSessionListener listener);

    /**
     *
     * @param listener
     */
    public void unregisterSessionListener(WebSocketSessionListener listener);
}
