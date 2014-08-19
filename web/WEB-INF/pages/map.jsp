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


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen">
    <style type="text/css">

        .navbar.no-bottom-margin {
            margin-bottom: 0;
        }

        .map-height {
            height: 96%;
        }

    </style>

    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTDpNd2DNFRN6SDOMmJ0aW0aLx0MYp2yU"></script>
    <script type="text/javascript">

        function initialize() {
            var mapOptions = {
                center: new google.maps.LatLng(50, 0),
                zoom: 4
            };
            var map = new google.maps.Map(document.getElementById("map-canvas"),
                    mapOptions);
        }
        google.maps.event.addDomListener(window, 'load', initialize);


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
                    var receivedData = $.parseJSON(evt.data);

                    if(receivedData.type == 'COUNTDOWN') {
                        $('#countdown').text(JSON.stringify(receivedData.payload.seconds));
                    } else if(receivedData.type == 'QUESTION') {
                        $('#question').text(JSON.stringify(receivedData.payload.message));
                    } else {
                        $('#response').text(JSON.stringify(receivedData.payload));
                    }
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

    <!--

   <h3>Map page</h3>
   <div id="response"></div>
   <br/>
   Answer: <input type="text" id="answer" /><input type="button" value="send" onclick="sendAnswer()" />
   <br/>
   <div id="countdown"></div>
   !-->

    <!-- Navbar -->
    <div class="navbar no-bottom-margin navbar-default">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Guess country</a>
        </div>
        <div class="navbar-collapse collapse navbar-responsive-collapse">
            <ul class="nav navbar-nav">
                <li class="navbar-text">Question: <span id="question"></span></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="navbar-text">Scores:</li>
                <li class="navbar-text">Countdown: <span id="countdown"></span></li>
            </ul>
        </div>
    </div>

    <!-- Map -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 map-height" id="map-canvas">
            </div>
        </div>
    </div>


</body>
</html>
