package com.jrew.lab.guesscountry.service.game.helper;

import com.jrew.lab.guesscountry.model.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.messagehandler.GameMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RoundProcessorImpl implements RoundProcessor {

    /** **/
    @Autowired
    private List<LocalizedQuestionAnswer> questionAnswers;

    /** **/
    private int currentQuestionAnswer = 0;

    @Override
    public boolean hasNextQuestionAnswer() {

        if (currentQuestionAnswer < questionAnswers.size()) {
            return true;
        }

        return false;
    }

    @Override
    public LocalizedQuestionAnswer nextQuestionAnswer() {

        currentQuestionAnswer++;
        return questionAnswers.get(currentQuestionAnswer);
    }

    @Override
    public LocalizedQuestionAnswer currentQuestionAnswer() {

        return questionAnswers.get(currentQuestionAnswer);
    }

    @Override
    public void setQuestionAnswers(List<LocalizedQuestionAnswer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }
}
