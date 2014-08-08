package com.jrew.lab.guesscountry.model.player;

import com.jrew.lab.guesscountry.model.settings.GameSettings;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    /** **/
    private int scores;

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

    @Override
    public int getScores() {
        return scores;
    }

    @Override
    public void setScores(int scores) {
        this.scores = scores;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(19, 33) // two randomly chosen prime numbers
                .append(id)
                .append(name)
                .append(locale)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {

        if (object == null || !(object instanceof Player)) {
            return false;
        }

        if (object == this) {
            return true;
        }

        Player anotherPlayer = (Player) object;
        return new EqualsBuilder()
                .append(id, anotherPlayer.getId())
                .isEquals();
    }
}
