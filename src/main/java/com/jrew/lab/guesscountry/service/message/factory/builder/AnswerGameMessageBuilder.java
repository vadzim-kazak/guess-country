package com.jrew.lab.guesscountry.service.message.factory.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.AnswerPayload;
import com.jrew.lab.guesscountry.model.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Kazak_VV on 05.08.2014.
 */
@Component
@MessageBuilderType(type = GameMessage.Type.ANSWER)
public class AnswerGameMessageBuilder implements GameMessageBuilder<AnswerPayload> {

    /**
     *
     */
    public interface PayloadKeys {

        /** **/
        public static final String ANSWER_KEY = "answer";
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public GameMessage<AnswerPayload> build(JsonNode payload, Player player) {

        GameMessage<AnswerPayload> gameMessage = (GameMessage) applicationContext.getBean(GameMessage.Type.ANSWER.toString());

        AnswerPayload answerPayload = gameMessage.getPayload();
        answerPayload.setPlayer(player);
        answerPayload.setAnswer(payload.get(PayloadKeys.ANSWER_KEY).textValue());

        return gameMessage;
    }
}
