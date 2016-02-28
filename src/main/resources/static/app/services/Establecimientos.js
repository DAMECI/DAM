/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('services.Establecimientos', ['ngRoute','ngResource'])
.factory('Establecimiento', function($resource){
        return $resource('/establecimientos',{},{
            get: {
                method: 'GET',
                isArray: true               
            }
        });

    });