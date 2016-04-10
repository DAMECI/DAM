package edu.eci.cosw.main;


import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.Establecimiento;
import edu.eci.cosw.clases.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.cosw.interfaces.OperacionEstablecimiento;
import java.util.Set;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author 2087151
 */


@RestController
@RequestMapping("/establecimientos")
public class ApiRestEstablecimiento{
    
    @Autowired
    private DamServices operacion;
    
    //private DamServicesImp operacion;
    
    @RequestMapping(method= RequestMethod.GET)
         public List<Establecimiento> getEstablecimientos(){
             System.out.println("Entro Get Establecimiento");
            //return operacion.getEstablecimientos(); 
           return null;
    }         
//         
//    @RequestMapping(method= RequestMethod.GET, value="/{nitEstablecimiento}")
//    public Establecimiento getEstablecimientoByNit(@PathVariable String nitEstablecimiento){
//        return operacionEstablecimiento.getEstablecimientoByNit(nitEstablecimiento);
//    }
//    
//    @RequestMapping(method= RequestMethod.GET, value="/{nitEstablecimiento}/{idCancha}")
//    public List<Cancha> getCanchaEstablecimiento(@PathVariable int idCancha, String nitEstablecimiento){
//        //return operacionEstablecimiento.getCanchasEstablecimiento(idCancha);
//        return operacionEstablecimiento.getCanchasEstablecimiento(idCancha, nitEstablecimiento);
//        
//    }
//    
//    @RequestMapping(method= RequestMethod.POST)
//         public ResponseEntity<?> addEstablecimiento(@RequestBody Establecimiento e){
//             operacionEstablecimiento.addEstablecimiento(e); 
//         return new ResponseEntity<Establecimiento>(HttpStatus.ACCEPTED);
//    }
//         
//         
//    @RequestMapping(method= RequestMethod.POST, value = "/AddCalificacion")
//         public ResponseEntity<?> addCalificacionAEstablecimiento(@RequestBody Calificacion c){
//             System.out.println("Entro Add Calificacion");
//             operacionEstablecimiento.addCalificacion(c);
//         return new ResponseEntity<Establecimiento>(HttpStatus.ACCEPTED);
//    }
         
}
