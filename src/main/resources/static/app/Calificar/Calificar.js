'use strict';

angular.module('myApp.Calificar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/Calificar', {
    templateUrl: 'Calificar/Calificar.html',
    controller: 'ControladorCalificar'
  });
}])

.controller('ControladorCalificar',  ['$scope','postService','getEstablecimientobyNit',function ($scope, postService,getEstablecimientobyNit) {
        console.log('Entro Calificar');
       
        $scope.calificacion = "";
       
        

        //registrar.style.visibility = 'visible';
        //console.log(document.getElementById("establecimiento").valueOf());

        function buscarEstablecimiento() {
            
            //var nitXUrl = "";
            $scope.nitXUrl = location.href.split("=")[1];
            $scope.userActivo = JSON.parse(localStorage.userActivo);
            
            
            $scope.estab = getEstablecimientobyNit.get({nit : $scope.nitXUrl}, function(data){                                
                $scope.lista=data;
            });
            
            
       }
       
       window.onload =buscarEstablecimiento();
       
       $scope.Calificacion = function () {
           
           if(document.getElementById("star-1").checked == true){
                $scope.calificacion = 1;
           }
           if(document.getElementById("star-2").checked == true){
               $scope.calificacion = 2;
           }
           if(document.getElementById("star-3").checked == true){
               $scope.calificacion = 3;
           }
           if(document.getElementById("star-4").checked == true){
               $scope.calificacion = 4;
           }
           if(document.getElementById("star-5").checked == true){
               $scope.calificacion = 5;
           }
           
            var oCalificacion = {
                "puntaje": $scope.calificacion, 
                "observacion":$scope.Observacion, 
                "nit":$scope.nitXUrl,
                "usuarioId":$scope.userActivo.idCliente};
            console.log(oCalificacion);    
            
            postService.save(oCalificacion, function(){
                alert("Calificacion Guardad");                
            });
       };
      
}]);


