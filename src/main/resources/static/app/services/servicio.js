'use strict';
angular.module('services.modulo', ['ngRoute', 'ngResource'])
   
    .factory('usersService', function ($resource) {
        return $resource('/usuarios',{},{
        GET : { method: 'GET', isArray: true}
        });
    })
    
     .factory('reservaService', function ($resource) {
          console.log("Entrobeeeeeee");
        return $resource('/reservas',{},{   
        GET : { method: 'GET', isArray: true} 
        });
          
    })

    .factory('estService', function ($resource) {
        return $resource('/establecimientos',{},{
        GET : { method: 'GET', isArray: true}
        });
    })
    
    
    .factory('getEstablecimientobyNit', function ($resource) {        
        return $resource('/establecimientos/byNit/:nit',{nit: '@nit'},{            
            GET : { method: 'GET'}
        });
        console.log("Entrobeeeeeee" + nit);
    })
    
    
    
    .factory('getReservaByIdUser', function ($resource) {        
        return $resource('/reservas/byCliente/:idUser',{idUser: 'idUser'},{            
            GET : { method: 'GET'}
        });
        console.log("Entrobeeeeeee" + idUser);
    })
    
    
    
    
    .factory('getUsuarioxID', function ($resource) {        
        return $resource('/usuarios/:idcliente',{idcliente: '@idcliente'},{            
            GET : { method: 'GET'}
        });
    })
    
    
    
    
    .factory('postService', function ($resource) {
        
        return $resource('/establecimientos/AddCalificacion',{},{
        //POST : { method: 'POST'}
        GET : { method: 'GET', isArray: true}
        });
    })
    
    .factory('canchaService', function ($resource) {
        
        console.log("Entroyaaaaaa");
        return $resource('/canchas',{},{
        get : { method: 'GET', 
            isArray: true
        }
    });
    
    });
    
  
