/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery', 'modules/google-maps', 'modules/map-controls/question-timeout-countdown', 'modules/map-controls/question-placeholder',
    'modules/map-controls/scores', 'modules/map-controls/question-prepare-countdown', 'modules/map-controls/waiting-other-player',
    'text!../../templates/answer-marker-template.html', 'Mustache', 'modules/map-controls/game-results', 'richmarker', 'bootstrap'],
    function($, map, timeoutCountdown, questionPlaceholder, scores, prepareCountdown, waitingOther, markerContent, Mustache, gameResults) {

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
            } else if (type == 'GAME_FINISHED') {
                handleGameFinishedMessage(payload)
            } else if (type == 'ANSWER_TIMEOUT') {
                handleAnswerTimeout(payload);
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

                //4)
                google.maps.event.trigger(map, 'resize')

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

            google.maps.event.trigger(map, 'resize')
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
            google.maps.event.trigger(map, 'resize')
        }

        /**
         *
         * @param payload
         */
        var handleGameFinishedMessage = function(payload) {

            // hide custom game controls
            timeoutCountdown.hide();
            scores.hide();
            questionPlaceholder.hide();

            // hide marker
            marker.setMap(null);

            gameResults.showResults(payload);

            google.maps.event.trigger(map, 'resize')
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

            if(payload.rightAnswer) {
                timeoutCountdown.hide();
            }
        }

        var handleAnswerTimeout = function(payload) {

            var countryCenter = payload.questionAnswer.latLng;
            var answerPosition =  new google.maps.LatLng(countryCenter.latitude, countryCenter.longitude);

            //Hide answer marker
            if (typeof marker !== 'undefined') {
                marker.setMap(null);
            }

            map.panTo(answerPosition);

            marker = new RichMarker({
                position: answerPosition,
                map: map,
                draggable: false,
                flat: true,
                anchor: RichMarkerPosition.BOTTOM,
                content: Mustache.render(markerContent, {imagePath: 'resources/img/map-location.png'})
            });

            timeoutCountdown.hide();
        }

        /**
         *
         */
        var hideHUD = function() {

            timeoutCountdown.hide();
            //scores.hide();
            questionPlaceholder.hide();
        }

    }

    return new MessageHandlersProvider();
});