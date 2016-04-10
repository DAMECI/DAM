package edu.eci.cosw.main;


import edu.eci.cosw.clases.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.cosw.interfaces.OperacionUsuario;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author 2087151
 */


@RestController
@RequestMapping("/usuarios")

public class ApiRestUsuario{
    
    @Autowired
    private DamServices operacion;
    
//    @RequestMapping(method= RequestMethod.GET)
//         public List<Usuario> getUsuarios(){
//            return operacion.getUsuarios(); 
//    }
//        
//    @RequestMapping(method= RequestMethod.GET, value="/{id}")
//    public Usuario getUsuarioByEmail(@PathVariable String id){
//        return operacion.getUsuarioById(id);
//    }
    
    @RequestMapping(method= RequestMethod.POST)
         public ResponseEntity<?> addTarea(@RequestBody Usuario u){
             operacion.addUser(u); 
         return new ResponseEntity<Usuario>(HttpStatus.ACCEPTED);
    }
}
