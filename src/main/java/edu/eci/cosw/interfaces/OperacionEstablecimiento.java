/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.interfaces;


import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.Establecimiento;
import java.util.List;

/**
 *
 * @author 2087151
 */
public interface OperacionEstablecimiento {
    
        public List<Establecimiento> getEstablecimientos();
        public Establecimiento getEstablecimientoByNit(String nit);
        public void addEstablecimiento(Establecimiento e);    
        public List<Cancha> getCanchasEstablecimiento(int idCancha);
        public void addCalificacion(Calificacion c);
}
