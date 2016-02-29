'use strict';

angular.module('myApp.vistaFiltrar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Filtrar', {
    templateUrl: 'Filtrar/Filtrar.html',
    controller: 'FiltrarCtrl'
  });
}])

.controller('FiltrarCtrl',  ['$scope', 'estService', '$filter', function($scope, estService, $filter) {        
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
        var aux = {nombreEstablecimiento:"", numCancha:0, precio:0};
        var canchas = [];
        var lista = [];
         $scope.listado = estService.query(function(data){
            lista=data;
            for (var i = 0; i < lista.length; i++){
             for (var j = 0; j < lista[i].canchas.length; j++) {                
                 aux={nombreEstablecimiento:lista[i].razonSocial, numCancha:lista[i].canchas[j].idCancha, precio:lista[i].canchas[j].precio};
                     canchas.push(aux);
                 }
            } $scope.canchas=canchas;
        });  
    };   
     $scope.filtrarUbicacion = function(address){
     var output = document.getElementById("map_canvas");
        if (!navigator.geolocation){
          output.innerHTML = "<p>Geolocation is not supported by your browser</p>";
          return;
        }

        function success(position) {
          var latitude  = position.coords.latitude;
          var longitude = position.coords.longitude;

          output.innerHTML = '<p>Latitude is ' + latitude + '° <br>Longitude is ' + longitude + '°</p>';

          var img = new Image();
          img.src = "http://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=13&size=300x300&sensor=false";

          output.appendChild(img);
        };

        function error() {
          output.innerHTML = "Unable to retrieve your location";
        };

        output.innerHTML = "<p>Locating…</p>";

        navigator.geolocation.getCurrentPosition(success, error);
     };
}]);