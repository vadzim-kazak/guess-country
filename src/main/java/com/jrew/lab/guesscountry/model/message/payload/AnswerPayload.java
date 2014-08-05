package com.jrew.lab.guesscountry.model.message.payload;

import com.jrew.lab.guesscountry.model.player.Player;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AnswerPayload {

    /** **/
    private Player player;

    /** **/
    private String answer;

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
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
}
