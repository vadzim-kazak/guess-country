/**
 * Created by Kazak_VV on 21.08.2014.
 */

require.config({
    paths: {
        'async': 'plugin/async',
        'text': 'plugin/text',
        'google-maps-loader': 'modules/google-maps-loader',
        'richmarker': 'modules/richmarker.min',
        'bootstrap': 'modules/bootstrap.min',
        'knob': 'plugin/jquery.knob.min',
        'Mustache': 'plugin/mustache',
        'Pace': 'modules/pace.min'
    },
    shim: {
        'google-maps-loader': {
            exports: 'google'
        },
        'richmarker': {
            deps: ['google-maps-loader']
        },
        'bootstrap': {
            deps: ['jquery'],
            exports: '$.fn.popover'
        },
        'knob': {
            deps: ['jquery']
        }
    },
    waitSeconds: 20
});

require(['Pace'], function(Pace) {

        Pace.start({ajax: false, // disabled
                    document: false, // disabled
                    eventLag: false // disabled
                   });
        require( ['jquery', 'modules/web-socket-storage'],

            function($) {
                Pace.stop();
                $(document).ready(function() {

                });
            }
        );
    }
);