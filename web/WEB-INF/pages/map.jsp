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

        .modal-dialog {
            padding-top: 20%;
        }

        .alert.no-bottom-margin {
            margin-bottom: 0;
        }

    </style>

    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTDpNd2DNFRN6SDOMmJ0aW0aLx0MYp2yU"></script>
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script src="${pageContext.request.contextPath}/resources/js/richmarker-compiled.js"></script>
    <script type="text/javascript">

        function initialize() {

            var mapStyle = [
                {
                    "featureType": "road",
                    "elementType": "geometry",
                    "stylers": [
                        {
                            "visibility": "off"
                        }
                    ]
                },
                {
                    "featureType": "poi",
                    "elementType": "geometry",
                    "stylers": [
                        {
                            "visibility": "off"
                        }
                    ]
                },
                {
                    "featureType": "landscape",
                    "elementType": "geometry",
                    "stylers": [
                        {
                            "color": "#dddddd"
                        }
                    ]
                },
                {
                    "featureType": "road",
                    "elementType": "labels",
                    "stylers": [
                        {
                            "visibility": "off"
                        }
                    ]
                },
                {
                    "featureType": "transit",
                    "stylers": [
                        {
                            "visibility": "off"
                        }
                    ]
                },
                {
                    featureType: "administrative.country",
                    elementType: "labels",
                    stylers: [
                        { visibility: "off" }
                    ]
                },
                {
                    featureType: "administrative.locality",
                    elementType: "labels",
                    stylers: [
                        { visibility: "off" }
                    ]
                },
                {
                    featureType: "administrative.province",
                    elementType: "labels",
                    stylers: [
                        { visibility: "off" }
                    ]
                }
            ]



            var mapOptions = {
                center: new google.maps.LatLng(50, 0),
                zoom: 4,
                mapTypeId: google.maps.MapTypeId.ROADMAP,
                styles: mapStyle
            };

            var map = new google.maps.Map(document.getElementById("map-canvas"),
                    mapOptions);

            google.maps.event.addListener(map, 'click', function(event) {
                //alert(JSON.stringify(event.latLng));

                //
                var reverseGeocodingUrl = 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCTDpNd2DNFRN6SDOMmJ0aW0aLx0MYp2yU' +
                        '&result_type=country&latlng=';
                var fullUrl = reverseGeocodingUrl + event.latLng.lat() + ',' + event.latLng.lng();
                $.get( fullUrl, function(data) {

                    var country = data.results[0].address_components[0].long_name;
                    var message = {
                        type: "answer",
                        answer: country
                    }
                    socket.send(JSON.stringify(message));

                    var countryCenter = data.results[0].geometry.location;

                    map.panTo(countryCenter);
                    new RichMarker({
                        position: new google.maps.LatLng(countryCenter.lat, countryCenter.lng),
                        map: map,
                        draggable: false,
                        content: '<div>' + country + '</div>'
                    });
                });
            });
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
                        hideWaitingModal();
                        $('#countdown').text(JSON.stringify(receivedData.payload.seconds));

                    } else if(receivedData.type == 'QUESTION') {

                        hideWaitingModal();
                        $('#question').text(JSON.stringify(receivedData.payload.message));

                    } else if(receivedData.type == 'WAITING_FOR_OTHER_PLAYER') {

                        displayWaitingModal(receivedData.payload.message);

                    } else {

                        $('#response').text(JSON.stringify(receivedData.payload));
                    }
                }

            } else {
                console.log('Websocket not supported');
            }
        }

        function displayWaitingModal(message) {
            $('#waitingMessage').text(message);
            $('#waitingForOtherPlayerModal').modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });
        }

        function hideWaitingModal() {
            $('#waitingForOtherPlayerModal').modal('hide');
        }

        /**
         *
         */
        function sendAnswer() {


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

    <!--Waiting fow other player modal... -->
    <div class="modal fade" id="waitingForOtherPlayerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-body">
                    <div class="container-fluid">

                        <div class="row alert no-bottom-margin alert-success">
                            <div class="col-lg-2">
                                <img src="${pageContext.request.contextPath}/resources/img/ajax-loader.gif">
                            </div>
                            <div class="col-lg-10">
                                <span id="waitingMessage"></span>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
