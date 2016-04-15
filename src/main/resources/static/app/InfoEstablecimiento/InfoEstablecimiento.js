'use strict';

angular.module('myApp.InfoEstablecimiento', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/InfoEstablecimiento', {
    templateUrl: 'InfoEstablecimiento/InfoEstablecimiento.html',
    controller: 'ControladorInfoEstablecimiento'
  });
}])

.controller('ControladorInfoEstablecimiento',  ['$scope','Establecimiento','getEstablecimientobyNit','postService',function ($scope,Establecimiento,getEstablecimientobyNit, postService) {        
      $scope.lista = [];
      console.log("Entro a buscar establecimiento")      
      function buscarEstablecimiento() {
            var nitXUrl = "";
            nitXUrl = location.href.split("=")[1];
            
            console.log("Entro a buscar establecimiento")
            $scope.estab = getEstablecimientobyNit.get({nit : nitXUrl}, function(data){                
                $scope.lista=data;
                $scope.nombreEstablecimiento = $scope.lista.razonsocial;
                $scope.calificacionPrm = $scope.lista.calificacionpromedio;
            });
      }
      window.onload =buscarEstablecimiento();
      
      
      $scope.hrefs = function (pagina) {
            location.href="#" + pagina;
      };
        
      
      
}]);