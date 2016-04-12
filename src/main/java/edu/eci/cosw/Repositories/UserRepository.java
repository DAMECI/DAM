/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Repositories;

import edu.eci.cosw.clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author paola
 */

public interface UserRepository extends JpaRepository<Usuario, String>{
    @Query("from Usuario u where u.idCliente= :user and u.password= :pass")
    Usuario Login(@Param(value = "user")String user,@Param(value = "pass")String password);
     
    @Query("from Usuario u where u.idCliente=?1")
    Usuario findUserById(String idCliente);
}
