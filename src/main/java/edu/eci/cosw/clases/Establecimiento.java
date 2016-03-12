/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.clases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 2097396
 */
public class Establecimiento {
    
    private double CalificacionPromedio;
    private String NIT;
    private String RazonSocial;
    private String Direccion;
    private String Telefono;
    private List<Cancha> canchas;
    private Set<Calificacion> calificaciones = new HashSet<Calificacion>();

    public Establecimiento(){}

    public Establecimiento(String NIT, String RazonSocial, String Direccion, String Telefono, List<Cancha> canchas){
        this.NIT = NIT;
        this.RazonSocial= RazonSocial;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.canchas = canchas;
    }
           

    public double getCalificacionPromedio() {
        CalificacionPromedio =0D;
        for(Calificacion oCalifica: calificaciones){
            CalificacionPromedio = CalificacionPromedio + (double)oCalifica.getPuntaje();
        }
        
        if (calificaciones.size() > 0){
            CalificacionPromedio = CalificacionPromedio / calificaciones.size();
        }
        
        return CalificacionPromedio;
    }

    public void setCalificacionPromedio(double CalificacionPromedio) {
        this.CalificacionPromedio = CalificacionPromedio;
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

    public Set<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }
}
