package com.jrew.lab.guesscountry.service.game.factory.builder.type;

import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.GameImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component(value = "CITIES")
public class CitiesTypeGameBuilder implements GameTypeBuilder {

    /** **/
    private Logger logger = LoggerFactory.getLogger(CitiesTypeGameBuilder.class);

    /** **/
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Game createGame(GameSettings gameSettings) {
        logger.debug("Create game inside of CitiesTypeGameBuilder#buildGame method...");
        return applicationContext.getBean(GameImpl.class);
    }
}