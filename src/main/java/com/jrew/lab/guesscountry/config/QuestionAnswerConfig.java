package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.questionanswer.CityLocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.CityQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Configuration
public class QuestionAnswerConfig {

    // Question 1
    @Bean
    public QuestionAnswer question1_en() {
        return new CityQuestionAnswer("Minsk", "Belarus");
    }

    @Bean
    public QuestionAnswer question1_ru() {
        return new CityQuestionAnswer("Минск", "Беларусь");
    }

    @Bean
    public CityLocalizedQuestionAnswer question1_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question1_en());
        qaStorage.put("ru", question1_ru());
        return new CityLocalizedQuestionAnswer(qaStorage);
    }


    // Question 2
    @Bean
    public QuestionAnswer question2_en() {
        return new CityQuestionAnswer("Moscow", "Russia");
    }

    @Bean
    public QuestionAnswer question2_ru() {
        return new CityQuestionAnswer("Москва", "Россия");
    }

    @Bean
    public CityLocalizedQuestionAnswer question2_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question2_en());
        qaStorage.put("ru", question2_ru());
        return new CityLocalizedQuestionAnswer(qaStorage);
    }


    // Question 3
    @Bean
    public QuestionAnswer question3_en() {
        return new CityQuestionAnswer("Kiev", "Ukraine");
    }

    @Bean
    public QuestionAnswer question3_ru() {
        return new CityQuestionAnswer("Киев", "Украина");
    }

    @Bean
    public CityLocalizedQuestionAnswer question3_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question3_en());
        qaStorage.put("ru", question3_ru());
        return new CityLocalizedQuestionAnswer(qaStorage);
    }


    // Question 4
    @Bean
    public QuestionAnswer question4_en() {
        return new CityQuestionAnswer("Tbilisi", "Georgia");
    }

    @Bean
    public QuestionAnswer question4_ru() {
        return new CityQuestionAnswer("Тбилиси", "Украина");
    }

    @Bean
    public CityLocalizedQuestionAnswer question4_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question4_en());
        qaStorage.put("ru", question4_ru());
        return new CityLocalizedQuestionAnswer(qaStorage);
    }

}
