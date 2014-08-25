/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery'], function($) {

    var Scores = function () {

        // Singletone
        if (Scores.prototype._singletonInstance) {
            return Scores.prototype._singletonInstance;
        }
        Scores.prototype._singletonInstance = this;

        var textColor = "#5876a1";

        var controlDiv = $('<div></div>');
        controlDiv.css({ 'marginTop': '10px', 'marginRight': '5px'});

        var scores =  $('<div/>', {
        });

        scores.text('Scores: 0');
        scores.css({ 'color': textColor, 'font-size': '150%', 'marginTop': '80px', 'marginRight': '10px' });

        controlDiv.append(scores);
        controlDiv.hide();

        this.hide = function() {
            controlDiv.hide();
        }

        this.show = function() {
            controlDiv.show();
        }

        this.updateScores = function(value) {
            scores.text('Scores: ' + value);
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }


    return new Scores();
});