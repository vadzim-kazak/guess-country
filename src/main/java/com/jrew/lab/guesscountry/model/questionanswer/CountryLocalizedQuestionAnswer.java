package com.jrew.lab.guesscountry.model.questionanswer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public class CountryLocalizedQuestionAnswer implements LocalizedQuestionAnswer {

    /** **/
    private Map<String, QuestionAnswer> questionAnswerStorage = new HashMap<>();

    /** **/
    private BiFunction<String, String, Boolean> checkAnswerMethod = (answer, locale) -> {

        if (questionAnswerStorage.containsKey(locale)) {
            String localizedAnswer = questionAnswerStorage.get(locale).getAnswer();
            return localizedAnswer.equalsIgnoreCase(answer);
        }

        return false;
    };

    /**
     *
     * @param questionAnswerStorage
     */
    public CountryLocalizedQuestionAnswer(Map<String, QuestionAnswer> questionAnswerStorage) {
        this.questionAnswerStorage = questionAnswerStorage;
    }

    @Override
    public Optional<String> getQuestion(String locale) {

        if (questionAnswerStorage.containsKey(locale)) {
            return Optional.of(questionAnswerStorage.get(locale).getQuestion());
        }

        return Optional.empty();
    }

    @Override
    public boolean checkAnswer(String answer, String locale) {
        return checkAnswerMethod.apply(answer, locale);
    }

    @Override
    public Optional<String> getAnswer(String locale) {

        if (questionAnswerStorage.containsKey(locale)) {
            return Optional.of(questionAnswerStorage.get(locale).getAnswer());
        }

        return Optional.empty();
    }

    /**
     *
     * @param checkAnswerMethod
     */
    public void setCheckAnswerMethod(BiFunction<String, String, Boolean> checkAnswerMethod) {
        this.checkAnswerMethod = checkAnswerMethod;
    }
}
