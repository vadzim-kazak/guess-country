package com.jrew.lab.guesscountry.model.player;

import com.jrew.lab.guesscountry.model.settings.GameSettings;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface Player {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getLocale();

    void setLocale(String locale);

    GameSettings getGameSettings();

    void setGameSettings(GameSettings gameSettings);

    void setWebSocketSession(WebSocketSession webSocketSession);

    WebSocketSession getWebSocketSession();
}
