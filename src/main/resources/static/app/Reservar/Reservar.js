'use strict';

angular.module('myApp.Reservar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Reservar', {
    templateUrl: 'Reservar/Reservar.html',
    controller: 'ReservarCtrl'
  });
}])

.controller('ReservarCtrl', ['$scope', '$rootScope', 'canchaService','reservaService','estService','$location', function ($scope, $rootScope, canchaService, reservaService, estService,$location) {  
     $scope.cargaInfo = false;
     
         function CargarInicio(){            
           var iIdCancha;
           var cancha;
           
           iIdCancha = location.href.split("=")[1];
           ///Trae Objeto guardado en session 'establecimiento'
           $scope.establecimiento = JSON.parse(localStorage.establecimiento);
           $scope.userActivo = JSON.parse(localStorage.userActivo);
           //Buscar las cancha por el ID, que viene en la URL
           for (var index = 0; index < $scope.establecimiento.canchases.length; index++) {  
               if($scope.establecimiento.canchases[index].id.idcancha == iIdCancha){
                   $scope.canchaSession = $scope.establecimiento.canchases[index];
               }
           }
           
     };
        
        ///Verifica Disponibilidad de la cancha, tentiendo en cuenta: Fecha, Hora y Tiempo
     $scope.VerificarDisponibilidad = function () {
         $scope.cargaInfo = true;
         $scope.horario = null;
        var inputFecha = document.getElementById("FechaR").value;
        var inputHora =document.getElementById("horaReserva").value;
        var inputTiempo =document.getElementById("iTiempo").value;
        var fechaReserva = new Date(inputFecha);
        var dia = fechaReserva.getDay();
        inputTiempo = (inputTiempo * 100) + parseInt(inputHora);
        
        $scope.reserva = false;
        $scope.disponibilidad = "No esta Dispobible ahora";
        
        for (var index = 0; index < $scope.canchaSession.horarioses.length; index++) {  
            if($scope.canchaSession.horarioses[index].id.dia == dia && $scope.canchaSession.horarioses[index].id.horaInicial <= inputHora 
            && $scope.canchaSession.horarioses[index].id.horaFin >= inputTiempo ){
                $scope.disponibilidad = "Disponible";
                $scope.reserva = true;
                $scope.horario = $scope.canchaSession.horarioses[index];
            }
        }
        
     };
     
     $scope.BotonAtras = function () {
         location.href="#InfoEstablecimiento?nit=" + $scope.establecimiento.nit;
     };
     
     
     
     //Al carga la Página llama a funcion CargarInicio
     window.onload =CargarInicio();
     
     
     $scope.AddReserva = function () {
         var inputFecha = document.getElementById("FechaR").value;
        var inputTiempo =document.getElementById("iTiempo").value;
         inputTiempo = inputTiempo;
         
         var reserva= {
            "fechareserva":inputFecha,
            "precio":$scope.horario.id.precio,
            "tiempo": inputTiempo,
            "usuarioId":$scope.userActivo.idCliente,
            "estado":1,
            "idCancha":$scope.canchaSession.id.idcancha,
            "id": {
              "nitEstablecimiento":$scope.establecimiento.nit
            }
          };
            
            reservaService.save(reserva,function(){
                location.href="#listReservas";
            });
            
     };
     
     
}]);  
