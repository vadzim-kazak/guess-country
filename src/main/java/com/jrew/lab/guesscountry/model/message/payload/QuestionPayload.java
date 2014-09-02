package com.jrew.lab.guesscountry.model.message.payload;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 02.09.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class QuestionPayload {

    /** **/
    private String question;

    /** **/
    private int currentQuestionNumber;

    /** **/
    private int questionsNumber;

    /**
     *
     * @return
     */
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     *
     * @return
     */
    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    /**
     *
     * @param currentQuestionNumber
     */
    public void setCurrentQuestionNumber(int currentQuestionNumber) {
        this.currentQuestionNumber = currentQuestionNumber;
    }

    /**
     *
     * @return
     */
    public int getQuestionsNumber() {
        return questionsNumber;
    }

    /**
     *
     * @param questionsNumber
     */
    public void setQuestionsNumber(int questionsNumber) {
        this.questionsNumber = questionsNumber;
    }
}
