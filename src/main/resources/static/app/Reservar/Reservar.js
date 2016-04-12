'use strict';

angular.module('myApp.Reservar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Reservar', {
    templateUrl: 'Reservar/Reservar.html',
    controller: 'ReservarCtrl'
  });
}])

.controller('ReservarCtrl', ['$scope', 'canchaService','$location', function ($scope, canchaService,$location) {  
   $scope.canchas= canchaService.query();
   
   /*$scope.fechaReserva ="";  
    $scope.precio ="";
    $scope.tiempo ="";
    $scope.usuarioId =""; 
    $scope.estado ="";
    $scope.idCancha ="";
    
  console.info("Reserva Agregado12355");
    
    $scope.agregarReserva = function(){
          console.info("Reserva Agregado123");
        var reserva = {"fechaReserva":$scope.fechaReserva,"precio":$scope.precio, "tiempo":$scope.tiempo, 
            "usuarioId":$scope.usuarioId, "estado":$scope.estado, "idCancha":$scope.idCancha};
        
        
       /* canchaService.save(reserva,function(){
                var visualizar = document.getElementById('Visualizar');
                var logOut = document.getElementById('Logout');
                var logIn = document.getElementById('Login');
                var registrar = document.getElementById('Registrar');
                console.info("Reserva Agregado");
                visualizar.style.visibility = 'visible';
                logOut.style.visibility = 'visible';
                logIn.style.visibility = 'hidden';
                registrar.style.visibility = 'hidden';
                $location.path("/Visualizar");
        });
    };  
        
     */
}]);  
