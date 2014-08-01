package com.jrew.lab.guesscountry.service.game.factory;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.model.settings.GameSettingsImpl;
import com.jrew.lab.guesscountry.service.game.factory.builder.mode.GameModeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component
public class GameFactoryImpl implements GameFactory {

    @Autowired
    private Map<String, GameModeBuilder> buildersStorage;

    @Override
    public void buildGame(Player player) {

        GameSettings gameSettings = player.getGameSettings();
        GameSettingsImpl.GameMode gameMode = gameSettings.getGameMode();

        buildersStorage.get(gameMode.toString()).buildGame(player);
    }
}
