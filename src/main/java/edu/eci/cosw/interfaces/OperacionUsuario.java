package edu.eci.cosw.interfaces;

import edu.eci.cosw.clases.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DiegoBecerra
 */
public interface OperacionUsuario {
    public List<Usuario> getUsuarios();
    public void addUsuario(Usuario u);
}