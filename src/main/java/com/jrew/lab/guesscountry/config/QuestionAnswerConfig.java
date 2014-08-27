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
        return new CountryQuestionAnswer("Belarus", "by");
    }

    @Bean
    public CountryLocalizedQuestionAnswer question1_localized() {

        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
        qaStorage.put("en", question1_en());
        return new CountryLocalizedQuestionAnswer(qaStorage);
    }


//    // Question 2
//    @Bean
//    public QuestionAnswer question2_en() {
//        return new CountryQuestionAnswer("Russia", "ru");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question2_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question2_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//
//    // Question 3
//    @Bean
//    public QuestionAnswer question3_en() {
//        return new CountryQuestionAnswer("Ukraine", "ua");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question3_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question3_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }


//    // Question 4
//    @Bean
//    public QuestionAnswer question4_en() {
//        return new CountryQuestionAnswer("Georgia", "ge");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question4_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question4_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 5
//    @Bean
//    public QuestionAnswer question5_en() {
//        return new CountryQuestionAnswer("Poland", "pl");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question5_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question5_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 6
//    @Bean
//    public QuestionAnswer question6_en() {
//        return new CountryQuestionAnswer("Netherlands", "nl");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question6_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question6_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 7
//    @Bean
//    public QuestionAnswer question7_en() {
//        return new CountryQuestionAnswer("Australia", "au");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question7_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question7_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//}
//
//    // Question 8
//    @Bean
//    public QuestionAnswer question8_en() {
//        return new CountryQuestionAnswer("Vietnam", "vn");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question8_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question8_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }

//    // Question 9
//    @Bean
//    public QuestionAnswer question9_en() {
//        return new CountryQuestionAnswer("Uganda", "ug");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question9_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question9_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 10
//    @Bean
//    public QuestionAnswer question10_en() {
//        return new CountryQuestionAnswer("Uruguay", "uy");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question10_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question10_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 11
//    @Bean
//    public QuestionAnswer question11_en() {
//        return new CountryQuestionAnswer("Canada", "ca");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question11_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question11_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 12
//    @Bean
//    public QuestionAnswer question12_en() {
//        return new CountryQuestionAnswer("Ecuador", "ec");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question12_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question12_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 13
//    @Bean
//    public QuestionAnswer question13_en() {
//        return new CountryQuestionAnswer("Egypt", "eg");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question13_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question13_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 14
//    @Bean
//    public QuestionAnswer question14_en() {
//        return new CountryQuestionAnswer("Yemen", "ye");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question14_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question14_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 15
//    @Bean
//    public QuestionAnswer question15_en() {
//        return new CountryQuestionAnswer("Nepal", "np");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question15_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question15_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 16
//    @Bean
//    public QuestionAnswer question16_en() {
//        return new CountryQuestionAnswer("Japan", "jp");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question16_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question16_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 17
//    @Bean
//    public QuestionAnswer question17_en() {
//        return new CountryQuestionAnswer("Indonesia", "id");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question17_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question17_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 18
//    @Bean
//    public QuestionAnswer question18_en() {
//        return new CountryQuestionAnswer("Mongolia", "mn");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question18_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question18_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 19
//    @Bean
//    public QuestionAnswer question19_en() {
//        return new CountryQuestionAnswer("Namibia", "na");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question19_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question19_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 20
//    @Bean
//    public QuestionAnswer question20_en() {
//        return new CountryQuestionAnswer("Chad", "td");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question20_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question20_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 21
//    @Bean
//    public QuestionAnswer question21_en() {
//        return new CountryQuestionAnswer("Mexico", "mx");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question21_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question21_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 22
//    @Bean
//    public QuestionAnswer question22_en() {
//        return new CountryQuestionAnswer("Chile", "cl");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question22_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question22_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 23
//    @Bean
//    public QuestionAnswer question23_en() {
//        return new CountryQuestionAnswer("Brazil", "br");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question23_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question23_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 24
//    @Bean
//    public QuestionAnswer question24_en() {
//        return new CountryQuestionAnswer("Argentina", "ar");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question24_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question24_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }
//
//    // Question 25
//    @Bean
//    public QuestionAnswer question25_en() {
//        return new CountryQuestionAnswer("Panama", "pa");
//    }
//
//    @Bean
//    public CountryLocalizedQuestionAnswer question25_localized() {
//
//        Map<String, QuestionAnswer> qaStorage = new HashMap<>();
//        qaStorage.put("en", question25_en());
//        return new CountryLocalizedQuestionAnswer(qaStorage);
//    }

}
