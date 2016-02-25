/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.clases;


import java.util.Date;


/**
 *
 * @author 2087151
 */
public class Reserva {

    private Date FechaReserva;
    private Double Precio;
    private int IdReserva;
    private Usuario UsuarioReserva;
    private Double tiempo;
   

    public Reserva(){
    }
    
    public Reserva(Date FechaReserva, Double Precio, int IdReserva, Usuario UsuarioReserva, Double tiempo) {
        this.FechaReserva = FechaReserva;
        this.Precio = Precio;
        this.IdReserva = IdReserva;
        this.UsuarioReserva = UsuarioReserva;
        this.tiempo = tiempo;
    }
    
    public Date getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(Date FechaReserva) {
        this.FechaReserva = FechaReserva;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getId() {
        return IdReserva;
    }

    public void setId(int IdReserva) {
        this.IdReserva = IdReserva;
    }

    public Usuario getUsuarioReserva() {
        return UsuarioReserva;
    }

    public void setUsuarioReserva(Usuario UsuarioReserva) {
        this.UsuarioReserva = UsuarioReserva;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
}
