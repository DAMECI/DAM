/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.clases.Usuario;
import edu.eci.cosw.interfaces.OperacionCalificacion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087151
 */
@Service
public class StubCalificacion implements OperacionCalificacion{
    private List<Calificacion> calificaciones= new ArrayList<Calificacion>() ;    
    {
        
    }
    

    @Override
    public void addCalificacion(Calificacion c) {
        calificaciones.add(c);  
    }
    

    @Override
    public List<Calificacion> getCalificaciones() {
        return calificaciones;   
    }

    @Override
    public Calificacion getCalificacionByIdCalificacion(int IdCalificacion) {
        Calificacion  aux = new Calificacion();
        for(int i=0; i<calificaciones.size(); i++){
            if(calificaciones.get(i).getIdcalificacion() == IdCalificacion){
                aux = calificaciones.get(i);
            }
        }
        return aux;
    }
}
