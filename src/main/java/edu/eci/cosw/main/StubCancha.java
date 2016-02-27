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
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087151
 */
@Service
public class StubCancha implements OperacionCancha{
    private List<Cancha> canchas= new ArrayList<Cancha>();
    {
        canchas.add(new Cancha(1,false));
        canchas.add(new Cancha(2,false));
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
}
