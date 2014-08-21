/**
 * Created by Kazak_VV on 21.08.2014.
 */

require.config({
    paths: {
        'async': 'plugin/async',
        'google-maps-loader': 'modules/google-maps-loader',
        'richmarker': 'modules/richmarker.min',
        'bootstrap': 'modules/bootstrap.min'
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
        }
    }
});

require( ['jquery', 'modules/web-socket-storage'],

    function($) {}
);