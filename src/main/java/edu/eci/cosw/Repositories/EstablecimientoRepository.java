/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Repositories;

import edu.eci.cosw.clases.Cancha;
import edu.eci.cosw.clases.Establecimiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author DanielaEF
 */
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, String>{
    @Query("from Establecimiento e where e.nit=?1")
    Establecimiento findById(String nit);
}
