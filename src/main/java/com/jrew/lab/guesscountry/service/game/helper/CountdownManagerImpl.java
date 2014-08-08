package com.jrew.lab.guesscountry.service.game.helper;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.CountdownPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
import com.jrew.lab.guesscountry.service.game.messagehandler.MessageHandlerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.function.IntConsumer;

/**
 * Created by Kazak_VV on 08.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CountdownManagerImpl implements CountdownManager {

    /** **/
    private Logger logger = LoggerFactory.getLogger(CountdownManagerImpl.class);

    /** **/
    private static final int SECOND_DURATION = 1000;

    /** **/
    private boolean continueAnswerCountdown;

    @Override
    public void startQuestionCountdown(IntConsumer onTickAction, Runnable onFinishAction) {



        final int BEFORE_COUNTDOWN_PAUSE = 1;
        final int COUNTDOWN_DURATION = 3;

        Runnable countdownRunnable = () -> {

            int countdownCounter = BEFORE_COUNTDOWN_PAUSE + COUNTDOWN_DURATION;

            while (countdownCounter >= 1) {

                if (countdownCounter <= COUNTDOWN_DURATION) {
                    onTickAction.accept(countdownCounter);
                }

                countdownCounter--;

                try {
                    Thread.currentThread().sleep(SECOND_DURATION);
                } catch (InterruptedException exception) {
                    logger.error(exception.getMessage(), exception);
                }
            }

            onFinishAction.run();
        };

        new Thread(countdownRunnable).start();
    }

    @Override
    public void startAnswerCountdown(IntConsumer onTickAction, Runnable onFinishAction) {

        final int GET_ANSWER_DURATION = 20;

        continueAnswerCountdown = true;

        Runnable countdownRunnable = () -> {

            int countdownCounter = GET_ANSWER_DURATION;

            while (countdownCounter >= 1 && continueAnswerCountdown) {

                onTickAction.accept(countdownCounter);

                try {
                    Thread.currentThread().sleep(SECOND_DURATION);
                } catch (InterruptedException exception) {
                    logger.error(exception.getMessage(), exception);
                }

                countdownCounter--;
            }

            if (continueAnswerCountdown) {
                onFinishAction.run();
            }
        };

        new Thread(countdownRunnable).start();
    }

    @Override
    public void stopAnswerCountdown() {
        continueAnswerCountdown = false;
    }
}
