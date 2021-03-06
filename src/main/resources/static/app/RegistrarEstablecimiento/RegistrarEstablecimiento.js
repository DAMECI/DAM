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
    $scope.agregarEstablecimiento = function(){
    var valida = true;     
               
            console.log("validando");            
            console.log("el nit es "+$scope.nit);     
            
            if( (($scope.nit.charAt(1))%2 !== 0) || (($scope.nit.charAt(2))%2 !== 0) 
                    || (($scope.nit.charAt(3))%2 !== 0) || (($scope.nit.charAt(8))%2 !== 0)
                    || (($scope.nit.charAt(10))%2 !== 0)){
                valida = false;
            }if($scope.nit.length !== 11){
                valida=false;
            }if($scope.nit.length === 11){
                    console.log($scope.nit.charAt(9));
                    for (var i = 0; i <9;i++){
                        if(isNaN($scope.nit.charAt(i))){
                           valida = false; 
                        }
                    }
            }
            valida = valida && ($scope.nit.charAt(9) === "-") && !isNaN($scope.nit.charAt(10)); 
            if(valida){
                console.log("agregando....");
                var est = {"nit":$scope.nit,"razonsocial":$scope.Nombre, "telefono":$scope.Telefono, 
                    "email":$scope.Email, "direccion":$scope.Direccion}; 
                    estService.save(est,function(){
                     alert("Establecimiento registrado"); 
                 });
            }else{
               alert("NIT no valido");
            }    
    };
             
     
}]);
