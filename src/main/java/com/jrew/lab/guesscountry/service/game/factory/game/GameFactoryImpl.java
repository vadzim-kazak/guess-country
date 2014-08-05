package com.jrew.lab.guesscountry.service.game.factory.game;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.model.settings.GameSettingsImpl;
import com.jrew.lab.guesscountry.service.game.event.GameReadyEvent;
import com.jrew.lab.guesscountry.service.game.factory.game.builder.mode.GameModeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component
public class GameFactoryImpl implements GameFactory {

    @Autowired
    private Map<String, GameModeBuilder> buildersStorage;

    /** **/
    private Consumer<GameReadyEvent> gameReadyHandler;

    @Override
    public void buildGame(Player player, Consumer<GameReadyEvent> gameReadyHandler) {

        GameSettings gameSettings = player.getGameSettings();
        GameSettingsImpl.GameMode gameMode = gameSettings.getGameMode();
        buildersStorage.get(gameMode.toString()).buildGame(player);

        this.gameReadyHandler = gameReadyHandler;
    }

    @Override
    public void onApplicationEvent(GameReadyEvent gameReadyEvent) {
        gameReadyHandler.accept(gameReadyEvent);
    }
}