package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
@Component(value = "ANSWER")
public class AnswerGameMessageHandler implements GameMessageHandler {

    @Override
    public void handleMessage(GameMessage message, List<Player> players) {

    }
}
