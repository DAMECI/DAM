/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.CanchasId;
import edu.eci.cosw.clases.Establecimiento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.eci.cosw.interfaces.OperacionEstablecimiento;

/**
 *
 * @author 2087151
 */
@Service
public class StubEstablecimiento implements OperacionEstablecimiento{
    private List<Establecimiento>  establecimientos = new ArrayList<Establecimiento>();
    {
     
       
        
        
    }    

    @Override
    public List<Establecimiento> getEstablecimientos() {
         return establecimientos;
    }
  
    @Override
    public Establecimiento getEstablecimientoByNit(String nit) {
        Establecimiento aux = new Establecimiento();
        for(int i=0; i<establecimientos.size(); i++){
            if(establecimientos.get(i).getNit().equals(nit)){
                aux = establecimientos.get(i);
            }
        }
        return aux;
    }
        
    @Override
    public List<Cancha> getCanchasEstablecimiento(int idCancha, String nitEstablecimiento){
        List<Cancha>  canchas = new ArrayList<Cancha>();
        for(int i=0; i<establecimientos.size(); i++){
            
            for (Cancha c : establecimientos.get(i).getCanchases()){
                if(c.getId() ==  new CanchasId(idCancha, nitEstablecimiento)) {
                    canchas.add(c);
                }
            }
            
        }
        return canchas;
    }
    
    @Override
    public void addEstablecimiento(Establecimiento e) {
       establecimientos.add(e);
    }
    
    @Override
    public void addCalificacion(Calificacion c) {
       for (int i = 0; i < establecimientos.size(); i++) {
            //if(establecimientos.get(i).getNIT().equals(c.getNitEstablecimiento())){
            //    establecimientos.get(i).setCalificaciones(c);
            //}
       }
    }
}
