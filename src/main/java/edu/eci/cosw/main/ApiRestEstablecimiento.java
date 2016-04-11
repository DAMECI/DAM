package edu.eci.cosw.main;


import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.Establecimiento;
import edu.eci.cosw.clases.Usuario;
import edu.eci.cosw.imp.DamServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 2087151
 */


@RestController
@RequestMapping(path ="/establecimientos")
public class ApiRestEstablecimiento{
    
    @Autowired
    DamServices operacion;
    
    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
         public ResponseEntity<List<Establecimiento>> getEstablecimientos(){
             try {
            List<Establecimiento> establecimientos=operacion.getEstablecimientos();
            if (establecimientos!=null){
                return ResponseEntity.ok().body(establecimientos);        
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ApiRestEstablecimiento.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
        }           
    }       
         
    @RequestMapping(path = "/{nit}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Establecimiento> getEstablecimientoByNit(@PathVariable String nit) {
        try {
            Establecimiento e=operacion.getEstablecimientoByNit(nit);
            if (e!=null){
                return ResponseEntity.ok().body(e);        
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ApiRestEstablecimiento.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
        }                 
    }
 
            
//    @RequestMapping(method= RequestMethod.POST, value = "/AddCalificacion")
//         public ResponseEntity<?> addCalificacionAEstablecimiento(@RequestBody Calificacion c){
//             System.out.println("Entro Add Calificacion");
//             operacionEstablecimiento.addCalificacion(c);
//         return new ResponseEntity<Establecimiento>(HttpStatus.ACCEPTED);
//    }
         
}
