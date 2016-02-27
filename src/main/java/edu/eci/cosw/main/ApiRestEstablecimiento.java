package edu.eci.cosw.main;


import edu.eci.cosw.clases.Establecimiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.cosw.interfaces.OperacionEstablecimiento;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author 2087151
 */


@RestController
@RequestMapping("/establecimientos")

public class ApiRestEstablecimiento{
    
    @Autowired
    private OperacionEstablecimiento operacionEstablecimiento;
    
    
    @RequestMapping(method= RequestMethod.GET)
         public List<Establecimiento> getEstablecimientos(){
            return operacionEstablecimiento.getEstablecimientos(); 
    }
         
    @RequestMapping(method= RequestMethod.GET, value="/{nitEstablecimiento}")
    public Establecimiento getEstablecimientoByNit(@PathVariable String nitEstablecimiento){
        System.err.println("Api:"+nitEstablecimiento);
        return operacionEstablecimiento.getEstablecimientoByNit(nitEstablecimiento);
    }
    
    @RequestMapping(method= RequestMethod.POST)
         public ResponseEntity<?> addEstablecimiento(@RequestBody Establecimiento e){
             operacionEstablecimiento.addEstablecimiento(e); 
         return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
