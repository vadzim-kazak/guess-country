/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery'], function($) {


    var QuestionPlaceholder = function () {

        // Singletone
        if (QuestionPlaceholder.prototype._singletonInstance) {
            return QuestionPlaceholder.prototype._singletonInstance;
        }
        QuestionPlaceholder.prototype._singletonInstance = this;

        var textColor = "#5876a1";

        var controlDiv = $('<div></div>');

        var questionPlaceholder =  $('<div/>', {
            id: 'questionPlaceholder'
        });

        questionPlaceholder.css({ 'color': textColor, 'font-size': '250%' });

        controlDiv.append(questionPlaceholder);
        controlDiv.hide();

        this.showQuestion = function (question) {
            controlDiv.show();
            questionPlaceholder.text('<?> ' + question);
        }

        this.hide = function() {
            controlDiv.hide();
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }

    return new QuestionPlaceholder();
});
