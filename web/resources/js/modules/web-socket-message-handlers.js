/**
 * Created by Kazak_VV on 21.08.2014.
 */
define(['jquery', 'modules/google-maps', 'modules/map-controls/question-timeout-countdown', 'modules/map-controls/info-area',
    'modules/map-controls/scores', 'modules/map-controls/question-prepare-countdown', 'modules/map-controls/map-middle-info-area',
    'text!../../templates/answer-marker-template.html', 'Mustache', 'modules/map-controls/game-results', 'modules/map-controls/player-left',
    'modules/map-controls/question-number', 'richmarker', 'bootstrap'],
    function($, map, timeoutCountdown, infoArea, scores, prepareCountdown, middleInfoArea, markerContent, Mustache, gameResults, playerLeft,
             questionNumber) {

    /**
     *
     */
    var MessageHandlersProvider = function() {

        var marker;

        /**
         *
         */
        this.handleWebsocketNotSupported = function() {
            middleInfoArea.showWebSocketUnsupported();
            google.maps.event.trigger(map, 'resize');
        }

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
            } else if (type == 'PLAYER_LEFT') {
                handlePlayerLeft(payload);
            } else if (type == 'START_GAME') {
                handleStartGame(payload);
            }

            google.maps.event.trigger(map, 'resize');
        }

        /**
         *
         * @param payload
         */
        var handleCountdownMessage = function(payload) {
            middleInfoArea.hide();

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
                google.maps.event.trigger(map, 'resize');

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
            infoArea.showQuestion(payload);
            questionNumber.show(payload);
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
            middleInfoArea.showWaitingForOtherPlayer();
        }

        /**
         *
         * @param payload
         */
        var handleGameFinishedMessage = function(payload) {

            // hide custom game controls
            timeoutCountdown.hide();
            scores.hide();
            infoArea.hide();

            // hide marker
            marker.setMap(null);

            gameResults.showResults(payload);
        }

        /**
         *
         * @param payload
         */
        var handleAnswerResult = function(payload) {

            //questionNumber.hide();

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

            scores.updateScores(payload);

            if (payload.answerOwner) {
                if (payload.rightAnswer) {
                    infoArea.confirmAnswer(payload.answer);
                } else {
                    infoArea.showWrongAnswer(payload.answer);
                }
            }

            if(payload.rightAnswer || payload.answerOwner) {
                timeoutCountdown.hide();
            }

            google.maps.event.trigger(map, 'resize');
            map.panTo(answerPosition);
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

        var handlePlayerLeft = function(payload) {
            playerLeft.show();
        }

        var handleStartGame = function(payload) {
            middleInfoArea.showStartGame(payload);
            scores.init(payload);
        }

        /**
         *
         */
        var hideHUD = function() {

            timeoutCountdown.hide();
            //scores.hide();
            infoArea.hide();
            //questionNumber.hide();
        }

    }

    return new MessageHandlersProvider();
});