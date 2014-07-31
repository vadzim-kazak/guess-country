package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.player.PlayerImpl;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.model.settings.GameSettingsImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Configuration
@ComponentScan(basePackages = "com.jrew.lab.guesscountry")
public class ApplicationConfig {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public Player getPlayer() {
        Player player = new PlayerImpl();
        player.setGameSettings(getGameSettings());
        return player;
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameSettings getGameSettings() {
        return new GameSettingsImpl();
    }
}
