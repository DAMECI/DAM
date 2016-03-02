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
  'services.Establecimientos',
  'myApp.version'
]).
config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
  $routeProvider.otherwise({redirectTo: '/LogIn'});
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('ControladorLogOut',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
        $scope.logout = function () {
            var visualizar = document.getElementById('Visualizar');
            var logOut = document.getElementById('Logout');
            var logIn = document.getElementById('Login');
            var registrar = document.getElementById('Registrar');
        $http.post('/logout', {}).success(function () {
            $rootScope.authenticated = false;
            $location.path("/LogIn");
            visualizar.style.visibility = 'hidden';
            logOut.style.visibility = 'hidden';
            logIn.style.visibility = 'visible';
            registrar.style.visibility = 'visible';
        }).error(function (data) {
             $location.path("/LogIn");
            $rootScope.authenticated = false;
            visualizar.style.visibility = 'hidden';
            logOut.style.visibility = 'hidden';
            logIn.style.visibility = 'visible';
            registrar.style.visibility = 'visible';
        });
    };
}]);
