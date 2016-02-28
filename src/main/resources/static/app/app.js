'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.vistaRegistrar',
  'myApp.vistaFiltrar',
  'myApp.vistaLogIn',
  'myApp.Visualizar',
  'myApp.Calificar',
  'services.modulo',
  'myApp.version'
]).
config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
  $routeProvider.otherwise({redirectTo: '/login'});
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('ControladorLogOut',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
        console.log("Salio");
                $scope.logout = function () {
            console.log("Salio");
        $http.post('/logout', {}).success(function () {
        $rootScope.authenticated = false;
        $location.path("/");
        }).error(function (data) {
            console.log("Salio");
             console.log("noSalio");
            $rootScope.authenticated = false;
        });
        console.log("Salio");
    };
}]);
