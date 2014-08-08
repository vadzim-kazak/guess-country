package com.jrew.lab.guesscountry.model.player;

import com.jrew.lab.guesscountry.model.settings.GameSettings;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface Player {

    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);

    public String getLocale();

    public void setLocale(String locale);

    public GameSettings getGameSettings();

    public void setGameSettings(GameSettings gameSettings);

    public void setWebSocketSession(WebSocketSession webSocketSession);

    public WebSocketSession getWebSocketSession();

    public int getScores();

    public void setScores(int scores);
}
