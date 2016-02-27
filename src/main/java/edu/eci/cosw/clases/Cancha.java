/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.clases;

import java.util.List;

/**
 *
 * @author 2087151
 */
public class Cancha {
    
    private int IdCancha;
    private boolean Reservado;
    private List<Reserva> Reserva;

    public Cancha(){}

    public Cancha(int IdCancha, boolean Reservado){
        this.IdCancha= IdCancha;
        this.Reservado = Reservado;
    }

    public int getIdCancha() {
        return IdCancha;
    }

    public void setId(int IdCancha) {
        this.IdCancha = IdCancha;
    }

    public boolean isReservado() {
        return Reservado;
    }

    public void setReservado(boolean Reservado) {
        this.Reservado = Reservado;
    }
    
    public List<Reserva> getReserva() {
        return Reserva;
    }

    public void setReserva(Reserva reserva) {
        Reserva.add(reserva);
    }
}
