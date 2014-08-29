package com.jrew.lab.guesscountry.model.message.payload;

import com.javadocmd.simplelatlng.LatLng;
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
    private String answer;

    /** **/
    private String message;

    /** **/
    private LatLng center;

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
    public LatLng getCenter() {
        return center;
    }

    /**
     *
     * @param center
     */
    public void setCenter(LatLng center) {
        this.center = center;
    }
}
