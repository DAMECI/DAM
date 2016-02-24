'use strict';
angular.module('services.modulo', ['ngRoute', 'ngResource'])
   
    .factory('usersService', function ($resource) {
        return $resource('/usuarios',{},{
        GET : { method: 'GET', isArray: true}
        });

    });
	
	
	