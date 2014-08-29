package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.message.payload.AnswerTimeoutPayload;
import com.jrew.lab.guesscountry.model.questionanswer.CountryInfo;
import com.jrew.lab.guesscountry.service.game.Game;
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

    @Autowired
    CountriesDictionary countriesDictionary;

    @Override
    public void handleMessage(GameMessage<AnswerTimeoutPayload> message, Game game) {

        AnswerTimeoutPayload messagePayload = message.getPayload();

        game.getPlayers().stream().forEach(player -> {

            Optional<String> optionalQuestion = game.getQuestionAnswer().getQuestion(player.getLocale());
            optionalQuestion.ifPresent(question -> {

                Optional<CountryInfo> countryInfoOptional = countriesDictionary.getCountryInfo(question);
                countryInfoOptional.ifPresent(countryInfo -> {
                    messagePayload.setAnswer(question);
                    messagePayload.setCenter(countryInfo.getCenter());
                    webSocketSender.sendMessage(message, player.getWebSocketSession());
                });
            });
        });

    }
}
