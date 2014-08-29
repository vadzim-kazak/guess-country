/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery', 'modules/knob-tron-style', 'text!../../../templates/question-prepare-template.html', 'knob'],
    function($, knobStyle, htmlTemplate) {

    var PrepareCounterControl = function() {

        // Singletone
        if (PrepareCounterControl.prototype._singletonInstance) {
            return PrepareCounterControl.prototype._singletonInstance;
        }
        PrepareCounterControl.prototype._singletonInstance = this;

        var controlDiv = $('<div/>', {});
        controlDiv.hide();

        var countdownCounter =  $('<input/>', {
            type: 'text'
        });

        var template = $(htmlTemplate);
        controlDiv.append(template);

        template.find('#knobContainer').append(countdownCounter);

        countdownCounter.knob({
            'width': knobStyle.prepareKnobSize,
            'height': knobStyle.prepareKnobSize,
            'fgColor': knobStyle.usualColor,
            'inputColor': knobStyle.usualColor,
            'readOnly':true,
            'draw' : knobStyle.tronDrawFunction
        });

        this.getControl = function() {
            return controlDiv[0];
        }

        this.displayValue = function(seconds) {
            countdownCounter.val(seconds).trigger('change');
            controlDiv.show();
        }

        this.hide = function() {
            controlDiv.hide();
        }

        this.isVisible = function() {
            return controlDiv.is(':visible');
        }
    }

    return new PrepareCounterControl();
});