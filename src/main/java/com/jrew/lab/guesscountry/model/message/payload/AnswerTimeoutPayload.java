package com.jrew.lab.guesscountry.model.message.payload;

import com.javadocmd.simplelatlng.LatLng;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 15.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AnswerTimeoutPayload {

    /** **/
    private String message;

    /**
     *
     */
    private QuestionAnswer questionAnswer;

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public QuestionAnswer getQuestionAnswer() {
        return questionAnswer;
    }

    /**
     *
     * @param questionAnswer
     */
    public void setQuestionAnswer(QuestionAnswer questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
