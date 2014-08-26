/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery', 'modules/knob-tron-style', 'text!../../../templates/question-prepare-template.html', 'knob'],
    function($, tronDrawFunction, htmlTemplate) {

    var PrepareCounterControl = function() {

        // Singletone
        if (PrepareCounterControl.prototype._singletonInstance) {
            return PrepareCounterControl.prototype._singletonInstance;
        }
        PrepareCounterControl.prototype._singletonInstance = this;

        var controlDiv = $('<div/>');
        controlDiv.addClass('custom-controls-hidden');

        var countdownCounter =  $('<input/>', {
            type: 'text'
        });

        var circleSize = 250;
        var textColor = '#5876a1';

        var template = $(htmlTemplate);
        controlDiv.append(template);

        template.find('#knobContainer').append(countdownCounter);

        countdownCounter.knob({
            'width': circleSize,
            'height': circleSize,
            'fgColor': textColor,
            'readOnly':true,
            'skin': 'tron',
            'draw' : tronDrawFunction
        });

        this.getControl = function() {
            return controlDiv[0];
        }

        this.displayValue = function(seconds) {
            controlDiv.removeClass('custom-controls-hidden');
            countdownCounter.val(seconds).trigger('change');
        }

        this.hide = function() {
            controlDiv.addClass('custom-controls-hidden');
        }

        this.isVisible = function() {
            return !controlDiv.hasClass('custom-controls-hidden');
        }
    }

    return new PrepareCounterControl();
});