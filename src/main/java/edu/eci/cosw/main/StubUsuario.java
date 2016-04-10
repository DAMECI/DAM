/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.eci.cosw.interfaces.OperacionUsuario;

/**
 *
 * @author 2087151
 */
@Service
public class StubUsuario implements OperacionUsuario{
    private List<Usuario> usuarios= new ArrayList<Usuario>();
    {
       //usuarios.add(new Usuario("1", "Paola", "Castro", "11111", "paola@gmail.com", "12345"));
       //usuarios.add(new Usuario("2","Alejandro", "Giron", "11111", "alejo@gmail.com", "12345"));
       //usuarios.add(new Usuario("3","Daniela", "Escobar", "11111", "daniela@gmail.com", "12345")); 
       //usuarios.add(new Usuario("4","Diego", "Becerra", "11111", "diego@gmail.com", "12345")); 
    }
    
    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;        
    }

    @Override
    public void addUsuario(Usuario u) {
        usuarios.add(u);  
    }
    
    @Override
    public Usuario getUsuarioById(String id){
        Usuario aux = new Usuario();
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getIdCliente().equals(id)){
                aux = usuarios.get(i);
            }
        }
        return aux;
    }
}
