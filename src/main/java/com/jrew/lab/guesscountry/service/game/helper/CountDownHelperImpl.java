package com.jrew.lab.guesscountry.service.game.helper;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.CountdownPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
import com.jrew.lab.guesscountry.service.game.messagehandler.GameMessageHandler;
import com.jrew.lab.guesscountry.service.game.messagehandler.MessageHandlerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Kazak_VV on 08.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CountDownHelperImpl implements CountDownHelper {

    /** **/
    private Game game;

    /** **/
    @Autowired
    MessageHandlerProvider messageHandlerProvider;

    /** **/
    @Autowired
    private GameMessageFactory gameMessageFactory;

    @Override
    public void performCountDown(Runnable action) {

        Runnable nextQuestionCountdownRunnable = () -> {

            int nextRoundPause = 6;
            int COUNTDOWN_THRESHOLD = 5;

            GameMessage<CountdownPayload> gameMessage = gameMessageFactory.buildMessage(GameMessage.Type.COUNTDOWN);
            CountdownPayload payload = gameMessage.getPayload();

            while (nextRoundPause >= 1) {

                if (nextRoundPause <= COUNTDOWN_THRESHOLD) {
                    payload.setSeconds(nextRoundPause);
                    messageHandlerProvider.handleMessage(gameMessage, game);
                }

                nextRoundPause--;

                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            action.run();
        };

        new Thread(nextQuestionCountdownRunnable).start();
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
