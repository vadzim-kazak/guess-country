package com.jrew.lab.guesscountry.service.game.factory.game.builder.mode;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.model.settings.GameSettingsImpl;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.factory.game.builder.type.GameTypeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Map;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
public abstract class AbstractGameModeBuilder implements GameModeBuilder {

    /** **/
    @Autowired
    protected Map<String, GameTypeBuilder> buildersStorage;

    /** **/
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void buildGame(Player player) {

        GameSettings gameSettings = player.getGameSettings();
        GameSettingsImpl.GameType gameType = gameSettings.getGameType();
        Game game = buildersStorage.get(gameType.toString()).createGame(gameSettings);
        game.addPlayer(player);

        processCreatedGame(game, player);
    }

    /**
     *
     * @param game
     * @param player
     */
    abstract void processCreatedGame(Game game, Player player);

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     *
     * @return
     */
    protected ApplicationEventPublisher getApplicationEventPublisher() {
        return applicationEventPublisher;
    }
}
