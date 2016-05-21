/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.main;


import edu.eci.cosw.Repositories.CalificacionRepository;
import edu.eci.cosw.Repositories.CanchaRepository;
import edu.eci.cosw.Repositories.EstablecimientoRepository;
import edu.eci.cosw.Repositories.HorarioRepository;
import edu.eci.cosw.Repositories.ReservaRepository;
import edu.eci.cosw.Repositories.UserRepository;
import edu.eci.cosw.clases.Calificacion;
import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.Establecimiento;
import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.clases.Usuario;
import edu.eci.cosw.imp.DamServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author paola
 */
@Service
public class DamServicesImp implements DamServices{
    @Autowired
    private UserRepository user;
    
    @Autowired
    private CanchaRepository cancha;
   /*
    @Autowired
    private HorarioRepository horario;*/
    
    @Autowired
    private ReservaRepository reserva;
    
    @Autowired
    private EstablecimientoRepository establecimiento;
    
    @Autowired
    private CalificacionRepository calificacion;

    @Override
    public void addUser(Usuario u) {
        user.save(u);
    }

    @Override
    public List<Usuario> getUser() {
        return user.findAll();
    }
    
    @Override
    public Usuario findUserById(String id){
        return user.findUserById(id);
    }

    @Override
    public List<Establecimiento> getEstablecimientos(){
        return establecimiento.findAll();
    }

    @Override
    public Establecimiento getEstablecimientoByNit(String nit) {
        return establecimiento.findById(nit);
    }

    @Override
    public void addEstablecimiento(Establecimiento e) {
       establecimiento.save(e);
    }

    @Override
    public List<Cancha> getCanchas() {
        return cancha.findAll();
    }
    
    @Override
    public Cancha getCanchaByid(int idCancha) {
        return cancha.findCanchaById(idCancha);
    }

    @Override
    public void addReserva(Reserva r) {
         reserva.save(r);
    }
    
    @Override
    public Cancha addCancha(Cancha c) {
        return cancha.save(c);
    }

    @Override
    public Reserva getReservaByid(int idreserva) {
         return reserva.findReservaById(idreserva);
    }
    @Override
    public List<Reserva> getReservas() {
        return reserva.findAll();
    }
    
    @Override
    public void addCalificacion(Calificacion c) {
        calificacion.save(c);
    }
    
    
    public List<Reserva> getReservasByIdCliente(String idUser){
        return reserva.getReservasByIdCliente(idUser);
    }
    
            
    
    
}
