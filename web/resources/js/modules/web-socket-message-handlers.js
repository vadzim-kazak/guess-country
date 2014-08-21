/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery', 'modules/google-maps', 'richmarker', 'bootstrap'], function($, map) {

    /**
     *
     */
    var MessageHandlersProvider = function() {

        var marker;

        /**
         *
         * @param event
         */
        this.handleMessage = function(event) {

            var receivedData = $.parseJSON(event.data);

            var type = receivedData.type;
            var payload = receivedData.payload;

            if(type == 'COUNTDOWN') {
                handleCountdownMessage(payload);
            } else if(type == 'QUESTION') {
                handleQuestionMessage(payload);
            } else if(type == 'RESULT') {
                handleResultMessage(payload);
            } else if(type == 'WAITING_FOR_OTHER_PLAYER') {
                handleWaitingOtherPlayerMessage(payload);
            }
        }

        /**
         *
         * @param payload
         */
        var handleCountdownMessage = function(payload) {
            hideWaitingModal();
            $('#countdown').text(JSON.stringify(payload.seconds));
        }

        /**
         *
         * @param payload
         */
        var handleQuestionMessage = function(payload) {
            hideWaitingModal();
            $('#question').text(JSON.stringify(payload.message));
        }

        /**
         *
         * @param payload
         */
        var handleResultMessage = function(payload) {
            handleAnswerResult(payload);
        }

        /**
         *
         * @param payload
         */
        var handleWaitingOtherPlayerMessage = function(payload) {
            displayWaitingModal(payload.message);
        }

        /**
         *
         * @param message
         */
        var displayWaitingModal = function(message) {
            $('#waitingMessage').text(message);
            $('#waitingForOtherPlayerModal').modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });
        }

        /**
         *
         */
        var hideWaitingModal = function() {
            $('#waitingForOtherPlayerModal').modal('hide');
        }

        /**
         *
         * @param payload
         */
        var handleAnswerResult = function(payload) {

            var answerPosition =  new google.maps.LatLng(payload.latLng.latitude, payload.latLng.longitude);
            var countryName = payload.answer;

            var markerStyle;
            if (payload.rightAnswer) {
                markerStyle = "right-answer ";
            } else {
                markerStyle = "wrong-answer ";
            }

            var markerContent = '<div class="' + markerStyle + '">' + countryName + '</div>';

            map.panTo(answerPosition);

            if (typeof marker !== 'undefined') {
                marker.setMap(null);
            }

            marker = new RichMarker({
                position: answerPosition,
                map: map,
                draggable: false,
                content: markerContent
            });
        }

    }

    return new MessageHandlersProvider();
});