'use strict';

angular.module('myApp.Reservar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Reservar', {
    templateUrl: 'Reservar/Reservar.html',
    controller: 'ReservarCtrl'
  });
}])

.controller('ReservarCtrl', ['$scope', 'canchaService','reservaService','estService','$location', function ($scope, canchaService, reservaService, estService,$location) {  
<<<<<<< HEAD
    $scope.canchas= canchaService.query();
    $scope.fechaReserva ="";  
=======
   $scope.canchas= canchaService.query();
 
    $scope.id ="";  
    $scope.fechareserva ="";  
    $scope.precio ="";  
>>>>>>> 69c3938214a5698d940f2ddf0cd9bc6ac6f84e0e
    $scope.tiempo ="";
    $scope.ReservaId ={"idReserva":$scope.id.idreserva ="","nitEstablecimiento":$scope.id.nitEstablecimiento =""};
    $scope.usuarioId ="";
    
    var lista = [];
    $scope.listado = estService.query(function(data){
            lista=data;
              for (var index = 0; index < lista.length; index++) { 
            }
       });
    
  $scope.agregarReserva = function(){
        
        var reserva = {"id":{"idReserva":$scope.idreserva, "nitEstablecimiento":$scope.nitEstablecimiento}, "fechareserva":$scope.fechareserva, "precio":$scope.precio, "tiempo":$scope.tiempo, "usuarioId":$scope.usuarioId};
          
<<<<<<< HEAD
        var reserva = {"ReservaId":{"idReserva":$scope.id.idreserva, "nitEstablecimiento":$scope.id.nitEstablecimiento}, "fechaReserva":$scope.fechaReserva, "tiempo":$scope.tiempo,"usuarioId":$scope.usuarioId};
        
=======
       // var reserva = {"fechaReserva":$scope.fechaReserva, "tiempo":$scope.tiempo,"usuarioId":$scope.usuarioId};
>>>>>>> 69c3938214a5698d940f2ddf0cd9bc6ac6f84e0e
       console.info("Reserva Agregado123");
       
       reservaService.save(reserva,function(){
                   console.log("Entro");
                $location.path("/Visualizar");
        });    
        
    
    };  
        
     
}]);  
    
    
    
      
    
    
   
