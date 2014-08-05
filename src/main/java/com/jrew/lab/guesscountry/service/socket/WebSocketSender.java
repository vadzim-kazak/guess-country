package com.jrew.lab.guesscountry.service.socket;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
public interface WebSocketSender {

    /**
     *
     * @param gameMessage
     * @param webSocketSession
     * @param <T>
     */
    public <T> void sendMessage(GameMessage<T> gameMessage, WebSocketSession webSocketSession);

}
