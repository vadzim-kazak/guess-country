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

        var controlDiv = $('<div/>', {
            css: {
                marginRight: '15px'
            }
        });
        controlDiv.addClass('custom-controls-hidden');


        var scoresContainer =  $('<div/>', {
            text: 'Scores: 0'
        });
        scoresContainer.addClass('hud-color');
        scoresContainer.addClass('scores-placeholder');

        controlDiv.append(scoresContainer);

        this.hide = function() {
            controlDiv.addClass('custom-controls-hidden');
        }

        this.show = function() {
            controlDiv.removeClass('custom-controls-hidden');
        }

        this.updateScores = function(value) {
            scoresContainer.text('Scores: ' + value);
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }

    return new ScoresControl();
});