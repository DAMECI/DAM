/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.imp;

import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.Establecimiento;
import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.clases.Usuario;
import java.util.List;

/**
 *
 * @author paola
 */
public interface DamServices {
    public void addUser(Usuario u);
    public List<Usuario> getUser();
    public Usuario findUserById(String id);
    public List<Establecimiento> getEstablecimientos();
    public Establecimiento getEstablecimientoByNit(String nit);
    public void addEstablecimiento(Establecimiento e);
    public List<Cancha> getCanchas();
    public Cancha getCanchaByid(int idCancha);
    public Cancha addCancha(Cancha c);
    public void addReserva(Reserva r);
    public List<Reserva> getReservas();
    public Reserva getReservaByid(int idreserva);
    public List<Reserva> getReservasByIdCliente(String idUser);
    public void addCalificacion(Calificacion c);
    
}
