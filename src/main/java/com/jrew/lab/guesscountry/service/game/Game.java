package com.jrew.lab.guesscountry.service.game;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.model.questionanswer.QuestionAnswer;

import java.util.List;

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
    public QuestionAnswer getQuestionAnswer();

    /**
     *
     * @param message
     * @param player
     */
    public void handleMessage(String message, Player player);

    /**
     *
     * @return
     */
    public boolean isRoundInProgress();

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

    /**
     *
     * @param questionAnswers
     */
    public void setQuestionAnswers(List<QuestionAnswer> questionAnswers);

}
