'use strict';

angular.module('myApp.vistaFiltrar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Filtrar', {
    templateUrl: 'Filtrar/Filtrar.html',
    controller: 'FiltrarCtrl'
  });
}])

.controller('FiltrarCtrl',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
                               
		
}]);