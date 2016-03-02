'use strict';

angular.module('myApp.Visualizar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Visualizar', {
    templateUrl: 'Visualizar/Visualizar.html',
    controller: 'CtrVisualizador'
  });
}])
.controller('CtrVisualizador',['$scope','Establecimiento','estService', '$filter',function ($scope,Establecimiento,estService, $filter) {
                console.log('Entro visualizacion');
        	$scope.establecimientos= Establecimiento.query();
                google.load('maps', '2', {callback: simple});
                var puntos=[];
                
                function simple() {
                    if (GBrowserIsCompatible()) {
                        console.log("Entro a simple");
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
                    
                    }else{
                        alert("Error en cargar puntos"); 
                    }
                }           
                window.onload = function () {
                   simple();
                };                                      
               console.log('Salio visualizacion');
               $scope.filtrarPrecio = function(valor){
                    var min;
                    var max;
                    var lista = [];
                    var aux = {nombreEstablecimiento:"", telefono:"", direccion:"", numCancha:0, precio:0};
                    var establecimientos = [];
                    if(valor == 1){
                        min = 30.000;
                        max = 40.000;
                    }else if(valor == 2){
                        min = 40.000;
                        max = 50.000;
                    }else if(valor == 3){ 
                        min = 50.000;
                        max = 60.000;
                    }else if(valor == 4){ 
                        min = 60.000;
                        max = 70.000;
                    }else if(valor == 5){ 
                        min = 70.000;
                        max = 100.000;
                    }
                   $scope.listado = estService.query(function(data){
                        lista=data;
                        for (var index = 0; index < lista.length; index++) {  
                            for (var i = 0; i < lista[index].canchas.length; i++) {                     
                                if(lista[index].canchas[i].precio < max && lista[index].canchas[i].precio >=min){
                                    aux={nombreEstablecimiento:lista[index].razonSocial, telefono:lista[index].telefono, direccion:lista[index].direccion,
                                        numCancha:lista[index].canchas[i].idCancha, precio:lista[index].canchas[i].precio};
                                    establecimientos.push(aux);

                                }
                            }          
                        } $scope.estable=establecimientos;

                    });     
                };	

                $scope.ordenPrecio = function(){
                    var aux = {nombreEstablecimiento:"", telefono:"", direccion:"", numCancha:0, precio:0};
                    var canchas = [];
                    var lista = [];
                     $scope.listado = estService.query(function(data){
                        lista=data;
                        for (var i = 0; i < lista.length; i++){
                         for (var j = 0; j < lista[i].canchas.length; j++) {                
                             aux={nombreEstablecimiento:lista[i].razonSocial, telefono:lista[i].telefono, direccion:lista[i].direccion,
                                 numCancha:lista[i].canchas[j].idCancha, precio:lista[i].canchas[j].precio};
                                 canchas.push(aux);
                             }
                        } $scope.canchas=canchas;
                    });  
                };   
                 $scope.filtrarUbicacion = function(){

                    var latitude;
                    var longitude;
                         function success(position) {
                            latitude  = position.coords.latitude;
                            longitude = position.coords.longitude;
                            console.log("Latitude "+latitude+" Longitud:"+longitude);     
                       };
                       navigator.geolocation.getCurrentPosition(success);


                    };
}]);
