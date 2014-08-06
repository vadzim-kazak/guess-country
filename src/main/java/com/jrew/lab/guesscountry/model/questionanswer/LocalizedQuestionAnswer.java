package com.jrew.lab.guesscountry.model.questionanswer;

import java.util.Optional;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface LocalizedQuestionAnswer {

    /**
     *
     * @return
     */
    public Optional<String> getQuestion(String locale);

    /**
     *
     * @param answer
     * @return
     */
    public boolean checkAnswer(String answer, String locale);

    /**
     *
     * @return
     */
    public Optional<String> getAnswer(String locale);

}
