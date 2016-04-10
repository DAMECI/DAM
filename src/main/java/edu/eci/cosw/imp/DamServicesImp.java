/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.imp;


import edu.eci.cosw.Repositories.UserRepository;
import edu.eci.cosw.clases.Usuario;
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
//    
//    @Autowired
//    private CanchaRepository cancha;
//    
//    @Autowired
//    private HorarioRepository horario;
//    
//    @Autowired
//    private EstablecimientoRepository establecimiento;

    @Override
    public void addUser(Usuario u) {
        user.save(u);
    }

    
    
    
}
