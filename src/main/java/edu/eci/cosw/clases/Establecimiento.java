/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.clases;

import java.util.List;

/**
 *
 * @author 2097396
 */
public class Establecimiento {
    
    
    private String NIT;
    private String RazonSocial;
    private String Direccion;
    private String Telefono;
    private List<Cancha> canchas;
    private List<Calificacion> calificaciones;

    public Establecimiento(){}

    public Establecimiento(String NIT, String RazonSocial, String Direccion, String Telefono, List<Cancha> canchas){
        this.NIT = NIT;
        this.RazonSocial= RazonSocial;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.canchas = canchas;
    }
           

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public List<Cancha> getCanchas() {
        return canchas;
    }

    public void setCanchas(Cancha cancha) {
        canchas.add(cancha);
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }
            
          
}
