package com.jrew.lab.guesscountry.service.question;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;

import java.util.List;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface QuestionAnswerHandbook {

    /** **/
    public List<LocalizedQuestionAnswer> provideQuestionAnswers();

}
