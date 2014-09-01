package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.AnswerTimeoutPayload;
import com.jrew.lab.guesscountry.model.country.CountryInfo;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.message.handler.helper.AnswerCounter;
import com.jrew.lab.guesscountry.service.questionanswer.CountriesDictionary;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Kazak_VV on 18.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.ANSWER_TIMEOUT)
public class AnswerTimeoutGameMessageHandler implements GameMessageHandler<AnswerTimeoutPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    /** **/
    @Autowired
    private AnswerCounter answerCounter;

    @Override
    public void handleMessage(GameMessage<AnswerTimeoutPayload> message, Game game) {

        AnswerTimeoutPayload messagePayload = message.getPayload();

        game.getPlayers().stream().forEach(player -> {
            QuestionAnswer questionAnswer = game.getQuestionAnswer();
            messagePayload.setQuestionAnswer(questionAnswer);

            if (answerCounter.canAnswer(player, game)) {
                webSocketSender.sendMessage(message, player.getWebSocketSession());
            }
        });

        answerCounter.reset(game);
    }
}
