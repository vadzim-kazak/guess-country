/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery'], function($) {


    var QuestionPlaceholderControl = function () {

        // Singletone
        if (QuestionPlaceholderControl.prototype._singletonInstance) {
            return QuestionPlaceholderControl.prototype._singletonInstance;
        }
        QuestionPlaceholderControl.prototype._singletonInstance = this;

        var textColor = "#029acf";

        var controlDiv = $('<div></div>');
        controlDiv.addClass('custom-controls-hidden');


        var questionPlaceholder =  $('<div/>', {
            id: 'questionPlaceholder'
        });

        questionPlaceholder.addClass('question-placeholder');
        questionPlaceholder.addClass('hud-color');

        controlDiv.append(questionPlaceholder);

        this.showQuestion = function (question) {
            controlDiv.removeClass('custom-controls-hidden');
            questionPlaceholder.text('<?> ' + question);
        }

        this.hide = function() {
            controlDiv.addClass('custom-controls-hidden');
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }

    return new QuestionPlaceholderControl();
});
