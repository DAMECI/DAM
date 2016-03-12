'use strict';
angular.module('services.modulo', ['ngRoute', 'ngResource'])
   
    .factory('usersService', function ($resource) {
        return $resource('/usuarios',{},{
        GET : { method: 'GET', isArray: true}
        });
    })

    .factory('estService', function ($resource) {
        return $resource('/establecimientos',{},{
        GET : { method: 'GET', isArray: true}
        });
    })
    
    .factory('postService', function ($resource) {
        
        return $resource('/establecimientos/AddCalificacion',{},{
        //POST : { method: 'POST'}
        GET : { method: 'GET', isArray: true}
        });
    })
    
    .factory('canchaService', function ($resource) {
        return $resource('/establecimientos/canchas',{},{
        GET : { method: 'GET', isArray: true}
    });
    
});