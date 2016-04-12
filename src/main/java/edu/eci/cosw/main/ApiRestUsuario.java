package edu.eci.cosw.main;


import edu.eci.cosw.clases.Usuario;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 2087151
 */


@RestController
@RequestMapping("/usuarios")

public class ApiRestUsuario{
    
   @Autowired
   DamServices operacion;
    
    @RequestMapping(method= RequestMethod.GET)
         public List<Usuario> getUsuarios(){
           return operacion.getUser(); 
    }
        
    @RequestMapping(path = "/{idcliente}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Usuario> getEstablecimientoByNit(@PathVariable String idcliente) {
        try {
            Usuario u=operacion.findUserById(idcliente);
            if (u!=null){
                return ResponseEntity.ok().body(u);        
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ApiRestEstablecimiento.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
        }                 
    }
    
    @RequestMapping(method= RequestMethod.POST)
         public ResponseEntity<?> addUser( @RequestBody Usuario u){
             operacion.addUser(u); 
         return new ResponseEntity<Usuario>(HttpStatus.ACCEPTED);
    }
}
