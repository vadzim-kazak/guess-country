package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.message.payload.CountdownPayload;
import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
import com.jrew.lab.guesscountry.service.game.helper.CountdownManager;
import com.jrew.lab.guesscountry.service.game.messagehandler.MessageHandlerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GameImpl implements Game {

    /** **/
    private List<Player> players = new ArrayList<>();

    /** **/
    private Map<Player, Integer> answersLog = new HashMap<>();

    /** **/
    @Autowired
    private List<LocalizedQuestionAnswer> questionAnswers;

    /** **/
    @Autowired
    private MessageHandlerProvider messageHandlerProvider;

    /** **/
    @Autowired
    private GameMessageFactory gameMessageFactory;

    /** **/
    @Autowired
    private CountdownManager countdownManager;

    /** **/
    private int currentQuestionAnswerNumber = 0;

    @Override
    public void start() {
        nextRound();
    }

    @Override
    public void nextRound() {

        if (currentQuestionAnswerNumber < questionAnswers.size()) {

            countdownManager.stopAnswerCountdown();

            GameMessage<CountdownPayload> gameMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.COUNTDOWN);
            CountdownPayload payload = gameMessage.getPayload();

            countdownManager.startQuestionCountdown(counter -> {
                    payload.setSeconds(counter);
                    messageHandlerProvider.handleMessage(gameMessage, this);
                },
                () -> proceedNextRound()
            );

        } else {
          // finish game here
        }
    }

    /**
     *
     */
    private void proceedNextRound() {

        answersLog.clear();

        GameMessage gameMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.QUESTION);
        messageHandlerProvider.handleMessage(gameMessage, this);

        GameMessage<CountdownPayload> countdownMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.COUNTDOWN);
        CountdownPayload payload = countdownMessage.getPayload();

        countdownManager.startAnswerCountdown(counter -> {
                    payload.setSeconds(counter);
                    messageHandlerProvider.handleMessage(countdownMessage, this);
                },
                () -> nextRound()
        );

        currentQuestionAnswerNumber++;
    }

    @Override
    public boolean checkAnswerPermission(Player player) {

        if (answersLog.containsKey(player)) {
            return false;
        }

        return true;
    }

    @Override
    public void logAnswerAttempt(Player player) {

        if (answersLog.containsKey(player)) {
            Integer answerAttempts = answersLog.get(player);
            answersLog.put(player, ++answerAttempts);
        } else {
            answersLog.put(player, Integer.valueOf(1));
        }
    }

    @Override
    public LocalizedQuestionAnswer getQuestionAnswer() {
        return questionAnswers.get(currentQuestionAnswerNumber);
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
