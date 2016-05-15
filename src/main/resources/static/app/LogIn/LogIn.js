'use strict';

angular.module('myApp.vistaLogIn', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/LogIn', {
    templateUrl: 'LogIn/LogIn.html',
    controller: 'ControladorLogin'
  });
}])

	.controller('ControladorLogin',  ['$rootScope', '$scope', '$http', '$location','getUsuarioxID', function($rootScope, $scope, $http, $location, getUsuarioxID) {                                         
                simple();      
                function simple() {
                    document.getElementById("Menu").innerHTML = "";
                    document.getElementById("Menu").innerHTML = "<ul id='Menu'><li><a  href='#/Index2'  class='button special' >Home</a></li></ul>";
                }
                      
                var authenticate = function (credentials, callback) {
                    
                var headers = credentials ? {authorization: "Basic "
                            + btoa(credentials.username + ":" + credentials.password)
                } : {};

                $http.get('user', {headers: headers}).success(function (data) {
                    if (data.name) {
                        //AUTENTICADO CORRECTAMENTE
                        $rootScope.authenticated = true;         
                        //TRAER INFO DE USUARIO
                            buscarUsuario(data.name);                        
                    } else {
                        $rootScope.authenticated = false;
                    }
                    callback && callback();
                }).error(function () {
                    $rootScope.authenticated = false;
                    callback && callback();
                });

            };

            $scope.credentials = {};
            $scope.login = function () {
                
                console.log("Autenticando...");
                
                
                authenticate($scope.credentials, function () {                        
                    if ($rootScope.authenticated) {
                        $scope.error = false;
                         $location.path("/Visualizar");
                         
                    } else {
                        $location.path("/LogIn");
                        $scope.error = true;
                     
                    }
                });
            };
            
            
            
       function buscarUsuario(idUsuario) {           
            $scope.estab = getUsuarioxID.get({idcliente : idUsuario}, function(data){                
                $scope.user=data;
                localStorage.userActivo = JSON.stringify($scope.user);                
            });
       }
}]);