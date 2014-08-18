package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.StringPayload;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.socket.WebSocketSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
@Component
@MessageHandlerType(type = GameMessage.Type.QUESTION)
public class QuestionGameMessageHandler implements GameMessageHandler<StringPayload> {

    /** **/
    @Autowired
    private WebSocketSender webSocketSender;

    @Override
    public void handleMessage(GameMessage<StringPayload> message, Game game) {

        LocalizedQuestionAnswer questionAnswer = game.getQuestionAnswer();
        game.getPlayers().stream().forEach(player -> {

            Optional<String> optionalQuestion = questionAnswer.getQuestion(player.getLocale());
            optionalQuestion.ifPresent(question -> {

                StringPayload payload = message.getPayload();
                payload.setMessage(question);
                webSocketSender.sendMessage(message, player.getWebSocketSession());
            });
        });
    }
}
