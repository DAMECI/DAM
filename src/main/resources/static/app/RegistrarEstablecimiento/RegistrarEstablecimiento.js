'use strict';

angular.module('myApp.RegistrarEstablecimiento', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/RegistrarEstablecimiento', {
    templateUrl: 'RegistrarEstablecimiento/RegistrarEstablecimiento.html',
    controller: 'RegistrarEstCtrl'
  });
}])

.controller('RegistrarEstCtrl', ['$scope', 'estService', '$location', function ($scope, estService,$location) {  
    $scope.nit = "";
    $scope.razonsocial ="";
    $scope.telefono =""; 
    $scope.direccion =""; 
    $scope.email ="";
    $scope.validarnit = "";
    $scope.agregarEstablecimiento = function(){
         var est = {"nit":$scope.Nit,"razonsocial":$scope.Nombre, "telefono":$scope.Telefono, 
             "email":$scope.Email, "direccion":$scope.Direccion};
              estService.save(est,function(){
                 alert("Establecimiento registrado"); 
        });
    };    
    

}]);
