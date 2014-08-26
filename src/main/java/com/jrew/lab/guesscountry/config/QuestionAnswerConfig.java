package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.questionanswer.CountryLocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.questionanswer.CountryQuestionAnswer;
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
        return new CountryQuestionAnswer("Belarus", "Belarus");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question1_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question1_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }


    // Question 2
    @Bean
    public QuestionAnswer question2_en() {
        return new CountryQuestionAnswer("Russia", "Russia");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question2_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question2_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }


    // Question 3
    @Bean
    public QuestionAnswer question3_en() {
        return new CountryQuestionAnswer("Ukraine", "Ukraine");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question3_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question3_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }


    // Question 4
    @Bean
    public QuestionAnswer question4_en() {
        return new CountryQuestionAnswer("Georgia", "Georgia");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question4_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question4_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 5
    @Bean
    public QuestionAnswer question5_en() {
        return new CountryQuestionAnswer("Poland", "Poland");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question5_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question5_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 6
    @Bean
    public QuestionAnswer question6_en() {
        return new CountryQuestionAnswer("Netherlands", "The Netherlands");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question6_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question6_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 7
    @Bean
    public QuestionAnswer question7_en() {
        return new CountryQuestionAnswer("Australia", "Australia");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question7_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question7_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

    // Question 8
    @Bean
    public QuestionAnswer question8_en() {
        return new CountryQuestionAnswer("Vietnam", "Vietnam");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question8_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question8_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }

}
