'use strict';

angular.module('myApp.InfoEstablecimiento', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/InfoEstablecimiento', {
    templateUrl: 'InfoEstablecimiento/InfoEstablecimiento.html',
    controller: 'ControladorInfoEstablecimiento'
  });
}])

.controller('ControladorInfoEstablecimiento',  ['$scope','Establecimiento','estService','postService',function ($scope,Establecimiento,estService, postService) {
      
}]);


