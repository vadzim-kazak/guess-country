/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery'], function($) {

    var ScoresControl = function () {

        // Singletone
        if (ScoresControl.prototype._singletonInstance) {
            return ScoresControl.prototype._singletonInstance;
        }
        ScoresControl.prototype._singletonInstance = this;

        // Array of players
        var players = [];

        var controlDiv = $('<div/>', {
            css: {
                marginRight: '15px'
            }
        });
        controlDiv.addClass('custom-controls-hidden');

        // Override players data
        this.init = function(playersListPayload) {

            var playersInfo = playersListPayload.players;
            for (var i = 0; i < playersInfo.length; i++) {

                var playerInfo = playersInfo[i];

                var player = {};
                player.id = playerInfo.id;

                if (playersInfo.length > 1) {
                    player.placeholder = playerInfo.name;
                } else {
                    player.placeholder = 'Scores';
                }

                player.scoresArea = $('<div/>', {
                    text: (function() {
                        if (playersInfo.length > 1) {
                            return playerInfo.name + ': 0';
                        } else {
                            return 'Scores: 0';
                        }
                    }),
                    class: 'hud-color scores-placeholder'
                });

                players.push(player);
                controlDiv.append(player.scoresArea);
            }
        }

        this.hide = function() {
            controlDiv.addClass('custom-controls-hidden');
        }

        this.show = function() {
            controlDiv.removeClass('custom-controls-hidden');
        }

        this.updateScores = function(resultPayload) {
            if (resultPayload.rightAnswer) {
                var answeredPlayerId = resultPayload.playerId;
                for (var i = 0; i < players.length; i++) {
                    var player = players[i];
                    if (player.id == answeredPlayerId) {
                        player.scoresArea.text(player.placeholder + ': ' + resultPayload.scores);
                    }
                }
            }
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }

    return new ScoresControl();
});