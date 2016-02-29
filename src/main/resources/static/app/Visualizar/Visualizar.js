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
                       map.setCenter(new GLatLng(40.466997, -3.705482), 11);
                       map.setUIToDefault();
                       
                        var point = new GLatLng(4.710031, -74.077945);
                        var marker = new GMarker(point);  
                        map.addOverlay(marker);         
                        marker.openInfoWindowHtml('Hello, <strong>World!</strong>');
                   }
                }
                window.onload = function () {
                   simple();
                }                          

               
               console.log('Salio visualizacion');
}]);
