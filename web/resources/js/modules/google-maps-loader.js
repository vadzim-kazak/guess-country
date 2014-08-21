///**
// * Created by Kazak_VV on 21.08.2014.
// */
///**
// * GoogleMapsAPI Loader Module
// *
// * Returns a promise that resolves with the google.maps object when all of the google maps api loading process is complete
// *
// * Example Usage:
// *
// * 	define([ 'app/lib/google-maps-loader' ], function(GoogleMapsLoader){
// * 		GoogleMapsLoader.done(function(GoogleMaps){
// *			// your google maps code here!
// *			var geocoder = new GoogleMaps.Geocoder();
// *		}).fail(function(){
// *			console.error("ERROR: Google maps library failed to load");
// *		});
// *	});
// *
// *	-OR-
// *
// *	define([ 'app/lib/google-maps-loader' ], function(GoogleMapsLoader){
// * 		GoogleMapsLoader.done(function(){
// *			// your google maps code here!
// *			var geocoder = new google.maps.Geocoder();
// *		}).fail(function(){
// *			console.error("ERROR: Google maps library failed to load");
// *		});
// *	});
// *
// */
//
//var google_maps_loaded_def = null;
//
//define(['jquery'],function($) {
//
//    if(!google_maps_loaded_def) {
//
//        google_maps_loaded_def = $.Deferred();
//
//        window.google_maps_loaded = function() {
//            google_maps_loaded_def.resolve(google.maps);
//        }
//
//        require(['http://maps.googleapis.com/maps/api/js?key=AIzaSyCTDpNd2DNFRN6SDOMmJ0aW0aLx0MYp2yU&callback=google_maps_loaded'],
//            function(){},function(err) {
//            google_maps_loaded_def.reject();
//            //throw err; // maybe freak out a little?
//        });
//
//    }
//
//    return google_maps_loaded_def.promise();
//});

define(['async!http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyCTDpNd2DNFRN6SDOMmJ0aW0aLx0MYp2yU'], function() {
    // Google Maps API and all its dependencies will be loaded here.
});