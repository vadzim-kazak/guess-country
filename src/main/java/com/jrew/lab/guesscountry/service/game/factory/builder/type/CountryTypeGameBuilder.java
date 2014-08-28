package com.jrew.lab.guesscountry.service.game.factory.builder.type;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.service.game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component(value = "COUNTRY")
public class CountryTypeGameBuilder implements GameTypeBuilder {

    /** **/
    private Logger logger = LoggerFactory.getLogger(CountryTypeGameBuilder.class);

    /** **/
    @Autowired
    private ApplicationContext applicationContext;

    /** **/
    @Autowired
    private List<LocalizedQuestionAnswer> questionAnswers;

    /** **/
    //@Value("#{configProperties['game.questions.number']}")
    private static final int QUESTIONS_NUMBER = 30;

    @Override
    public Game createGame(GameSettings gameSettings) {
        logger.debug("Create game inside of CountryTypeGameBuilder#buildGame method...");
        Game game = applicationContext.getBean(Game.class);

        Collections.shuffle(questionAnswers);
        if (questionAnswers.size() > QUESTIONS_NUMBER) {
            game.setQuestionAnswers(questionAnswers.subList(0, QUESTIONS_NUMBER - 1));
        } else {
            game.setQuestionAnswers(questionAnswers);
        }

        return game;
    }
}
