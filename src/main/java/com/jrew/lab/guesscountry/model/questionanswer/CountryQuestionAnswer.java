package com.jrew.lab.guesscountry.model.questionanswer;

import com.javadocmd.simplelatlng.LatLng;

import java.util.function.Predicate;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public class CountryQuestionAnswer implements QuestionAnswer {

    /** **/
    private String countryName;

    /** **/
    private String countryCode;

    /** **/
    private LatLng latLng;

    /** **/
    private Predicate<String> checkAnswerMethod = answer -> countryCode.equalsIgnoreCase(answer);

    /**
     *
     * @param countryName
     * @param countryCode
     */
    public CountryQuestionAnswer(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    @Override
    public String getQuestion() {
        return countryName;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return checkAnswerMethod.test(answer);
    }

    @Override
    public String getAnswer() {
        return countryCode;
    }

    /**
     *
     * @return
     */
    public LatLng getLatLng() {
        return latLng;
    }

    /**
     *
     * @param latLng
     */
    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    /**
     *
     * @param checkAnswerMethod
     */
    public void setCheckAnswerMethod(Predicate<String> checkAnswerMethod) {
        this.checkAnswerMethod = checkAnswerMethod;
    }
}
