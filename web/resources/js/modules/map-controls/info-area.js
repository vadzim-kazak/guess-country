/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery', 'text!../../../templates/info-area-template.html'], function($, template) {


    var InfoAreaControl = function () {

        // Singletone
        if (InfoAreaControl.prototype._singletonInstance) {
            return InfoAreaControl.prototype._singletonInstance;
        }
        InfoAreaControl.prototype._singletonInstance = this;

        var controlDiv = $('<div></div>');
        controlDiv.hide();

        controlDiv.append(template);

        var textArea = controlDiv.find('#textArea');

        this.showQuestion = function (question) {
            controlDiv.show();

            textArea.text('<?> ' + question);
            textArea.removeClass();
            textArea.addClass('info-area-text-placeholder question-color');
        }

        this.confirmAnswer = function (answer) {
            controlDiv.show();

            textArea.text(answer);
            textArea.removeClass();
            textArea.addClass('info-area-text-placeholder right-answer');
        }

        this.showWrongAnswer = function(answer) {
            controlDiv.show();

            textArea.text(answer)
            textArea.removeClass();
            textArea.addClass('info-area-text-placeholder wrong-answer');
        }

        this.hide = function() {
            controlDiv.hide();
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }

    return new InfoAreaControl();
});
