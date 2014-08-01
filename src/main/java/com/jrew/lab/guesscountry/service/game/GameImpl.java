package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.event.GameMessageEvent;
import com.jrew.lab.guesscountry.service.game.helper.RoundProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
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
    private RoundProcessor roundProcessor;

    /** **/
    private List<LocalizedQuestionAnswer> questionAnswers;

    /** **/
    private Runnable gameProcess = () -> {

        int playedRounds = 0;
        while(playedRounds < questionAnswers.size()) {

            // 1) Send question to players
            LocalizedQuestionAnswer questionAnswer = questionAnswers.get(playedRounds);
            players.stream().forEach( player -> {
                Optional<String> questionOptional = questionAnswer.getQuestion(player.getLocale());
                questionOptional.ifPresent(question -> {
                    try {
                        player.getWebSocketSession().sendMessage(new TextMessage(question));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });

        }
    };

    @Override
    public void onApplicationEvent(GameMessageEvent gameMessageEvent) {

        GameMessage gameMessage = (GameMessage) gameMessageEvent.getSource();
        Player player = gameMessage.getPlayer();
        if (players.contains(player)) {

        }
    }

    @Override
    public void start() {

    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void processMessage(String playerId, GameMessage message) {

    }

    @Override
    public void setRoundProcessor(RoundProcessor roundProcessor) {
        this.roundProcessor = roundProcessor;
    }
}
