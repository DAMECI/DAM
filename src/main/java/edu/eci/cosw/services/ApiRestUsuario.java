package edu.eci.cosw.services;


import edu.eci.cosw.clases.Usuario;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.cosw.interfaces.OperacionUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2087151
 */


@RestController
@RequestMapping("/usuarios")

public class ApiRestUsuario{
    
    @Autowired
    private OperacionUsuario operacion;
    
    
    @RequestMapping(method= RequestMethod.GET)
         public List<Usuario> getUsuarios(){
            return operacion.getUsuarios(); 
    }
         
    @RequestMapping(method= RequestMethod.POST)
         public ResponseEntity<?> addTarea(@RequestBody Usuario u){
             operacion.addUsuario(u); 
         return new ResponseEntity<Usuario>(HttpStatus.ACCEPTED);
    }
}
