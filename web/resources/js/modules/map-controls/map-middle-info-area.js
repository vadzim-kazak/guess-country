/**
 * Created by Kazak_VV on 26.08.2014.
 */
define(['jquery', 'modules/knob-tron-style', 'text!../../../templates/map-middle-info-area-template.html', 'knob'],
    function($, tronDrawFunction, htmlTemplate) {


        var MapMiddleInfoAreaControl = function() {

            // Singletone
            if (MapMiddleInfoAreaControl.prototype._singletonInstance) {
                return MapMiddleInfoAreaControl.prototype._singletonInstance;
            }
            MapMiddleInfoAreaControl.prototype._singletonInstance = this;

            var controlDiv = $('<div/>', {});
            controlDiv.hide();

            var template = $(htmlTemplate);
            controlDiv.append(template);
            var textPlaceholder = controlDiv.find('#middleInfoArea');

            var playerNames = controlDiv.find('#playersInfoArea');
            playerNames.hide();

            this.hide = function() {
                controlDiv.hide();
            }

            this.showWaitingForOtherPlayer = function() {
                controlDiv.show();
                playerNames.hide();
                textPlaceholder.text('Waiting for second player...');
            }

            this.showWebSocketUnsupported = function() {
                controlDiv.show();
                playerNames.hide();
                textPlaceholder.text('You browser doesn\'t support websockets. Please try another one...');
            }

            this.showStartGame = function(payload) {

                textPlaceholder.text('Starting game...');

                var playersInfo = payload.players;
                if (playersInfo.length > 1) {
                    playerNames.show();
                    var firstPlayerName = playersInfo[0].name;
                    var secondPlayerName = playersInfo[1].name;
                    playerNames.text(firstPlayerName + ' vs ' + secondPlayerName);
                }

                controlDiv.show();
            }


            this.show = function() {
                controlDiv.show();
            }

            this.getControl = function() {
                return controlDiv[0];
            }

        }

        return new MapMiddleInfoAreaControl();
});