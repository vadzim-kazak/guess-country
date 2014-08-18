package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.questionanswer.LocalizedQuestionAnswer;

import java.util.List;
import java.util.Map;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
public interface Game {

    /**
     *
     * @return
     */
    public String getId();

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
     * @param player
     */
    public void removePlayer(Player player);

    /**
     *
     * @return
     */
    public List<Player> getPlayers();

    /**
     *
     */
    public void finish();

}
