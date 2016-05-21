'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.vistaRegistrar',
  'myApp.vistaFiltrar',
  'myApp.vistaLogIn',
  'myApp.Visualizar',
  'myApp.Calificar',
  'myApp.RegistrarEstablecimiento',
  'myApp.Reservar',
  'myApp.listReservas',
  'myApp.InfoEstablecimiento',
  'services.modulo',
  'services.Establecimientos',  
  'myApp.version'
]).
config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
        $routeProvider
            .when("/Index2", {
                controller: "ControladorLogOut",
                templateUrl: "Index2.html"
            })
             .when("/Login", {
                templateUrl: 'LogIn/LogIn.html',
                controller: 'ControladorLogin'
            });
  $routeProvider.otherwise({redirectTo: '/Index2'});
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('ControladorLogOut',  ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {
    
        $scope.logout = function () {
         
        $http.post('/logout', {}).success(function () {
            $rootScope.authenticated = false;
            $location.path("/LogIn");
          
        }).error(function (data) {
             $location.path("/LogIn");
            $rootScope.authenticated = false;
           
        });
    };
    
    
    $scope.Desplegar = function () {
         var oDiv = document.getElementById("divButtons");
         if(localStorage.userActivo != null){
            if(oDiv.style.visibility=="visible"){
                oDiv.style.visibility='hidden';            
            }else if(oDiv.style.visibility=="hidden"){
                oDiv.style.visibility='visible'; 
            }
         }         
     };
    
    $scope.BotonMisReservas = function () {
         location.href="#listReservas";
     };
   
    $scope.BotonHome = function () {
         location.href="#Visualizar";
     };
     
}]);
