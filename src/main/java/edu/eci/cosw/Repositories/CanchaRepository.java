/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Repositories;

import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.CanchasId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author DanielaEF
 */
public interface CanchaRepository extends JpaRepository<Cancha, CanchasId>{
    @Query("from Cancha c where c.id.idcancha=?1")
    Cancha findCanchaById(int idcancha);
    
}
