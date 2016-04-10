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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 2087151
 */
@Service
public class StubEstablecimiento implements OperacionEstablecimiento{
    private List<Establecimiento>  establecimientos = new ArrayList<Establecimiento>();
    {
        
        
        Set<Cancha> canchasEs1 = new HashSet(0);
//        canchasEs1.add(new Cancha((new CanchasId(11,"1542-4")),true,1562));
//        canchasEs1.add(new Cancha((new CanchasId(12,"1542-4")),false,1563));
         Set<Cancha> canchasEs2 = new HashSet(0);
//        canchasEs2.add(new Cancha((new CanchasId(21,"2541-1")),true,2562));
//        canchasEs2.add(new Cancha((new CanchasId(22,"2541-1")),false,2563));
        Set<Cancha> canchasEs3 = new HashSet(0);
//        canchasEs3.add(new Cancha((new CanchasId(31,"8954-0")),true,3562));
//        canchasEs3.add(new Cancha((new CanchasId(32,"8954-0")),false,3563));
        establecimientos.add(new Establecimiento("1542-4","Paola", "Cancha5", "calle 170 #13-1", "12333",4.2,canchasEs1));
        establecimientos.add(new Establecimiento("2541-1","Diego", "RealMadrid", "cra 1 #1-1", "12333",3.8, canchasEs2));
        establecimientos.add(new Establecimiento("8954-0","Alejo", "Emirates", "cra 20 #2-2", "12333",4.2, canchasEs3));

       
        
        
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
            
            //for (Cancha c : establecimientos.get(i).getCanchases()){
            //    if(c.getId() ==  new CanchasId(idCancha, nitEstablecimiento)) {
            //        canchas.add(c);
            //    }
            //}
            
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
