package com.jrew.lab.guesscountry.model.settings;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.PostConstruct;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public class GameSettingsImpl implements GameSettings {

    /** **/
    private GameMode gameMode;

    /** **/
    private GameType gameType;

    /**
     *
     */
    public GameSettingsImpl() {}

    @PostConstruct
    private void applyDefaultSettings() {
        gameMode = GameMode.DUEL;
        gameType = GameType.COUNTRY;
    }

    /**
     *
     * @return
     */
    @Override
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     *
     * @param gameMode
     */
    @Override
    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    /**
     *
     * @return
     */
    @Override
    public GameType getGameType() {
        return gameType;
    }

    /**
     *
     * @param gameType
     */
    @Override
    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(17, 31) // two randomly chosen prime numbers
                   .append(gameMode)
                   .append(gameType)
                   .toHashCode();
    }

    @Override
    public boolean equals(Object object) {

        if (object == null || !(object instanceof GameSettings)) {
            return false;
        }

        if (object == this) {
            return true;
        }

        GameSettings anotherGameSettings = (GameSettings) object;
        return new EqualsBuilder()
                   .append(gameMode, anotherGameSettings.getGameMode())
                   .append(gameType, anotherGameSettings.getGameType())
                   .isEquals();
    }
}
