package com.jrew.lab.guesscountry.model;

import java.util.function.Predicate;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public class CityQuestionAnswer implements QuestionAnswer {

    /** **/
    private String cityName;

    /** **/
    private String cityCountry;

    /** **/
    private Predicate<String> checkAnswerMethod = answer -> cityCountry.equalsIgnoreCase(answer);

    /**
     *
     * @param cityName
     * @param cityCountry
     */
    public CityQuestionAnswer(String cityName, String cityCountry) {
        this.cityName = cityName;
        this.cityCountry = cityCountry;
    }

    @Override
    public String getQuestion() {
        return cityName;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return checkAnswerMethod.test(answer);
    }

    @Override
    public String getAnswer() {
        return cityCountry;
    }

    /**
     *
     * @param checkAnswerMethod
     */
    public void setCheckAnswerMethod(Predicate<String> checkAnswerMethod) {
        this.checkAnswerMethod = checkAnswerMethod;
    }
}
