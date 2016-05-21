'use strict';

angular.module('myApp.Visualizar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Visualizar', {
    templateUrl: 'Visualizar/Visualizar.html',
    controller: 'CtrVisualizador'
  });
}])
.controller('CtrVisualizador',['$scope','Establecimiento','estService', '$filter','$location',function ($scope,Establecimiento,estService, $filter,$location) {
                console.log('Entro visualizacion');
                var establecimientosAux = [];
                var lista = [];
                var aux = {nombreEstablecimiento:"", direccion:""};
                $scope.valMin=0;
                $scope.valMax=100000;
                $scope.estMapa = estService.query(function(data){
                    lista=data;
                    for (var index = 0; index < lista.length; index++) {                                            
                        aux={nombreEstablecimiento:lista[index].razonSocial, direccion:lista[index].direccion};
                        establecimientosAux.push(aux);
                    }$scope.estable=establecimientosAux;

                    /*Ubica Puntos de establecimientos en el mapa*/

                    google.load('maps', '2', {callback: simple});
                    var puntos=[];

                    function simple() {
                       var btn= document.getElementById("Botones");
                       btn.style.visibility="visible";
                       var btn= document.getElementById("Menu");
                       btn.style.visibility="Hidden";
                        if (GBrowserIsCompatible()) {
                            var map = new GMap2(document.getElementById("map1"));
                            map.setCenter(new GLatLng(4.6203798, -74.1096943), 11);
                            map.setUIToDefault();
                            var geocoder = new GClientGeocoder();
                            for(var index = 0; index < $scope.estable.length; index++) { 
                                geocoder.getLatLng($scope.estable[index].direccion+"Bogota", function(point){ 
                                    if (!point) { 
                                      //alert($scope.estable[index].direccion + " not found"); 
                                    } 
                                    else { 
                                        var marker = new GMarker (new GLatLng(point.lat(), point.lng()));   
                                        map.addOverlay(marker);
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
                });     
        
        	$scope.establecimientos= Establecimiento.query();
                    

               $scope.filtrarPrecio = function(){
                    var min;
                    var max;
                    var lista = [];
                    var aux = {nombreEstablecimiento:"", telefono:"", direccion:"", numCancha:0, precio:0};
                    var establecimientos = [];
                    
                    min = $scope.valMin;
                    max = $scope.valMax;
                    
                    lista=$scope.estMapa;
                        for (var index = 0; index < lista.length; index++) {  
                            for (var i = 0; i < lista[index].canchases.length; i++) {                     
                                for (var j = 0; j < lista[index].canchases[i].horarioses.length; j++) {                     
                                    if(lista[index].canchases[i].horarioses[j].precio < max && lista[index].canchases[i].horarioses[j].precio >=min){
                                        aux={nombreEstablecimiento:lista[index].razonSocial, telefono:lista[index].telefono, direccion:lista[index].direccion,
                                            numCancha:lista[index].canchas[i].idCancha, precio:lista[index].canchas[i].precio,nit:lista[index].nit};
                                        establecimientos.push(aux);
                                    }        
                                }
                            }          
                        } 
                    $scope.estable=establecimientos;
                };	
                
                $scope.irCalificar=function(nit){
                    var establecimiento=document.getElementById("establecimiento")
                    establecimiento.value=nit;
                    $location.path("/Calificar");
                }
                
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
        
        
        $scope.hrefs = function (nit) {
            location.href="#InfoEstablecimiento?nit=" + nit;
        };
        
}]);
