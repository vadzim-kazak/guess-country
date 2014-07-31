package com.jrew.lab.guesscountry.model.settings;

import javax.annotation.PostConstruct;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public class GameSettingsImpl implements GameSettings {

    /** **/
    public enum GameMode {SINGLE, DUEL};

    /** **/
    public enum GameType {CITIES, FLAGS};

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
        gameType = GameType.CITIES;
        System.out.println("GameSettings#applyDefaultSettings");
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
}
