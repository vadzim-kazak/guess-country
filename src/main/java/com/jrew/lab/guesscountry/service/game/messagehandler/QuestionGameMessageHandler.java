package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.messagehandler.GameMessageHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
@Component(value = "QUESTION")
public class QuestionGameMessageHandler implements GameMessageHandler {


    @Override
    public void handleMessage(GameMessage message, List<Player> players) {

    }
}
