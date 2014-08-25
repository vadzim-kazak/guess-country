/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery', 'knob'], function($) {

    var CountdownCounter = function() {

        // Singletone
        if (CountdownCounter.prototype._singletonInstance) {
            return CountdownCounter.prototype._singletonInstance;
        }
        CountdownCounter.prototype._singletonInstance = this;

        var usualColor = "#5876a1";
        var warningColor = "#ff0000";
        var circleWidth = 75;

        var controlDiv = $('<div></div>');

        var countdownCounter =  $('<input/>', {
            id: 'countdown',
            type: 'text'
        });

        controlDiv.css({ 'marginRight': '15px' });

        controlDiv.append(countdownCounter);

        countdownCounter.knob({
            'width': circleWidth,
            'fgColor': usualColor,
            'skin': 'tron',
            'draw' : function () {

                this.cursorExt = 0.3;

                var a = this.arc(this.cv)  // Arc
                    , pa                   // Previous arc
                    , r = 1;

                this.g.lineWidth = this.lineWidth;

                if (this.o.displayPrevious) {
                    pa = this.arc(this.v);
                    this.g.beginPath();
                    this.g.strokeStyle = this.pColor;
                    this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, pa.s, pa.e, pa.d);
                    this.g.stroke();
                }

                this.g.beginPath();
                this.g.strokeStyle = r ? this.o.fgColor : this.fgColor;
                this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, a.s, a.e, a.d);
                this.g.stroke();

                this.g.lineWidth = 2;
                this.g.beginPath();
                this.g.strokeStyle = this.o.fgColor;
                this.g.arc(this.xy, this.xy, this.radius - this.lineWidth + 1 + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false);
                this.g.stroke();

                return false;
            }
        });

        controlDiv.hide();

        this.getControl = function() {
            return controlDiv[0];
        }

        this.displayValue = function(seconds) {
            controlDiv.show();
            countdownCounter.val(seconds).trigger('change');
        }

        this.hideControl = function() {
            controlDiv.hide();
        }
    }


    return new CountdownCounter();
});