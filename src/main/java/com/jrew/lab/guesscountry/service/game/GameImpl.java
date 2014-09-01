package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.CountdownPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import com.jrew.lab.guesscountry.service.game.helper.CountdownManager;
import com.jrew.lab.guesscountry.service.message.factory.GameMessageFactory;
import com.jrew.lab.guesscountry.service.message.handler.MessageHandlerProvider;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GameImpl implements Game {

    /** **/
    private String id;

    /** **/
    private List<Player> players = new ArrayList<>();

    /** **/
    private boolean isRoundInProgress;

    /** **/
    private List<QuestionAnswer> questionAnswers;

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
    private int currentQuestionAnswerNumber = -1;

    @PostConstruct
    private void init() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public void handleMessage(String message, Player player) {

        GameMessage gameMessage = gameMessageFactory.buildClientMessage(message, player);

        synchronized (this) {
            messageHandlerProvider.handleMessage(gameMessage, this);
        }
    }

    @Override
    public void start() {
        checkNextRound();
    }

    @Override
    public void nextRound() {
        isRoundInProgress = false;
        countdownManager.stopAnswerCountdown();

        countdownManager.idleBeforeQuestionCountdown(() -> checkNextRound());
    }

    /**
     *
     */
    private void checkNextRound() {

        currentQuestionAnswerNumber++;
        if (currentQuestionAnswerNumber < questionAnswers.size()) {


            GameMessage<CountdownPayload> gameMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.COUNTDOWN);
            CountdownPayload payload = gameMessage.getPayload();

            countdownManager.startQuestionCountdown(counter -> {
                        payload.setSeconds(counter);
                        payload.setType(CountdownPayload.CountdownType.PREPARE_TO_QUESTION);
                        messageHandlerProvider.handleMessage(gameMessage, this);
                    },
                    () -> proceedNextRound()
            );

        } else {
            countdownManager.stopAnswerCountdown();
            // finish game here
            messageHandlerProvider.handleMessage(GameMessage.Type.GAME_FINISHED, this);
        }
    }

    /**
     *
     */
    private void proceedNextRound() {

        messageHandlerProvider.handleMessage(GameMessage.Type.QUESTION, this);

        GameMessage<CountdownPayload> countdownMessage = gameMessageFactory.buildServerMessage(GameMessage.Type.COUNTDOWN);
        CountdownPayload payload = countdownMessage.getPayload();

        countdownManager.startAnswerCountdown(counter -> {
                    payload.setSeconds(counter);
                    payload.setType(CountdownPayload.CountdownType.QUESTION_TIMEOUT);
                    messageHandlerProvider.handleMessage(countdownMessage, this);
                },
                () -> {
                    // 1) Send right answer to all players
                    messageHandlerProvider.handleMessage(GameMessage.Type.ANSWER_TIMEOUT, this);
                    // 2) Proceed to next round
                    nextRound();
                }
        );

        isRoundInProgress = true;
    }

    @Override
    public boolean isRoundInProgress() {

        return isRoundInProgress;
    }

    @Override
    public QuestionAnswer getQuestionAnswer() {
        return questionAnswers.get(currentQuestionAnswerNumber);
    }

    @Override
    public void finish() {
        countdownManager.stopAnswerCountdown();
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
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

    @Override
    public String getId() {
        return id;
    }

    /**
     *
     * @param questionAnswers
     */
    public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(21, 35) // two randomly chosen prime numbers
                .append(getId())
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {

        if (object == null || !(object instanceof Game)) {
            return false;
        }

        if (object == this) {
            return true;
        }

        Game anotherGame = (Game) object;
        return new EqualsBuilder()
                .append(getId(), anotherGame.getId())
                .isEquals();
    }
}
