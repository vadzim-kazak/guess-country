package com.jrew.lab.guesscountry.model.settings;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface GameSettings {

    GameSettingsImpl.GameMode getGameMode();

    void setGameMode(GameSettingsImpl.GameMode gameMode);

    GameSettingsImpl.GameType getGameType();

    void setGameType(GameSettingsImpl.GameType gameType);
}
