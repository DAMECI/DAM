/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Repositories;

import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.clases.ReservasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DanielaEF
 */
public interface ReservaRepository extends JpaRepository<Reserva, ReservasId>{
      @Query("from Reserva e where e.id.idreserva=?1")
    Reserva findReservaById(int idreserva);  
}
