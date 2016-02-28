'use strict';

angular.module('myApp.Visualizar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Visualizar', {
    templateUrl: 'Visualizar/Visualizar.html',
    controller: 'ControladorVisualizacion'
  });
}])
.controller('ControladorVisualizacion',['$scope','Establecimiento',function ($scope,Establecimiento) {
                google.load('maps', '2', {callback: simple});
                console.log(Establecimiento.query().toString());
        	$scope.establecimientos= Establecimiento.query();
                var map;
                function simple() {
                   if (GBrowserIsCompatible()) {
                       var map = new GMap2(document.getElementById("map1"));
                       map.setCenter(new GLatLng(4.61, -74.08), 4);
                   }
                }
                window.onload = function () {
                   simple();
                }                          

               
}]);