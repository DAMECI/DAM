/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.imp.DamServices;
import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.interfaces.OperacionReserva;
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
@RequestMapping("/reservas")
public class ApiRestReserva {
    @Autowired
    private DamServices operacion;
    
    
//    @RequestMapping(method= RequestMethod.GET)
//    public List<Reserva> getCanchas(){
//            return operacionReserva.getReservas(); 
//    }
//    
//    @RequestMapping(method= RequestMethod.GET, value="/{idReserva}/{nitEstablecimiento}")
//    public Reserva getCanchaById(@PathVariable int idReserva, String nitEstablecimiento){
//        return operacionReserva.getReservaByIdreserva(idReserva, nitEstablecimiento);
//    }
//    
//    @RequestMapping(method= RequestMethod.POST)
//         public ResponseEntity<?> addReserva(@RequestBody Reserva r){
//             operacionReserva.addReserva(r); 
//         return new ResponseEntity<Reserva>(HttpStatus.ACCEPTED);
//    }
}
