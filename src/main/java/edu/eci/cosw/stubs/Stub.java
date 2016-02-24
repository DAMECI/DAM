/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.stubs;

import edu.eci.cosw.clases.Usuario;
import ch.qos.logback.classic.util.ContextInitializer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import edu.eci.cosw.interfaces.OperacionUsuario;

/**
 *
 * @author 2087151
 */
@Service
public class Stub implements OperacionUsuario{
    private List<Usuario> usuarios= new ArrayList<Usuario>() ;    

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;        
    }

    @Override
    public void addUsuario(Usuario u) {
        usuarios.add(u);  
    }
}
