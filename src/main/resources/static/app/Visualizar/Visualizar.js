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
                var puntos=[];
                
                function simple() {
                    if (GBrowserIsCompatible()) {
                        var map = new GMap2(document.getElementById("map1"));
                        map.setCenter(new GLatLng(4.6203798, -74.1096943), 11);
                        map.setUIToDefault();
                        var geocoder = new GClientGeocoder();
                        for(var index = 0; index < $scope.establecimientos.length; index++) {   
                            geocoder.getLatLng($scope.establecimientos[index].direccion+"Bogota", function(point){ 
                                if (!point) { 
                                  alert($scope.establecimientos[index].direccion + " not found"); 
                                } 
                                else { 
                                    var marker = new GMarker (new GLatLng(point.lat(), point.lng())); 
                                    map.addOverlay(marker);
                                    console.log("puntoAgregado1");
                                    return point; 
                                } 
                            });                     
                        } 
                    
                    }
                }           
                window.onload = function () {
                   simple();
                };                                      
               console.log('Salio visualizacion');
}]);
