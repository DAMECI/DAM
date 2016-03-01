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
                        map.setUIToDefault();
                        var geocoder = new GClientGeocoder();
                        for(var index = 0; index < $scope.establecimientos.length; index++) {   
                            geocoder.getLatLng($scope.establecimientos[index].direccion, function(point){ 
                                if (!point) { 
                                  alert($scope.establecimientos[index].direccion + " not found"); 
                                } 
                                else { 
                                     console.log("punto"+point);
                                     return point; 
                                } 
                            }
                        ); 
                        //  geocoder.getLatLng($scope.establecimientos[index].direccion,geocodeResult);
                        } 
                        
                   }
                }
                
              /*  function geocodeResult(results, map) {
                    var map2 = new GMap2(document.getElementById("map1"));
                    var point = new GLatLng(4.6203798, -74.1096943);
                    var marker = new GMarker(point);  
                    map2.addOverlay(marker); 
                       var geocoder = new google.maps.Geocoder();
                       for(var index = 0; index < $scope.establecimientos.length; index++) {
                           geocoder.geocode({ 'address': $scope.establecimientos[index].direccion}, geocodeResult,map);
                           alert(index);
                        } 
                   }*/
                

                
                window.onload = function () {
                   simple();
                };                          

               
               console.log('Salio visualizacion');
}]);
