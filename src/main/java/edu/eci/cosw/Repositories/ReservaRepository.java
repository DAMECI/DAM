/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Repositories;

import edu.eci.cosw.clases.Reserva;
import edu.eci.cosw.clases.ReservasId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DanielaEF
 */
public interface ReservaRepository extends JpaRepository<Reserva, ReservasId>{
    @Query("from Reserva e where e.id.idreserva=?1")
    Reserva findReservaById(int idreserva);
    
    @Query("select e.precio, e.fechareserva, e.tiempo, s.razonsocial, c.descripcion from Reserva e, Cancha c, Establecimiento s  where e.usuarioId=?1  and e.idCancha = c.id.idcancha and c.id.nitEstablecimiento =s.nit")
    List<Reserva> getReservasByIdCliente(String idUser);
    
}
