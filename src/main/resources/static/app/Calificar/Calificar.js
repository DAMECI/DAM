'use strict';

angular.module('myApp.Calificar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/Calificar', {
    templateUrl: 'Calificar/Calificar.html',
    controller: 'ControladorCalificar'
  });
}])

.controller('ControladorVisualizacion',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
        var visualizar = document.getElementById('Visualizar');
        var logOut = document.getElementById('Logout');
        var logIn = document.getElementById('Login');
        var registrar = document.getElementById('Registrar');
        visualizar.style.visibility = 'hidden';
        logOut.style.visibility = 'hidden';
        logIn.style.visibility = 'visible';
        registrar.style.visibility = 'visible';
        console.log(document.getElementById("establecimiento").valueOf());
        $scope.buscarEstablecimiento = function () {
           $scope.establecimiento;
       $scope.Observacion;       
       var Calificacion = {"IdCalificacion":1,"Puntaje":0, "Observacion":$scope.Observacion};
       var Establecimiento = {"NIT":"","RazonSocial":"", "Direccion":"", "Telefono":""};
       
       };
		
}]);