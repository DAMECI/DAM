'use strict';

angular.module('myApp.vistaLogIn', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/LogIn', {
    templateUrl: 'LogIn/LogIn.html',
    controller: 'ControladorLogin'
  });
}])

	.controller('ControladorLogin',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {                                         
		var visualizar = document.getElementById('Visualizar');
                var logOut = document.getElementById('Logout');
                var logIn = document.getElementById('Login');
                var registrar = document.getElementById('Registrar');
                var authenticate = function (credentials, callback) {

                var headers = credentials ? {authorization: "Basic "
                            + btoa(credentials.username + ":" + credentials.password)
                } : {};

                $http.get('user', {headers: headers}).success(function (data) {
                    if (data.name) {
                        $rootScope.authenticated = true;         
                    } else {
                        $rootScope.authenticated = false;
                    }
                    callback && callback();
                }).error(function () {
                    $rootScope.authenticated = false;
                    callback && callback();
                });

            };

            authenticate();
            $scope.credentials = {};
            $scope.login = function () {
                
                console.log("Autenticando...");
                
                
                authenticate($scope.credentials, function () {                        
                    if ($rootScope.authenticated) {
                        $location.path("/");
                        $scope.error = false;
                         visualizar.style.visibility = 'visible';
                         logOut.style.visibility = 'visible';
                         logIn.style.visibility = 'hidden';
                         registrar.style.visibility = 'hidden';
                    } else {
                        $location.path("/login");
                        $scope.error = true;
                        visualizar.style.visibility = 'hidden';
                        logOut.style.visibility = 'hidden';
                        logIn.style.visibility = 'visible';
                        registrar.style.visibility = 'visible';
                    }
                });
            };
}]);