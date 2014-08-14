package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.GameMessageImpl;
import com.jrew.lab.guesscountry.model.message.payload.*;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.player.PlayerImpl;
import com.jrew.lab.guesscountry.model.settings.GameSettings;
import com.jrew.lab.guesscountry.model.settings.GameSettingsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Configuration
@ComponentScan(basePackages = "com.jrew.lab.guesscountry")
public class ApplicationConfig {

    @Autowired
    private AnswerPayload answerPayload;

    @Autowired
    private StringPayload stringPayload;

    @Autowired
    private ResultPayload resultPayload;

    @Autowired
    private CountdownPayload countdownPayload;

    @Autowired
    private GameFinishedPayload gameFinishedPayload;

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public Player getPlayer() {
        Player player = new PlayerImpl();
        player.setGameSettings(getGameSettings());
        return player;
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameSettings getGameSettings() {
        return new GameSettingsImpl();
    }

    @Bean(name = "QUESTION")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameMessage<StringPayload> getQuestionGameMessage() {

        GameMessage<StringPayload> questionGameMessage = new GameMessageImpl<>();
        questionGameMessage.setType(GameMessage.Type.QUESTION);
        questionGameMessage.setPayload(stringPayload);
        return questionGameMessage;
    }

    @Bean(name = "ANSWER")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameMessage getAnswerGameMessage() {

        GameMessage<AnswerPayload> answerGameMessage = new GameMessageImpl<>();
        answerGameMessage.setType(GameMessage.Type.ANSWER);
        answerGameMessage.setPayload(answerPayload);
        return answerGameMessage;
    }

    @Bean(name = "RESULT")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameMessage getResultGameMessage() {

        GameMessage<ResultPayload> resultGameMessage = new GameMessageImpl<>();
        resultGameMessage.setType(GameMessage.Type.RESULT);
        resultGameMessage.setPayload(resultPayload);
        return resultGameMessage;
    }

    @Bean(name = "COUNTDOWN")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameMessage getCountdownGameMessage() {

        GameMessage<CountdownPayload> countdownGameMessage = new GameMessageImpl<>();
        countdownGameMessage.setType(GameMessage.Type.COUNTDOWN);
        countdownGameMessage.setPayload(countdownPayload);
        return countdownGameMessage;
    }

    @Bean(name = "WAITING_FOR_OTHER_PLAYER")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameMessage<StringPayload> getWaitingGameMessage() {

        GameMessage<StringPayload> waitingGameMessage = new GameMessageImpl<>();
        waitingGameMessage.setType(GameMessage.Type.WAITING_FOR_OTHER_PLAYER);
        stringPayload.setMessage("Waiting for second player connection...");
        waitingGameMessage.setPayload(stringPayload);
        return waitingGameMessage;
    }

    @Bean(name = "START_GAME")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameMessage<StringPayload> getStartGameMessage() {

        GameMessage<StringPayload> startGameMessage = new GameMessageImpl<>();
        startGameMessage.setType(GameMessage.Type.START_GAME);
        stringPayload.setMessage("Starting game...");
        startGameMessage.setPayload(stringPayload);
        return startGameMessage;
    }


    @Bean(name = "GAME_FINISHED")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public GameMessage<GameFinishedPayload> getGameFinishedMessage() {

        GameMessage<GameFinishedPayload> gameFinishedMessage = new GameMessageImpl<>();
        gameFinishedMessage.setType(GameMessage.Type.GAME_FINISHED);
        gameFinishedPayload.setMessage("Game finished...");
        gameFinishedMessage.setPayload(gameFinishedPayload);
        return gameFinishedMessage;
    }
}
