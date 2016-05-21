'use strict';

angular.module('myApp.listReservas', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/listReservas', {
    templateUrl: 'listReservas/listReservas.html',
    controller: 'listReservasCtrl'
  });
}])

.controller('listReservasCtrl', ['$scope', '$rootScope', 'getReservaByIdUser', function ($scope, $rootScope, getReservaByIdUser) {  
     function CargarInicio(){     
         $scope.userActivo = JSON.parse(localStorage.userActivo);
         
           $scope.estab = getReservaByIdUser.query({idUser : $scope.userActivo.idCliente}, function(data){  
               $scope.listaReservas=data;
             });
        
        
     };
     
     window.onload =CargarInicio();
     
     $scope.calificar = function (idEstable) {
            location.href="#Calificar?IDEstablecimiento=" + idEstable;
      };      
     
     
}]);