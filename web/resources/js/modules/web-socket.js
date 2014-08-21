/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery',], function($, messageHandlersProvider) {

    /** **/
    var hostAddress = 'ws://localhost:8080/guesscountry/websocket';

    if ('WebSocket' in window){

        var socket = new WebSocket(hostAddress);

        socket.onopen = function(){
            console.log('Socket has been opened...');
        }
        socket.onclose = function(){
            console.log('Socket has been closed...');
        }

        socket.onmessage = function (event){

            require(['modules/web-socket-message-handlers'],
                function(messageHandlersProvider){
                    messageHandlersProvider.handleMessage(event);
                }
            );
        }


        return socket;

    } else {
        console.log('Websocket not supported');
    }

    return;
});