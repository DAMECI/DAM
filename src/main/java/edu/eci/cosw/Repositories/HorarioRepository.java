/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Repositories;

import edu.eci.cosw.clases.Horario;
import edu.eci.cosw.clases.HorariosId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DanielaEF
 */
public interface HorarioRepository extends JpaRepository<Horario, HorariosId>{
    
}
