/**
 * Created by Kazak_VV on 01.09.2014.
 */
/**
 * Created by Kazak_VV on 25.08.2014.
 */
define(['jquery', 'text!../../../templates/player-left-template.html'], function($, template) {

    var PlayerLeftControl = function () {

        // Singletone
        if (PlayerLeftControl.prototype._singletonInstance) {
            return PlayerLeftControl.prototype._singletonInstance;
        }
        PlayerLeftControl.prototype._singletonInstance = this;

        var controlDiv = $('<div/>', {
            css: {
                marginBottom: '10px'
            }
        });
        controlDiv.hide();
        controlDiv.append(template);

        // in seconds
        var showMessagePeriod = 10;

        this.show = function() {
            controlDiv.show();
            setTimeout(function() { controlDiv.hide(); }, showMessagePeriod * 1000);
        }

        this.getControl = function() {
            return controlDiv[0];
        }
    }

    return new PlayerLeftControl();
});