/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.stubs;

import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.interfaces.OperacionCancha;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import edu.eci.cosw.interfaces.OperacionUsuario;

/**
 *
 * @author 2087151
 */
@Service
public class StubCancha implements OperacionCancha{
    private List<Cancha> canchas= new ArrayList<Cancha>() ;    


    @Override
    public void addCancha(Cancha c) {
        canchas.add(c);  
    }
    

    @Override
    public List<Cancha> getCanchas() {
        return canchas;   
    }

    @Override
    public Cancha getCanchaByIdcancha(int IdCancha) {
        Cancha aux = new Cancha();
        for(int i=0; i<canchas.size(); i++){
            if(canchas.get(i).getIdCancha() == IdCancha){
                aux = canchas.get(i);
            }
        }
        return aux;
    }
}
