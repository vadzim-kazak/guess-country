/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery', 'modules/web-socket-message-handlers'], function($, messageHandlersProvider) {

    /** **/
    var hostAddress = 'ws://192.168.0.102:8080/guesscountry/websocket';

    var WebSocketStorage = function () {

        if (WebSocket.prototype._singletonInstance) {
            return WebSocket.prototype._singletonInstance;
        }
        WebSocket.prototype._singletonInstance = this;

        var socket;

        this.getWebSocket = function() {
            return socket;
        }

        $(document).ready(function() {

            if ('WebSocket' in window){

                socket = new WebSocket(hostAddress);

                socket.onopen = function(){
                    console.log('Socket has been opened...');
                }

                socket.onclose = function(){
                    console.log('Socket has been closed...');
                }

                socket.onmessage = function (event){
                     messageHandlersProvider.handleMessage(event);
                }

            } else {
                console.log('Websocket not supported');
            }
        });
    }

    return new WebSocketStorage();
});