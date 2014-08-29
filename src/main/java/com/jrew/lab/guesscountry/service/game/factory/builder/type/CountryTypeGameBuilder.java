package com.jrew.lab.guesscountry.service.game.factory.builder.type;

import com.jrew.lab.guesscountry.model.questionanswer.CountryQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.questionanswer.CountriesDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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

    @Autowired
    CountriesDictionary countriesDictionary;

    /** **/
    private List<QuestionAnswer> questionAnswers = new ArrayList<>();

    @Value(value = "${game.questions.number}")
    private int questionsNumber;

    @PostConstruct
    private void init() {

        countriesDictionary.getCountriesInfo().stream().forEach(countryInfo -> {

            CountryQuestionAnswer countryQuestionAnswer = new CountryQuestionAnswer(countryInfo.getName(),
                    countryInfo.getDomain());
            countryQuestionAnswer.setLatLng(countryInfo.getCenter());

            questionAnswers.add(countryQuestionAnswer);
        });
    }

    @Override
    public Game createGame(GameSettings gameSettings) {
        logger.debug("Create game inside of CountryTypeGameBuilder#buildGame method...");
        Game game = applicationContext.getBean(Game.class);

        Collections.shuffle(questionAnswers);
        if (questionAnswers.size() > questionsNumber) {
            List<QuestionAnswer> questionAnswersPart = questionAnswers.subList(0, questionsNumber);
            game.setQuestionAnswers(new ArrayList<>(questionAnswersPart));
        } else {
            game.setQuestionAnswers(questionAnswers);
        }

        return game;
    }
}
