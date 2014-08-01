package com.jrew.lab.guesscountry.model.settings;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameSettings {

    /** **/
    public enum GameMode {SINGLE, DUEL};

    /** **/
    public enum GameType {CITIES, FLAGS};

    GameMode getGameMode();

    void setGameMode(GameMode gameMode);

    GameType getGameType();

    void setGameType(GameType gameType);
}
