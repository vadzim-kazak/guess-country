package com.jrew.lab.guesscountry.service.game.helper;

import com.jrew.lab.guesscountry.service.game.Game;

import java.util.function.IntConsumer;

/**
 * Created by Kazak_VV on 08.08.2014.
 */
public interface CountdownManager {

    /**
     *  @param onTickAction
     * @param onFinishAction
     */
    public void startQuestionCountdown(IntConsumer onTickAction, Runnable onFinishAction);

    /**
     *  @param onTickAction
     * @param onFinishAction
     */
    public void startAnswerCountdown(IntConsumer onTickAction, Runnable onFinishAction);

    /**
     *
     */
    public void stopAnswerCountdown();
}
