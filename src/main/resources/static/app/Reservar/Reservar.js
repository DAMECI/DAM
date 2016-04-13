'use strict';

angular.module('myApp.Reservar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Reservar', {
    templateUrl: 'Reservar/Reservar.html',
    controller: 'ReservarCtrl'
  });
}])

.controller('ReservarCtrl', ['$scope', '$rootScope', 'canchaService','reservaService','estService','$location', function ($scope, $rootScope, canchaService, reservaService, estService,$location) {  
    $scope.canchas= canchaService.query();
    
 
    $scope.id ="";  
    $scope.fechareserva ="";  
    $scope.precio ="";  
    $scope.tiempo ="";
    $scope.ReservaId ="";
    //{"idReserva":$scope.id.idreserva ="","nitEstablecimiento":$scope.id.nitEstablecimiento =""};
    $scope.usuarioId ="";
    
    Sscope.
    
    var lista = [];
    $scope.listado = estService.query(function(data){
            lista=data;
              for (var index = 0; index < lista.length; index++) { 
            }
       });
    
  $scope.agregarReserva = function(){
        
        var newReserva = {"id":{"idreserva":$scope.idreserva, "nitEstablecimiento":$rootScope.nitEstablecimiento}, "fechareserva":$scope.fechareserva, "precio":$scope.precio, "tiempo":$scope.tiempo, "usuarioId":$scope.usuarioId};
          
       console.info("Reserva Agregado123");
       
       reservaService.save({nitEstablecimiento:$rootScope.nitEstablecimiento}, newReserva,function(){
                   console.log("Entro");
                $location.path("/Visualizar");
        });    
        
    
    };  
        
     
}]);  
    
    
    
      
    
    
   
