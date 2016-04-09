'use strict';

angular.module('myApp.vistaLogIn', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/LogIn', {
    templateUrl: 'LogIn/LogIn.html',
    controller: 'ControladorLogin'
  });
}])

	.controller('ControladorLogin',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {                                         
		
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
                        $scope.error = false;
                        
                         $location.path("/Visualizar");
                    } else {
                        $location.path("/login");
                        $scope.error = true;
                     
                    }
                });
            };
}]);