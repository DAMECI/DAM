/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;

import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.clases.Usuario;
import edu.eci.cosw.interfaces.OperacionReserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087151
 */
@Service
public class StubReserva implements OperacionReserva{
    private List<Reserva>  reservas = new ArrayList<Reserva>();
    {
        reservas.add(new Reserva(new Date(201531), 20.000, 1, 
                new Usuario("2","a", "b", "11111", "ab@gmail.com", "12345"), 2.5));
        reservas.add(new Reserva(new Date(242016), 20.000, 2, 
                new Usuario("3","aa", "bb", "11111", "aabb@gmail.com", "12345"), 2.0));
    }    

    @Override
    public List<Reserva> getReservas() {
         return reservas;
    }

    @Override
    public Reserva getReservaByIdreserva(int IdReserva) {
        Reserva aux = new Reserva();
        for(int i=0; i<reservas.size(); i++){
            if(reservas.get(i).getId()== IdReserva){
                aux = reservas.get(i);
            }
        }
        return aux; 
    }

    @Override
    public void addReserva(Reserva r) {
       reservas.add(r);
    }

   
}
