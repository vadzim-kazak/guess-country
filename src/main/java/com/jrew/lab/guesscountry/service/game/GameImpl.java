package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.factory.message.GameMessageFactory;
import com.jrew.lab.guesscountry.service.game.messagehandler.GameMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
    private int currentQuestionAnswerNumber;

    /** **/
    @Autowired
    private Map<String, GameMessageHandler> messageHandlers;

    /** **/
    @Autowired
    GameMessageFactory gameMessageFactory;

    @Override
    public void start() {
        nextRound();
    }

    @Override
    public void nextRound() {


        if (currentQuestionAnswerNumber < questionAnswers.size()) {

            GameMessage gameMessage = gameMessageFactory.buildMessage(GameMessage.Type.QUESTION);
            messageHandlers.get(gameMessage.getType()).handleMessage(gameMessage, this);
            currentQuestionAnswerNumber++;

        } else {
          // finish game here
        }
    }

    @Override
    public LocalizedQuestionAnswer getQuestionAnswer() {
        return questionAnswers.get(currentQuestionAnswerNumber);
    }

    @Override
    public void handleMessage(GameMessage message) {
        messageHandlers.get(message.getType().toString()).handleMessage(message, this);
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
