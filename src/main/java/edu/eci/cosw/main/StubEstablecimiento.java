/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Cancha;
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
    private List<Establecimiento>  establecimientos = new ArrayList<>();
    {
        List<Cancha> canchasEs1 = new ArrayList<>();
        canchasEs1.add(new Cancha(15421,30.000,true));
        canchasEs1.add(new Cancha(15422,30.000,true));
        List<Cancha> canchasEs2 = new ArrayList<>();
        canchasEs2.add(new Cancha(25411,50.000,true));
        canchasEs2.add(new Cancha(25412,50.000,true));
        List<Cancha> canchasEs3 = new ArrayList<>();
        canchasEs3.add(new Cancha(89541,40.000,true));
        canchasEs3.add(new Cancha(89542,30.000,true));
        establecimientos.add(new Establecimiento("1542-4", "Cancha5", "calle 170 #13-1", "12333",canchasEs1));
        establecimientos.add(new Establecimiento("2541-1", "RealMadrid", "cra 1 #1-1", "12333", canchasEs2));
        establecimientos.add(new Establecimiento("8954-0", "Emirates", "cra 20 #2-2", "12333", canchasEs3));
    }    

    @Override
    public List<Establecimiento> getEstablecimientos() {
         return establecimientos;
    }
  
    @Override
    public Establecimiento getEstablecimientoByNit(String nit) {
        Establecimiento aux = new Establecimiento();
        for(int i=0; i<establecimientos.size(); i++){
            if(establecimientos.get(i).getNIT().equals(nit)){
                aux = establecimientos.get(i);
            }
        }
        return aux;
    }
        
    @Override
    public List<Cancha> getCanchasEstablecimiento(int idCancha){
        List<Cancha>  canchas = new ArrayList<>();
        for(int i=0; i<establecimientos.size(); i++){
            for(int j=0; j<establecimientos.get(i).getCanchas().size(); j++)
                if(establecimientos.get(i).getCanchas().get(j).getIdCancha() == idCancha){
                    canchas.add(establecimientos.get(i).getCanchas().get(j));
                }
        }
        return canchas;
    }
    
    @Override
    public void addEstablecimiento(Establecimiento e) {
       establecimientos.add(e);
    }
}
