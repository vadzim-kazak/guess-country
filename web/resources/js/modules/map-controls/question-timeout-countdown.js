/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery', 'modules/knob-tron-style', 'knob'], function($, knobStyle) {

    var TimeoutCounterControl = function() {

        // Singletone
        if (TimeoutCounterControl.prototype._singletonInstance) {
            return TimeoutCounterControl.prototype._singletonInstance;
        }
        TimeoutCounterControl.prototype._singletonInstance = this;

        var controlDiv = $('<div/>', {
            css: {
                marginRight: '15px'
            }
        });
        controlDiv.addClass('custom-controls-hidden');

        var countdownCounter =  $('<input/>', {
            type: 'text'
        });

        controlDiv.append(countdownCounter);

        countdownCounter.knob({
            'width': knobStyle.timeoutKnobSize,
            'height': knobStyle.timeoutKnobSize,
            'fgColor': knobStyle.usualColor,
            'inputColor': knobStyle.usualColor,
            'readOnly':true,
            'draw' : knobStyle.tronDrawFunction
        });

        this.getControl = function() {
            return controlDiv[0];
        }

        this.displayValue = function(seconds) {
            controlDiv.removeClass('custom-controls-hidden');

            var warningColorThreshold = 10;
            var color = knobStyle.usualColor;
            if (seconds < warningColorThreshold) {
                color = knobStyle.warningColor[seconds];
            }

            countdownCounter.trigger('configure',
                                    {'fgColor': color,
                                     'inputColor': color})
                            .val(seconds).trigger('change');
        }

        this.hide = function() {
            controlDiv.addClass('custom-controls-hidden');
        }
    }

    return new TimeoutCounterControl();
});