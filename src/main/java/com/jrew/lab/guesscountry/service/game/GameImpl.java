package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.helper.RoundProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;
import java.util.List;
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
    private RoundProcessor roundProcessor;

    @Override
    public void start() {
        if (roundProcessor.hasNextQuestionAnswer()) {
            LocalizedQuestionAnswer questionAnswer = roundProcessor.currentQuestionAnswer();
            sendQuestion(questionAnswer);
        }
    }

    @Override
    public void handleMessage(GameMessage message) {

        GameMessage.Type messageType = message.getType();
        if (messageType == GameMessage.Type.ANSWER) {

            boolean isCorrectAnswer = checkAnswer(message.getPlayer().getId(), message.getMessage());
            if (isCorrectAnswer) {
               // send confirmation here
               // and
            } else {

            }


            // send message to all other players
        }
    }

    /**
     *
     */
    private void sendQuestion(LocalizedQuestionAnswer questionAnswer) {

        players.stream().forEach(player -> {
            Optional<String> optionalQuestion = questionAnswer.getQuestion(player.getLocale());
            optionalQuestion.ifPresent(question -> new TextMessage(question));
        });
    }

    /**
     *
     * @param playerId
     * @param answer
     * @return
     */
    private boolean checkAnswer(String playerId, String answer) {

        LocalizedQuestionAnswer localizedQuestionAnswer = roundProcessor.currentQuestionAnswer();
        Optional<Player> playerOptional = players.stream().filter(player -> player.getId().equalsIgnoreCase(playerId)).findAny();
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            return localizedQuestionAnswer.checkAnswer(answer, player.getLocale());
        }

        return false;
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
    public void setRoundProcessor(RoundProcessor roundProcessor) {
        this.roundProcessor = roundProcessor;
    }
}
