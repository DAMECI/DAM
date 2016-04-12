/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.imp.DamServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/canchas")
public class ApiRestCancha {
   @Autowired
   DamServices operacion;
   
        @RequestMapping(method= RequestMethod.POST)
        public ResponseEntity<?> addCancha( @RequestBody Cancha c){
            operacion.addCancha(c); 
            return new ResponseEntity<Cancha>(HttpStatus.ACCEPTED);
        }
         
        @RequestMapping(method= RequestMethod.GET)
        @ResponseBody
        public ResponseEntity<List<Cancha>> getCanchas(){
            try {
            List<Cancha> canchas=operacion.getCanchas();
            if (canchas!=null){
                return ResponseEntity.ok().body(canchas);        
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            } catch (Exception e) {
                Logger.getLogger(ApiRestCancha.class.getName()).log(Level.SEVERE, null, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
            }           
        }          
        
    @RequestMapping(path = "/{idcancha}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Cancha> getCanchaById(@PathVariable int idcancha) {
        try {
            Cancha e=operacion.getCanchaByid(idcancha);
            if (e!=null){
                return ResponseEntity.ok().body(e);        
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ApiRestCancha.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
        }                 
    }    
         
//         
//    @RequestMapping(method= RequestMethod.GET, value="/{idCancha}/{nitEstablecimiento}")
//    public Cancha getCanchaById(@PathVariable int idCancha, String nitEstablecimiento){
//        //return operacionCanchas.getCanchaByIdCancha(idCancha);        
//        return operacionCanchas.getCanchaByIdCancha(idCancha, nitEstablecimiento);
//    }
    
//    @RequestMapping(method= RequestMethod.GET, value="/{idCancha}/{precio}")
//    public List<Cancha> getCanchaPrecio(@PathVariable Double precio){
//        System.out.println("PrecioEstaCancha"+precio);
//        return operacionCanchas.getCanchaPrecio(precio);
//    }
//         
//    @RequestMapping(method= RequestMethod.POST)
//         public ResponseEntity<?> addCancha(@RequestBody Cancha c){
//             operacionCanchas.addCancha(c); 
//         return new ResponseEntity<Cancha>(HttpStatus.ACCEPTED);
//    }*/
}
