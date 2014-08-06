package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.CountdownPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
import com.jrew.lab.guesscountry.service.game.messagehandler.GameMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GameImpl implements Game {

    /** **/
    private List<Player> players = new ArrayList<>();

    /** **/
    @Autowired
    private List<LocalizedQuestionAnswer> questionAnswers;

    /** **/
    private int currentQuestionAnswerNumber = -1;

    /** **/
    @Resource(name = "messageHandlers")
    private Map<GameMessage.Type, GameMessageHandler> messageHandlers;

    /** **/
    @Autowired
    GameMessageFactory gameMessageFactory;

    /** **/
    private Runnable nextQuestionCountdownRunnable = () -> {

        int nextRoundPause = 8;
        int COUNTDOWN_THRESHOLD = 5;

        GameMessage<CountdownPayload> gameMessage = gameMessageFactory.buildMessage(GameMessage.Type.COUNTDOWN);
        CountdownPayload payload = gameMessage.getPayload();

        while (nextRoundPause >= 1) {

            if (nextRoundPause <= COUNTDOWN_THRESHOLD) {
                payload.setSeconds(nextRoundPause);
                GameImpl.this.handleMessage(gameMessage);
            }

            nextRoundPause--;

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        GameImpl.this.proceedNextRound();
    };



    @Override
    public void start() {
        nextRound();
    }

    @Override
    public void nextRound() {

        if (currentQuestionAnswerNumber < questionAnswers.size()) {
            new Thread(nextQuestionCountdownRunnable).start();
        } else {

          // finish game here
        }
    }

    /**
     *
     */
    private void proceedNextRound() {

        currentQuestionAnswerNumber++;
        GameMessage gameMessage = gameMessageFactory.buildMessage(GameMessage.Type.QUESTION);
        messageHandlers.get(GameMessage.Type.QUESTION).handleMessage(gameMessage, this);
    }


    @Override
    public LocalizedQuestionAnswer getQuestionAnswer() {
        return questionAnswers.get(currentQuestionAnswerNumber);
    }

    @Override
    public void handleMessage(GameMessage message) {
        messageHandlers.get(message.getType()).handleMessage(message, this);
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public boolean hasPlayer(String playerId) {

        Optional<Player> playerOptional = players.stream().filter(player -> player.getId().equalsIgnoreCase(playerId))
                .findAny();
        return playerOptional.isPresent();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }
}
