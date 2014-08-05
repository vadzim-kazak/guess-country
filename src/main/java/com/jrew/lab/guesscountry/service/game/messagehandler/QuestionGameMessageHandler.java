package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.QuestionPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import java.util.Optional;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
@Component(value = "QUESTION")
public class QuestionGameMessageHandler implements GameMessageHandler<QuestionPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<QuestionPayload> message, Game game) {

        game.getPlayers().stream().forEach(player -> {
            LocalizedQuestionAnswer questionAnswer = game.getQuestionAnswer();
            Optional<String> optionalQuestion = questionAnswer.getQuestion(player.getLocale());
            optionalQuestion.ifPresent(question -> {

                QuestionPayload payload = message.getPayload();
                payload.setQuestion(question);
                webSocketSender.sendMessage(message, player.getWebSocketSession());
            });
        });
    }
}
