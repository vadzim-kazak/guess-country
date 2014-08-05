package com.jrew.lab.guesscountry.config;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.GameMessageImpl;
import com.jrew.lab.guesscountry.model.message.payload.AnswerPayload;
import com.jrew.lab.guesscountry.model.message.payload.QuestionPayload;
import com.jrew.lab.guesscountry.model.message.payload.ResultPayload;
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
    private QuestionPayload questionPayload;

    @Autowired
    private ResultPayload resultPayload;

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
    public GameMessage<QuestionPayload> getQuestionGameMessage() {

        GameMessage<QuestionPayload> questionGameMessage = new GameMessageImpl<>();
        questionGameMessage.setType(GameMessage.Type.QUESTION);
        questionGameMessage.setPayload(questionPayload);
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


}
