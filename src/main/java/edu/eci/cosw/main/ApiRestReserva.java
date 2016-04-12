/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.imp.DamServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2087151
 */

@RestController
@RequestMapping("/reservas")
public class ApiRestReserva {
    @Autowired
    DamServices operacion;
    
        @RequestMapping(method= RequestMethod.POST)
        public ResponseEntity<?> addReserva(@RequestBody Reserva r){
            operacion.addReserva(r); 
            return new ResponseEntity<Reserva>(HttpStatus.ACCEPTED);
        }
    
        
       @RequestMapping(method= RequestMethod.GET)
        @ResponseBody
         public ResponseEntity<List<Reserva>> getReservas(){
             try {
            List<Reserva> reservas=operacion.getReservas();
            if (reservas!=null){
                return ResponseEntity.ok().body(reservas);        
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ApiRestReserva.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
        }        
            
       }

}
    
    
//    @RequestMapping(method= RequestMethod.GET)
//    public List<Reserva> getCanchas(){
//            return operacionReserva.getReservas(); 
//    }
//    
//    @RequestMapping(method= RequestMethod.GET, value="/{idReserva}/{nitEstablecimiento}")
//    public Reserva getCanchaById(@PathVariable int idReserva, String nitEstablecimiento){
//        return operacionReserva.getReservaByIdreserva(idReserva, nitEstablecimiento);
//    }


