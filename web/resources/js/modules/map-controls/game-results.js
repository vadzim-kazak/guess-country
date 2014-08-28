/**
 * Created by Kazak_VV on 27.08.2014.
 */
define(['jquery', 'text!../../../templates/game-results-template.html', 'Mustache'], function($, template, Mustache) {

    var GameResultsControl = function () {

        // Singletone
        if (GameResultsControl.prototype._singletonInstance) {
            return GameResultsControl.prototype._singletonInstance;
        }
        GameResultsControl.prototype._singletonInstance = this;

        var controlDiv = $('<div/>', {
            css: {}
        });
        controlDiv.hide();

        this.hide = function() {
            controlDiv.addClass('custom-controls-hidden');
        }

        this.getControl = function() {
            return controlDiv[0];
        }

        this.showResults = function(payload) {

            console.log(JSON.stringify(payload));

            var templateData = {

                status : (function () {
                    if (payload.draw) {
                        return "Draw !!!"
                    } else {

                        var playersResult = payload.playersResult;
                        for (var i = 0; i < playersResult.length; i++) {
                            var playerResult = payload.playersResult[i];
                            if (playerResult.winner == true && playerResult.currentPlayer == true) {
                                return "You win !!!"
                            }
                        }

                        return "You lose !!!"
                    }
                }),

                duel : (function() {
                   if (payload.playersResult.length > 1) {
                    return true;
                   }
                   return false;
                }),

                players: payload.playersResult
            }

            controlDiv.empty();
            controlDiv.append(Mustache.render(template, templateData));

            controlDiv.show();
        }

    }

    return new GameResultsControl();
});