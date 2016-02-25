/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.stubs;

import edu.eci.cosw.clases.Usuario;
import ch.qos.logback.classic.util.ContextInitializer;
import edu.eci.cosw.clases.Establecimiento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import edu.eci.cosw.interfaces.OperacionUsuario;
import edu.eci.cosw.interfaces.OperacionesEstablecimiento;

/**
 *
 * @author 2087151
 */
@Service
public class StubEstablecimiento implements OperacionesEstablecimiento{
    private List<Establecimiento>  establecimientos = new ArrayList<Establecimiento>() ;    

    @Override
    public List<Establecimiento> getEstablecimientos() {
         return establecimientos;
    }

    @Override
    public Establecimiento getEstablecimientoByNIT(String NIT) {
        Establecimiento aux = new Establecimiento();
        for(int i=0; i<establecimientos.size(); i++){
            if(establecimientos.get(i).getNIT().equals(NIT)){
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
