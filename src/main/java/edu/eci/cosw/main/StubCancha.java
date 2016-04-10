/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.CanchasId;
import edu.eci.cosw.interfaces.OperacionCancha;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087151
 */
@Service
public class StubCancha implements OperacionCancha{
    private List<Cancha> canchas= new ArrayList<Cancha>();
    {
        
//        canchas.add(new Cancha((new CanchasId(11,"1542-4")),true,1562));
//        canchas.add(new Cancha((new CanchasId(12,"1542-4")),false,1563));
//         
//        canchas.add(new Cancha((new CanchasId(21,"2541-1")),true,2562));
//        canchas.add(new Cancha((new CanchasId(22,"2541-1")),false,2563));
//        
//        canchas.add(new Cancha((new CanchasId(31,"8954-0")),true,3562));
//        canchas.add(new Cancha((new CanchasId(32,"8954-0")),false,3563));
    }


    @Override
    public void addCancha(Cancha c) {
        canchas.add(c);  
    }
    

    @Override
    public List<Cancha> getCanchas() {
        return canchas;   
    }

    @Override
    public Cancha getCanchaByIdCancha(int IdCancha, String nitEstablecimiento) {
        Cancha aux = new Cancha();
        for(int i=0; i<canchas.size(); i++){
            if(canchas.get(i).getId() == new CanchasId(IdCancha, nitEstablecimiento)){
                aux = canchas.get(i);
            }
        }
        return aux;
    }
    
    @Override
    public List<Cancha> getCanchaPrecio(Double precio){        
        List<Cancha> canchasPrecio= new ArrayList<Cancha>();
        for(int i=0; i<canchas.size(); i++){           
            if(Objects.equals(canchas.get(i), precio))
                canchasPrecio.add(canchas.get(i));
        }
        return canchasPrecio;
    }
}
