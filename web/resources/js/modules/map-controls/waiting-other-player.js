/**
 * Created by Kazak_VV on 26.08.2014.
 */
define(['jquery', 'modules/knob-tron-style', 'text!../../../templates/waiting-other-template.html', 'knob'],
    function($, tronDrawFunction, htmlTemplate) {


        var WaitingOtherControl = function() {

            // Singletone
            if (WaitingOtherControl.prototype._singletonInstance) {
                return WaitingOtherControl.prototype._singletonInstance;
            }
            WaitingOtherControl.prototype._singletonInstance = this;

            var textColor = "#029acf";

            var controlDiv = $('<div/>', {
                css: {

                }
            });
            controlDiv.hide();

            var template = $(htmlTemplate);
            controlDiv.append(template);

            this.hide = function() {
                controlDiv.hide();
            }

            this.show = function() {
                controlDiv.show();
            }

            this.getControl = function() {
                return controlDiv[0];
            }

        }

        return new WaitingOtherControl();
});