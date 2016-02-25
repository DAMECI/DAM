/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.services;

import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.interfaces.OperacionCancha;
import edu.eci.cosw.interfaces.OperacionesEstablecimiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2087151
 */

@RestController
@RequestMapping("/canchas")
public class ApiRestCancha {
    @Autowired
    private OperacionCancha operacionCanchas;
    
    
    @RequestMapping(method= RequestMethod.GET)
         public List<Cancha> getCanchas(){
            return operacionCanchas.getCanchas(); 
    }
         
    @RequestMapping(method= RequestMethod.POST)
         public ResponseEntity<?> addCancha(@RequestBody Cancha c){
             operacionCanchas.addCancha(c); 
         return new ResponseEntity<Cancha>(HttpStatus.ACCEPTED);
    }
}
