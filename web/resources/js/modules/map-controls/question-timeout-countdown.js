/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery', 'modules/knob-tron-style', 'knob'], function($, tronDrawFunction) {

    var TimeoutCounterControl = function() {

        // Singletone
        if (TimeoutCounterControl.prototype._singletonInstance) {
            return TimeoutCounterControl.prototype._singletonInstance;
        }
        TimeoutCounterControl.prototype._singletonInstance = this;

        var usualColor = "#5876a1";
        var warningColor = "#ff0000";
        var sideSize = 75;

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
            'width': sideSize,
            'height': sideSize,
            'fgColor': usualColor,
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
    }

    return new TimeoutCounterControl();
});