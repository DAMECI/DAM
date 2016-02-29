'use strict';

angular.module('myApp.Visualizar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Visualizar', {
    templateUrl: 'Visualizar/Visualizar.html',
    controller: 'CtrVisualizador'
  });
}])
.controller('CtrVisualizador',['$scope','Establecimiento',function ($scope,Establecimiento) {
                console.log('Entro visualizacion');
        	$scope.establecimientos= Establecimiento.query();
                google.load('maps', '2', {callback: simple});
                function simple() {
                   if (GBrowserIsCompatible()) {
                       var map = new GMap2(document.getElementById("map1"));
                       map.setCenter(new GLatLng(4.6203798, -74.1096943), 11);
                   }
                }
                window.onload = function () {
                   simple();
                }                          

               
               console.log('Salio visualizacion');
}]);
