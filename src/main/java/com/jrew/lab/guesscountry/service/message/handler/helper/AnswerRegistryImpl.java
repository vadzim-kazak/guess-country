package com.jrew.lab.guesscountry.service.message.handler.helper;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.service.game.Game;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Kazak_VV on 12.08.2014.
 */
@Component
public class AnswerRegistryImpl implements AnswerRegistry {

    /** **/
    private Map<Game, Map<Player, List<Boolean>>> answersNumberRegistry = new HashMap<>();

    @Override
    public boolean canAnswer(Player player, Game game) {

        if (!answersNumberRegistry.containsKey(game)) {
           answersNumberRegistry.put(game, new HashMap<>());
        }

        Map<Player, List<Boolean>> roundAnswers = answersNumberRegistry.get(game);

//        // Check if other players provided right answer
//        Optional<Boolean> isRightAnswerPresented = roundAnswers.values().stream().flatMap(answersList -> answersList.stream())
//                .filter(isRightAnswer -> isRightAnswer == true).findAny();
//
//        // If yes prohibit answer attempt to all other players
//        if (isRightAnswerPresented.isPresent()) {
//            return false;
//        }

        if (!roundAnswers.containsKey(player)) {
            return true;
        }

        return false;
    }

    @Override
    public void registerAnswer(Player player, Game game, Boolean isRightAnswer) {

        Map<Player, List<Boolean>> roundAnswers = answersNumberRegistry.get(game);

        if (!roundAnswers.containsKey(player)) {
            roundAnswers.put(player, Collections.singletonList(isRightAnswer));
        } else {
            List<Boolean> answers = roundAnswers.get(player);
            answers.add(isRightAnswer);
        }
    }

    @Override
    public void reset(Game game) {
        answersNumberRegistry.get(game).clear();
    }
}
