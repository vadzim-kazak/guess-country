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
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
@Configuration
@ComponentScan(basePackages = "com.jrew.lab.guesscountry")
@PropertySource("classpath:config.properties")
public class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

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
    @Autowired
    public GameMessage<QuestionPayload> getQuestionGameMessage(QuestionPayload questionPayload) {

        GameMessage<QuestionPayload> questionGameMessage = new GameMessageImpl<>();
        questionGameMessage.setType(GameMessage.Type.QUESTION);
        questionGameMessage.setPayload(questionPayload);
        return questionGameMessage;
    }

    @Bean(name = "ANSWER")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage getAnswerGameMessage(AnswerPayload answerPayload) {

        GameMessage<AnswerPayload> answerGameMessage = new GameMessageImpl<>();
        answerGameMessage.setType(GameMessage.Type.ANSWER);
        answerGameMessage.setPayload(answerPayload);
        return answerGameMessage;
    }

    @Bean(name = "RESULT")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage getResultGameMessage(ResultPayload resultPayload) {

        GameMessage<ResultPayload> resultGameMessage = new GameMessageImpl<>();
        resultGameMessage.setType(GameMessage.Type.RESULT);
        resultGameMessage.setPayload(resultPayload);
        return resultGameMessage;
    }

    @Bean(name = "COUNTDOWN")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage getCountdownGameMessage(CountdownPayload countdownPayload) {

        GameMessage<CountdownPayload> countdownGameMessage = new GameMessageImpl<>();
        countdownGameMessage.setType(GameMessage.Type.COUNTDOWN);
        countdownGameMessage.setPayload(countdownPayload);
        return countdownGameMessage;
    }

    @Bean(name = "WAITING_FOR_OTHER_PLAYER")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage<StringPayload> getWaitingGameMessage(StringPayload stringPayload) {

        GameMessage<StringPayload> waitingGameMessage = new GameMessageImpl<>();
        waitingGameMessage.setType(GameMessage.Type.WAITING_FOR_OTHER_PLAYER);
        stringPayload.setMessage("Waiting for second player connection...");
        waitingGameMessage.setPayload(stringPayload);
        return waitingGameMessage;
    }

    @Bean(name = "START_GAME")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage<StartGamePayload> getStartGameMessage(StartGamePayload startGamePayload) {

        GameMessage<StartGamePayload> startGameMessage = new GameMessageImpl<>();
        startGameMessage.setType(GameMessage.Type.START_GAME);
        startGameMessage.setPayload(startGamePayload);
        return startGameMessage;
    }

    @Bean(name = "GAME_FINISHED")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage<GameFinishedPayload> getGameFinishedMessage(GameFinishedPayload gameFinishedPayload) {

        GameMessage<GameFinishedPayload> gameFinishedMessage = new GameMessageImpl<>();
        gameFinishedMessage.setType(GameMessage.Type.GAME_FINISHED);
        gameFinishedPayload.setMessage("Game finished...");
        gameFinishedMessage.setPayload(gameFinishedPayload);
        return gameFinishedMessage;
    }

    @Bean(name = "ANSWER_TIMEOUT")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage<AnswerTimeoutPayload> getAnswerTimeoutMessage(AnswerTimeoutPayload answerTimeoutPayload) {

        GameMessage<AnswerTimeoutPayload> answerTimeoutMessage = new GameMessageImpl<>();
        answerTimeoutMessage.setType(GameMessage.Type.ANSWER_TIMEOUT);
        answerTimeoutPayload.setMessage("Answer timeout...");
        answerTimeoutMessage.setPayload(answerTimeoutPayload);
        return answerTimeoutMessage;
    }

    @Bean(name = "PLAYER_LEFT")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public GameMessage<PlayerLeftPayload> getPlayerLeftMessage(PlayerLeftPayload playerLeftPayload) {

        GameMessage<PlayerLeftPayload> playerLeftMessage = new GameMessageImpl<>();
        playerLeftMessage.setType(GameMessage.Type.PLAYER_LEFT);
        playerLeftPayload.setMessage("Another player has left the game...");
        playerLeftMessage.setPayload(playerLeftPayload);
        return playerLeftMessage;
    }
}
