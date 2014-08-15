package com.jrew.lab.guesscountry.model.message.payload;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazak_VV on 14.08.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GameFinishedPayload {

    /**
     *
     */
    public static class PlayerResult {

        /** **/
        private String id;

        /** **/
        private String playerName;

        /** **/
        private int scores;

        /** **/
        private boolean isCurrentPlayer;

        /** **/
        private boolean isWinner;

        /**
         *
         * @return
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         */
        public String getPlayerName() {
            return playerName;
        }

        /**
         *
         * @param playerName
         */
        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        /**
         *
         * @return
         */
        public int getScores() {
            return scores;
        }

        /**
         *
         * @param scores
         */
        public void setScores(int scores) {
            this.scores = scores;
        }

        /**
         *
         * @return
         */
        public boolean isCurrentPlayer() {
            return isCurrentPlayer;
        }

        /**
         *
         * @param isCurrentPlayer
         */
        public void setCurrentPlayer(boolean isCurrentPlayer) {
            this.isCurrentPlayer = isCurrentPlayer;
        }

        /**
         *
         * @return
         */
        public boolean isWinner() {
            return isWinner;
        }

        /**
         *
         * @param winner
         */
        public void setWinner(boolean winner) {
            this.isWinner = winner;
        }
    }

    /** **/
    private String message;

    /** **/
    private boolean isDraw;

    /** **/
    private List<PlayerResult> playersResult = new ArrayList<>();

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public List<PlayerResult> getPlayersResult() {
        return playersResult;
    }

    /**
     *
     * @return
     */
    public boolean isDraw() {
        return isDraw;
    }

    /**
     *
     * @param isDraw
     */
    public void setDraw(boolean isDraw) {
        this.isDraw = isDraw;
    }

    /**
     *
     * @param playersResult
     */
    public void setPlayersResult(List<PlayerResult> playersResult) {
        this.playersResult = playersResult;
    }
}
