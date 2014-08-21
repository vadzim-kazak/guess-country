/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery','google-maps-loader', 'modules/google-maps-style', 'modules/web-socket'],
    function($, GoogleMapsLoader, mapStyle, socket) {

        var mapOptions = {
            center: new google.maps.LatLng(50, 0),
            zoom: 4,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            styles: mapStyle
        };

        var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

        google.maps.event.addListener(map, 'click', function(event) {
            handleMapClickEvent(map, event);
        });

        var handleMapClickEvent = function(map, event) {

            var reverseGeocodingUrl = 'https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyCTDpNd2DNFRN6SDOMmJ0aW0aLx0MYp2yU' +
                '&result_type=country&latlng=';

            var fullUrl = reverseGeocodingUrl + event.latLng.lat() + ',' + event.latLng.lng();

            $.get(fullUrl, function(data) {

                var country = data.results[0].address_components[0].long_name;
                var countryCenter = data.results[0].geometry.location;

                var message = {
                    type: "answer",
                    lat: countryCenter.lat,
                    lng: countryCenter.lng,
                    answer: country
                }

                socket.send(JSON.stringify(message));
            });
        }

        return map;
});