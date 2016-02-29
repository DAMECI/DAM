/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.interfaces.OperacionCancha;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087151
 */
@Service
public class StubCancha implements OperacionCancha{
    private List<Cancha> canchas= new ArrayList<Cancha>();
    {
        canchas.add(new Cancha(1,30.000,false));
        canchas.add(new Cancha(2,40.000,false));
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
    public Cancha getCanchaByIdCancha(int IdCancha) {
        Cancha aux = new Cancha();
        for(int i=0; i<canchas.size(); i++){
            if(canchas.get(i).getIdCancha() == IdCancha){
                aux = canchas.get(i);
            }
        }
        return aux;
    }
    
    @Override
    public List<Cancha> getCanchaPrecio(Double precio){
        System.out.println("Precio: "+precio);
        List<Cancha> canchasPrecio= new ArrayList<>();
        for(int i=0; i<canchas.size(); i++){
            System.out.println("Precio11"+canchas.get(i).getPrecio().toString());
            System.out.println("Precio11"+canchas.get(i).getPrecio());
            if(Objects.equals(canchas.get(i).getPrecio(), precio))
                canchasPrecio.add(canchas.get(i));
        }
        return canchasPrecio;
    }
}
