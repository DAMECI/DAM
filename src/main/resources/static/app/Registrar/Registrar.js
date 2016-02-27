'use strict';

angular.module('myApp.vistaRegistrar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Registrar', {
    templateUrl: 'Registrar/Registrar.html',
    controller: 'RegistrarCtrl'
  });
}])

.controller('RegistrarCtrl', ['$scope', 'usersService', function ($scope, usersService) {  
    $scope.idCliente ="";  
    $scope.nombre ="";
    $scope.apellido ="";
    $scope.telefono =""; 
    $scope.email ="";
    $scope.password ="";
                
    $scope.agregarUsuario = function(){
        var user = {"idCliente":$scope.idCliente,"nombre":$scope.Nombre, "apellido":$scope.Apellido, 
            "telefono":$scope.Telefono, "email":$scope.Email, "password":$scope.Password};
        usersService.save(user,function(){
            console.info("usuario Agregado");
        });
    };
}]);
