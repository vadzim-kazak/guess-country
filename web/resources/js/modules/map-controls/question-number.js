/**
 * Created by Kazak_VV on 02.09.2014.
 */
define(['jquery'], function($) {

    var QuestionNumberControl = function () {

        // Singletone
        if (QuestionNumberControl.prototype._singletonInstance) {
            return QuestionNumberControl.prototype._singletonInstance;
        }
        QuestionNumberControl.prototype._singletonInstance = this;

        var controlDiv = $('<div/>', {
            css: {
                marginRight: '25px'
            }
        });
        controlDiv.addClass('custom-controls-hidden');


        var numberContainer =  $('<div/>');
        numberContainer.addClass('hud-color');
        numberContainer.addClass('question-number');

        controlDiv.append(numberContainer);

        this.hide = function() {
            controlDiv.addClass('custom-controls-hidden');
        }

        this.show = function(payload) {
            controlDiv.removeClass('custom-controls-hidden');
            numberContainer.text('<' + payload.currentQuestionNumber + '/' + payload.questionsNumber + '>');
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }

    return new QuestionNumberControl();
});
