'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope', 'usersService', function ($scope, usersService) {  
    $scope.nombre ="";
    $scope.apellido ="";
    $scope.telefono =0; 
    $scope.email ="";
    $scope.pass ="";
                
    $scope.agregarUsuario = function(){
        console.log("Agregando----");
        var user = {"nombre":$scope.Nombre, "apellido":$scope.Apellido, 
            "telefono":$scope.Telefono, "email":$scope.Email, "pass":$scope.Password};
        usersService.save(user,function(){
            console.info("usuario Agregado");
        });
        
       
    };
}]);
