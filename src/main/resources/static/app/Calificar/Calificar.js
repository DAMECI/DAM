'use strict';

angular.module('myApp.Calificar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/Calificar', {
    templateUrl: 'Calificar/Calificar.html',
    controller: 'ControladorCalificar'
  });
}])

.controller('ControladorVisualizacion',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
       $scope.establecimiento;
       $scope.buscarEstablecimiento = function () {
           
       };
		
}]);