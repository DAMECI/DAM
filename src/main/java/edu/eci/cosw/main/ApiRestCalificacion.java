/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.interfaces.OperacionCalificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2087151
 */

@RestController
@RequestMapping("/calificaciones")
public class ApiRestCalificacion {
    @Autowired
    private OperacionCalificacion operacionCalificacion;
    
    
    @RequestMapping(method= RequestMethod.GET)
         public List<Calificacion> getCalificaciones(){
            return operacionCalificacion.getCalificaciones(); 
    }
     
    @RequestMapping(method= RequestMethod.GET, value="/{idCalifica}")
    public Calificacion getCanchaById(@PathVariable int idCalifica){
        return operacionCalificacion.getCalificacionByIdCalificacion(idCalifica);
    }
    
    @RequestMapping(method= RequestMethod.POST)
         public ResponseEntity<?> addCalificacion(@RequestBody Calificacion c){
             operacionCalificacion.addCalificacion(c); 
         return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
