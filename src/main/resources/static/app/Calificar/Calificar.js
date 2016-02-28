'use strict';

angular.module('myApp.Calificar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/Calificar', {
    templateUrl: 'Calificar/Calificar.html',
    controller: 'ControladorCalificar'
  });
}])

.controller('ControladorVisualizacion',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
       
       
       $scope.buscarEstablecimiento = function () {
           $scope.establecimiento;
       $scope.Observacion;       
       var Calificacion = {"IdCalificacion":1,"Puntaje":0, "Observacion":$scope.Observacion};
       var Establecimiento = {"NIT":"","RazonSocial":"", "Direccion":"", "Telefono":""};
       
       };
		
}]);