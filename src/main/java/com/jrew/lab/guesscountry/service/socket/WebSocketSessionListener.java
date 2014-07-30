package com.jrew.lab.guesscountry.service.socket;

import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface WebSocketSessionListener {

    public void sessionStored(WebSocketSession session);

    public void sessionReleased(WebSocketSession session);

}
