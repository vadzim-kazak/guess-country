/**
 * Created by Kazak_VV on 02.09.2014.
 */
define(['jquery', 'text!../../../templates/websoket-not-supported-template.html'],
    function($, template) {

        var WebSocketIssueControl = function() {

            // Singletone
            if (WebSocketIssueControl.prototype._singletonInstance) {
                return WebSocketIssueControl.prototype._singletonInstance;
            }
            WebSocketIssueControl.prototype._singletonInstance = this;

            var controlDiv = $('<div/>', {});
            controlDiv.hide();
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

        return new WebSocketIssueControl();
    });