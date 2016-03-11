'use strict';

angular.module('myApp.Calificar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/Calificar', {
    templateUrl: 'Calificar/Calificar.html',
    controller: 'ControladorCalificar'
  });
}])

.controller('ControladorCalificar',  ['$scope','Establecimiento','estService','postService',function ($scope,Establecimiento,estService, postService) {
        console.log('Entro Calificar');
        var visualizar = document.getElementById('Visualizar');
        var logOut = document.getElementById('Logout');
        var logIn = document.getElementById('Login');
        var registrar = document.getElementById('Registrar');
        $scope.calificacion = "";
        visualizar.style.visibility = 'hidden';
        logOut.style.visibility = 'hidden';
        logIn.style.visibility = 'visible';

        registrar.style.visibility = 'visible';        
        var aux = {nombreEstablecimiento:"", telefono:"", direccion:"", numCancha:0, precio:0};
        $scope.establecimiento = "";
        $scope.Observacion= "";
        $scope.establecimientos = [];
        

        registrar.style.visibility = 'visible';
        console.log(document.getElementById("establecimiento").valueOf());

        $scope.buscarEstablecimiento = function () {
            console.log("Buscando Establecimiento");
            var lista = [];
           $scope.listado = estService.query(function(data){
                        lista=data;
                        for (var index = 0; index < lista.length; index++) {  
                            //if(lista[index].razonSocial == $scope.establecimiento){
                            if($scope.establecimiento.indexOf(lista[index].razonSocial) > -1){    
                                 
                                aux={nombreEstablecimiento:lista[index].razonSocial, telefono:lista[index].telefono, direccion:lista[index].direccion,
                                        numCancha:lista[index].canchas[0].idCancha, precio:lista[index].canchas[0].precio,nit:lista[index].nit};
                                    $scope.establecimientos.push(aux);
                            }
                        } $scope.estable=$scope.establecimientos;
                    });   
       };
       
       $scope.Puntaje = function (valor) {
            $scope.calificacion = valor;
                    alert("Tu puntuación para el lugar: " + aux.nombreEstablecimiento + " fue: " + $scope.calificacion);
       };       
       
       $scope.Calificacion = function () {
            var calificacion = {"IdCalificacion":1,"Puntaje":$scope.calificacion, "Observacion":$scope.Observacion, 
            "NitEstablecimiento":aux.nit};            
            console.log(calificacion.toString());            
            $scope.SaveCalificacion(calificacion);
            alert("Calificacion Guardad");
            
       };
       
       
       $scope.SaveCalificacion = function(calificacion) {
           postService.save(calificacion);
    };
}]);


