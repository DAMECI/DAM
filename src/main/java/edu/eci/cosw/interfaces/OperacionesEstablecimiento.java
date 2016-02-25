/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.interfaces;


import edu.eci.cosw.clases.Establecimiento;
import java.util.List;

/**
 *
 * @author 2087151
 */
public interface OperacionesEstablecimiento {
    
        public List<Establecimiento> getEstablecimientos();
        public Establecimiento getEstablecimientoByNIT(String NIT);
        public void addEstablecimiento(Establecimiento e);
    
}
