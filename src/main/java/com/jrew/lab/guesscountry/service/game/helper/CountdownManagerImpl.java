package com.jrew.lab.guesscountry.service.game.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

    /** **/
    @Value(value = "${game.question.prepare.countdown}")
    private int prepareCountdown;

    /** **/
    @Value(value = "${game.question.timeout.countdown}")
    private int timeoutCountdown;

    @Override
    public void startQuestionCountdown(IntConsumer onTickAction, Runnable onFinishAction) {

        final int BEFORE_COUNTDOWN_PAUSE = 1;

        Runnable countdownRunnable = () -> {

            int countdownCounter = BEFORE_COUNTDOWN_PAUSE + prepareCountdown;

            while (countdownCounter >= 0) {

                if (countdownCounter <= prepareCountdown) {
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

        continueAnswerCountdown = true;

        Runnable countdownRunnable = () -> {

            int countdownCounter = timeoutCountdown;

            while (countdownCounter >= 0 && continueAnswerCountdown) {

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
