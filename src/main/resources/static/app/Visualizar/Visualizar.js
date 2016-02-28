'use strict';

angular.module('myApp.Visualizar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Visualizar', {
    templateUrl: 'Visualizar/Visualizar.html',
    controller: 'ControladorVisualizacion'
  });
}])

.controller('ControladorVisualizacion',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
                google.load('maps', '2', {callback: simple});
               var map;
               function simple() {
                   if (GBrowserIsCompatible()) {
                       var map = new GMap2(document.getElementById("map1"));
                       map.setCenter(new GLatLng(20.0972, -81.6503), 4);
                   }
               }
               window.onload = function () {
                   simple();
               }                          
		
}]);