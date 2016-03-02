/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.clases;

/**
 *
 * @author 2087151
 */
public class Calificacion {

    private int IdCalificacion;
    private int Puntaje;
    private String Observacion;
    private Usuario usuarioCalifica;
    private String NitEstablecimiento;
    
    public Calificacion(){}
    
    public Calificacion(int IdCalificacion, int Puntaje, String Observacion, Usuario usuarioCalifica) {
        this.IdCalificacion = IdCalificacion;
        this.Puntaje = Puntaje;
        this.Observacion = Observacion;
        this.usuarioCalifica = usuarioCalifica;
    }

    public int getIdCalificacion() {
        return IdCalificacion;
    }

    public void setIdCalificacion(int IdCalificacion) {
        this.IdCalificacion = IdCalificacion;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public Usuario getUsuarioCalifica() {
        return usuarioCalifica;
    }

    public void setUsuarioCalifica(Usuario usuarioCalifica) {
        this.usuarioCalifica = usuarioCalifica;
    }
    
    
    public String getNitEstablecimiento() {
        return NitEstablecimiento;
    }

    public void setNitEstablecimiento(String NitEstablecimiento) {
        this.NitEstablecimiento = NitEstablecimiento;
    }
    
}
