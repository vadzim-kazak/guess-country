package com.jrew.lab.guesscountry.service.game.messagehandler.helper;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kazak_VV on 12.08.2014.
 */
@Component
public class AnswerCounterImpl implements AnswerCounter {

    /** **/
    private Map<Game, Map<Player, Integer>> answersRegistry = new HashMap<>();

    @Override
    public boolean canAnswer(Player player, Game game) {

        if (!answersRegistry.containsKey(game)) {
           answersRegistry.put(game, new HashMap<>());
        }

        Map<Player, Integer> roundAnswers = answersRegistry.get(game);
        if (!roundAnswers.containsKey(player)) {
            return true;
        }

        return false;
    }

    @Override
    public void countAnswer(Player player, Game game) {

        Map<Player, Integer> roundAnswers = answersRegistry.get(game);

        if (!roundAnswers.containsKey(player)) {
            roundAnswers.put(player, 1);
        } else {
            Integer answerAttempts = roundAnswers.get(player);
            roundAnswers.put(player, ++answerAttempts);
        }
    }

    @Override
    public void reset(Game game) {
        answersRegistry.get(game).clear();
    }
}
