package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;
import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.model.player.Player;

import java.util.List;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface Game {

    /**
     *
     */
    public void start();

    /**
     *
     */
    public void nextRound();

    /**
     *
     * @return
     */
    public LocalizedQuestionAnswer getQuestionAnswer();

    /**
     *
     * @param player
     */
    public void addPlayer(Player player);

    /**
     *
     * @param playerId
     * @return
     */
    public boolean hasPlayer(String playerId);

    /**
     *
     * @return
     */
    public List<Player> getPlayers();

}
