'use strict';

angular.module('myApp.Reservar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Reservar', {
    templateUrl: 'Reservar/Reservar.html',
    controller: 'ReservarCtrl'
  });
}])

.controller('ReservarCtrl', ['$scope', 'canchaService','reservaService','estService','$location', function ($scope, canchaService, reservaService, estService,$location) {  
   $scope.canchas= canchaService.query();
 
    $scope.id ="";  
    $scope.fechareserva ="";  
    $scope.precio ="";  
    $scope.tiempo ="";
    $scope.usuarioId ="";
    
    var lista = [];
    $scope.listado = estService.query(function(data){
            lista=data;
              for (var index = 0; index < lista.length; index++) { 
            }
       });
    
  $scope.agregarReserva = function(){
        
        var reserva = {"id":{"idReserva":$scope.idreserva, "nitEstablecimiento":$scope.nitEstablecimiento}, "fechareserva":$scope.fechareserva, "precio":$scope.precio, "tiempo":$scope.tiempo, "usuarioId":$scope.usuarioId};
          
       // var reserva = {"fechaReserva":$scope.fechaReserva, "tiempo":$scope.tiempo,"usuarioId":$scope.usuarioId};
       console.info("Reserva Agregado123");
       
       reservaService.save(reserva,function(){
                   console.log("Entro");
                $location.path("/Visualizar");
        });    
        
    
    };  
        
     
}]);  
    
    
    
      
    
    
   
