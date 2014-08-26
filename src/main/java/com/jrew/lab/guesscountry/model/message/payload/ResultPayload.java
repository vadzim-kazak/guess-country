package com.jrew.lab.guesscountry.model.message.payload;

import com.javadocmd.simplelatlng.LatLng;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ResultPayload {

    /** **/
    private String playerName;

    /** **/
    private String answer;

    /** **/
    private boolean isRightAnswer;

    /** **/
    private boolean isAnswerOwner;

    /** **/
    private LatLng latLng;

    /** **/
    private int scores;

    /**
     *
     * @return
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     *
     * @param playerName
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     *
     * @return
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    /**
     *
     * @param isRightAnswer
     */
    public void setRightAnswer(boolean isRightAnswer) {
        this.isRightAnswer = isRightAnswer;
    }

    /**
     *
     * @return
     */
    public boolean isAnswerOwner() {
        return isAnswerOwner;
    }

    /**
     *
     * @param isAnswerOwner
     */
    public void setAnswerOwner(boolean isAnswerOwner) {
        this.isAnswerOwner = isAnswerOwner;
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
     * @return
     */
    public int getScores() {
        return scores;
    }

    /**
     *
     * @param scores
     */
    public void setScores(int scores) {
        this.scores = scores;
    }
}
