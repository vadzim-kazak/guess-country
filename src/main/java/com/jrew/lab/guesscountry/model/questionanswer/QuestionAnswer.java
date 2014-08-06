package com.jrew.lab.guesscountry.model.questionanswer;

import java.util.Locale;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface QuestionAnswer {

    /**
     *
     * @return
     */
    public String getQuestion();

    /**
     *
     * @param answer
     * @return
     */
    public boolean checkAnswer(String answer);

    /**
     *
     * @return
     */
    public String getAnswer();

}
