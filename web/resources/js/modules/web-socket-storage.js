/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery', 'modules/web-socket-message-handlers'], function($, messageHandlersProvider) {

    /** **/
    var hostAddress = 'ws://${websocket.host}:${websocket.port}/${app.context.path}${websocket.path}';

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

                socket.onclose = function(closeEvent){
                    console.log('Socket has been closed...');
                    if (!closeEvent.wasClean) {
                        messageHandlersProvider.handleWebsocketNotSupported();
                        console.log('Try to use other browser');
                    }
                }

                socket.onmessage = function (event){
                     messageHandlersProvider.handleMessage(event);
                }

            } else {
                messageHandlersProvider.handleWebsocketNotSupported();
                console.log('Websocket not supported');
            }
        });

        this.hasWebSocketSupport = function() {
            return hasWebSocketSupport;
        }

    }

    return new WebSocketStorage();
});