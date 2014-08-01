package com.jrew.lab.guesscountry.model.player;

import com.jrew.lab.guesscountry.model.settings.GameSettings;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public class PlayerImpl implements Player {

    /** **/
    private String id;

    /** **/
    private String name;

    /** **/
    private String locale;

    /** **/
    private GameSettings gameSettings;

    /** **/
    private WebSocketSession webSocketSession;

    /**
     *
     */
    public PlayerImpl() {}

    @PostConstruct
    private void applyDefaultSettings() {
        locale = "en";
    }

    /**
     *
     * @return
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getLocale() {
        return locale;
    }

    /**
     *
     * @param locale
     */
    @Override
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     *
     * @return
     */
    @Override
    public GameSettings getGameSettings() {
        return gameSettings;
    }

    /**
     *
     * @param gameSettings
     */
    @Override
    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    @Override
    public void setWebSocketSession(WebSocketSession webSocketSession) {
        this.webSocketSession = webSocketSession;
    }

    @Override
    public WebSocketSession getWebSocketSession() {
        return webSocketSession;
    }
}