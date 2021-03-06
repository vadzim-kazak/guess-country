/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery','google-maps-loader', 'modules/google-maps-style', 'modules/map-controls/question-timeout-countdown',
        'modules/map-controls/info-area', 'modules/map-controls/scores', 'modules/map-controls/question-prepare-countdown',
        'modules/map-controls/map-middle-info-area', 'modules/map-controls/game-results', 'modules/map-controls/player-left',
        'modules/map-controls/question-number'],
    function($, GoogleMapsLoader, mapStyle, timeoutCountdown, infoArea, scores, prepareCountdown, middleInfoArea, gameResults, playerLeft, questionNumber) {

        var mapOptions = {
            center: new google.maps.LatLng(50, 20),
            zoom: 5,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            styles: mapStyle,
            disableDefaultUI: true, // a way to quickly hide all controls
            scaleControl: true,
            zoomControl: true,
            panControl: true
        };

        var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

        map.controls[google.maps.ControlPosition.CENTER].push(middleInfoArea.getControl());
        map.controls[google.maps.ControlPosition.CENTER].push(prepareCountdown.getControl());
        map.controls[google.maps.ControlPosition.CENTER].push(gameResults.getControl());
        map.controls[google.maps.ControlPosition.TOP_RIGHT].push(questionNumber.getControl());
        map.controls[google.maps.ControlPosition.RIGHT_TOP].push(scores.getControl());
        map.controls[google.maps.ControlPosition.RIGHT_TOP].push(timeoutCountdown.getControl());
        map.controls[google.maps.ControlPosition.TOP_CENTER].push(infoArea.getControl());
        map.controls[google.maps.ControlPosition.BOTTOM].push(playerLeft.getControl());

        google.maps.event.trigger(map, 'resize');

        google.maps.event.addListener(map, 'click', function(event) {
            handleMapClickEvent(map, event);
        });

        var webSocketStorage = null;

        var handleMapClickEvent = function(map, event) {

            if (webSocketStorage == null) {

                require(['modules/web-socket-storage'], function(loadedWebSocketStorage) {
                    webSocketStorage = loadedWebSocketStorage;
                });
            }

            // Handle map clicks only when prepare countdown is not displayed
            if (!prepareCountdown.isVisible()) {

                var reverseGeocodingUrl = 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCTDpNd2DNFRN6SDOMmJ0aW0aLx0MYp2yU' +
                    '&result_type=country&latlng=';

                var fullUrl = reverseGeocodingUrl + event.latLng.lat() + ',' + event.latLng.lng();

                $.get(fullUrl, function(data) {

                    var geoData = data.results[0];
                    if (geoData) {
                        var country = geoData.address_components[0].short_name;
                        var countryCenter = data.results[0].geometry.location;

                        var message = {
                            type: "answer",
                            answer: country
                        }

                        webSocketStorage.getWebSocket().send(JSON.stringify(message));
                    }
                });
            }

        }

        return map;
});