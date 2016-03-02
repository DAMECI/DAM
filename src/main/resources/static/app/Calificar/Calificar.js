'use strict';

angular.module('myApp.Calificar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/Calificar', {
    templateUrl: 'Calificar/Calificar.html',
    controller: 'ControladorCalificar'
  });
}])

.controller('ControladorCalificar',  ['$scope','Establecimiento','estService',function ($scope,Establecimiento,estService) {
        console.log('Entro Calificar');
        var visualizar = document.getElementById('Visualizar');
        var logOut = document.getElementById('Logout');
        var logIn = document.getElementById('Login');
        var registrar = document.getElementById('Registrar');
        var calificacion = "";
        visualizar.style.visibility = 'hidden';
        logOut.style.visibility = 'hidden';
        logIn.style.visibility = 'visible';

        registrar.style.visibility = 'visible';        
        var aux = {nombreEstablecimiento:"", telefono:"", direccion:"", numCancha:0, precio:0};
        $scope.establecimiento = "";
        $scope.Observacion= "";
        var establecimientos = [];
        

        registrar.style.visibility = 'visible';
        console.log(document.getElementById("establecimiento").valueOf());

        $scope.buscarEstablecimiento = function () {
            console.log("Buscando Establecimiento");
            var lista = [];
           $scope.listado = estService.query(function(data){
                        lista=data;
                        for (var index = 0; index < lista.length; index++) {  
                            if(lista[index].razonSocial == $scope.establecimiento){
                                aux={nombreEstablecimiento:lista[index].razonSocial, telefono:lista[index].telefono, direccion:lista[index].direccion,
                                        numCancha:lista[index].canchas[0].idCancha, precio:lista[index].canchas[0].precio,nit:lista[index].NIT};
                                    establecimientos.push(aux);
                            }
                        } $scope.estable=establecimientos;
                    });   
       };
       
       $scope.Puntaje = function (valor) {
            calificacion = valor;
                    alert("Tu puntuación para el lugar: " + establecimientos[0].nombreEstablecimiento + " fue: " + calificacion );
       };       
       
       $scope.Calificacion = function () {
            calificacion = valor;
            var calificacion = {"IdCalificacion":1,"Puntaje":calificacion, "Observacion":$scope.Apellido, 
            "usuarioCalifica":"","NitEstablecimiento":establecimientos[0].nit};
            
       };
       
       
       $scope.SaveCalificacion = function(calificacion) {
        $http({
            method  : 'POST',
            url     : 'establecimientos/AddCalificacion',
            data    : calificacion
        });
    };
       
}]);


