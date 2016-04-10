'use strict';

angular.module('myApp.Reservar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Reservar', {
    templateUrl: 'Reservar/Reservar.html',
    controller: 'ReservarCtrl'
  });
}])

.controller('ReservarCtrl', ['$scope', 'canchaService','$location', function ($scope, canchaService,$location) {  
    $scope.idCliente ="";  
    $scope.nombre ="";
    $scope.apellido ="";
    $scope.telefono =""; 
    $scope.email ="";
    $scope.password ="";
    
    $scope.agregarUsuario = function(){
        var user = {"idCliente":$scope.idCliente,"nombre":$scope.Nombre, "apellido":$scope.Apellido, 
            "telefono":$scope.Telefono, "email":$scope.Email, "password":$scope.Password};
        canchaService.save(user,function(){
                var visualizar = document.getElementById('Visualizar');
                var logOut = document.getElementById('Logout');
                var logIn = document.getElementById('Login');
                var registrar = document.getElementById('Registrar');
                console.info("usuario Agregado");
                visualizar.style.visibility = 'visible';
                logOut.style.visibility = 'visible';
                logIn.style.visibility = 'hidden';
                registrar.style.visibility = 'hidden';
                $location.path("/Visualizar");
        });
    };
}]);
