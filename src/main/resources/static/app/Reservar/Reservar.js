'use strict';

angular.module('myApp.Reservar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Reservar', {
    templateUrl: 'Reservar/Reservar.html',
    controller: 'ReservarCtrl'
  });
}])

.controller('ReservarCtrl', ['$scope', 'canchaService','reservaService','$location', function ($scope, canchaService, reservaService,$location) {  
   $scope.canchas= canchaService.query();
   
    $scope.fechaReserva ="";  
    $scope.tiempo ="";
    $scope.usuarioId ="";
    
 
    
    
    $scope.agregarReserva = function(){
          
        var reserva = {"fechaReserva":$scope.fechaReserva, "tiempo":$scope.tiempo,"usuarioId":$scope.usuarioId};
       console.info("Reserva Agregado123");
       
       reservaService.save(reserva,function(){
                   console.log("Entro");
                $location.path("/Visualizar");
        });    
        
    
    };  
        
     
}]);  
