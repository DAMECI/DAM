'use strict';

angular.module('myApp.InfoEstablecimiento', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/InfoEstablecimiento', {
    templateUrl: 'InfoEstablecimiento/InfoEstablecimiento.html',
    controller: 'ControladorInfoEstablecimiento'
  });
}])

.controller('ControladorInfoEstablecimiento',  ['$scope','Establecimiento','getEstablecimientobyNit','postService',function ($scope,Establecimiento,getEstablecimientobyNit, postService) {        
      console.log("Entro a buscar establecimiento")
      
      
      function buscarEstablecimiento() {
            console.log("Entro a buscar establecimiento")
            $scope.lista = getEstablecimientobyNit.query({nit : 8956});
            $scope.lista2 = ""; 
      }    
      window.onload =buscarEstablecimiento();
       
}]);