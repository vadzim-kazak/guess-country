package com.jrew.lab.guesscountry.service.game.helper;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;

import java.util.List;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface RoundProcessor {

    /**
     *
     * @return
     */
    public boolean hasNextQuestionAnswer();

    /**
     *
     * @return
     */
    public LocalizedQuestionAnswer nextQuestionAnswer();


    /**
     *
     * @return
     */
    public LocalizedQuestionAnswer currentQuestionAnswer();

    /**
     *
     * @param questionAnswers
     */
    public void setQuestionAnswers(List<LocalizedQuestionAnswer> questionAnswers);
}
