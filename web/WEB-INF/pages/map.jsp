<%--
  Created by IntelliJ IDEA.
  User: Kazak_VV
  Date: 30.07.2014
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">

        function connect() {
            if ('WebSocket' in window){
                console.log('Websocket supported');
                socket = new WebSocket('ws://localhost:8080/guesscountry/websocket');

                console.log('Connection attempted');

                socket.onopen = function(){
                    console.log('Connection open!');
                }

                socket.onclose = function(){
                    console.log('Disconnecting connection');
                }

                socket.onmessage = function (evt)
                {
                    var received_msg = evt.data;
                    console.log(received_msg);
                    console.log('message received!');
                    $('#response').text(received_msg);
                }

            } else {
                console.log('Websocket not supported');
            }
        }

        /**
         *
         */
        function sendAnswer() {

            var message = {
                type: "answer",
                answer: $('#answer').val()
            }

            socket.send(JSON.stringify(message));
        }

        $( document ).ready(function() {
            connect();
        });

    </script>

</head>
<body>

   <h3>Map page</h3>
   <div id="response"></div>
   <br/>
   Answer: <input type="text" id="answer" /><input type="button" value="send" onclick="sendAnswer()" />


</body>
</html>
