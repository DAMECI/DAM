/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

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
        establecimientos.add(new Establecimiento("1542-4", "Cancha5", "calle 170 #13-1", "12333"));
        establecimientos.add(new Establecimiento("2541-1", "RealMadrid", "cra 1 #1-1", "12333"));
        establecimientos.add(new Establecimiento("8954-0", "Emirates", "cra 20 #2-2", "12333"));
    }    

    @Override
    public List<Establecimiento> getEstablecimientos() {
         return establecimientos;
    }

    @Override
    public Establecimiento getEstablecimientoByNit(String nit) {
        Establecimiento aux = new Establecimiento();
        System.out.println("NIT:" +nit);
        for(int i=0; i<establecimientos.size(); i++){
            if(establecimientos.get(i).getNIT().equals(nit)){
                aux = establecimientos.get(i);
            }
        }
        return aux;
    }
    
    @Override
    public void addEstablecimiento(Establecimiento e) {
       establecimientos.add(e);
    }
}
