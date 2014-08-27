/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery', 'modules/google-maps', 'modules/map-controls/question-timeout-countdown', 'modules/map-controls/question-placeholder',
    'modules/map-controls/scores', 'modules/map-controls/question-prepare-countdown', 'modules/map-controls/waiting-other-player',
    'text!../../templates/answer-marker.html', 'Mustache', 'richmarker', 'bootstrap'],
    function($, map, timeoutCountdown, questionPlaceholder, scores, prepareCountdown, waitingOther, markerContent, Mustache) {

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
            waitingOther.hide();

            if (payload.type == 'PREPARE_TO_QUESTION') {

                // 1) Hide all other controls
                hideHUD();

                // 2) Hide answer marker
                if (typeof marker !== 'undefined') {
                    marker.setMap(null);
                }

                // 3) Display prepare to question countdown
                prepareCountdown.displayValue(payload.seconds);

            } else if (payload.type == 'QUESTION_TIMEOUT') {
                prepareCountdown.hide();
                timeoutCountdown.displayValue(payload.seconds);
            }
        }

        /**
         *
         * @param payload
         */
        var handleQuestionMessage = function(payload) {
            questionPlaceholder.showQuestion(payload.message);
            scores.show();
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
            waitingOther.show();
        }

        /**
         *
         * @param payload
         */
        var handleAnswerResult = function(payload) {

            var answerPosition =  new google.maps.LatLng(payload.latLng.latitude, payload.latLng.longitude);

            var imagePath;
            if (payload.rightAnswer) {
                if(payload.answerOwner) {
                    imagePath = 'resources/img/right.png';
                } else {
                    imagePath = 'resources/img/right-other-player.png';
                }
            } else {
                if (payload.answerOwner) {
                    imagePath = 'resources/img/wrong.png';
                } else {
                    imagePath = 'resources/img/wrong-other-player.png';
                }
            }

            map.panTo(answerPosition);

            //Hide answer marker
            if (typeof marker !== 'undefined') {
                marker.setMap(null);
            }

            marker = new RichMarker({
                position: answerPosition,
                map: map,
                draggable: false,
                flat: true,
                anchor: RichMarkerPosition.MIDDLE,
                content: Mustache.render(markerContent, {imagePath: imagePath})
            });

            if (payload.answerOwner && payload.rightAnswer) {
                scores.updateScores(payload.scores);
            }
        }

        /**
         *
         */
        function hideHUD() {

            timeoutCountdown.hide();
            scores.hide();
            questionPlaceholder.hide();

        }

    }

    return new MessageHandlersProvider();
});