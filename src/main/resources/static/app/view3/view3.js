'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'ControladorListado'
  });
}])

  .controller('ControladorListado', ['$scope', 'usersService', function($scope, usersService){  
    $scope.listado = usersService.query();  
}]);