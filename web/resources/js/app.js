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
        'Mustache': 'plugin/mustache'
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
    }
});

require( ['jquery', 'modules/web-socket-storage'],

    function($) {

        $(document).ready(function() {

        });
    }
);