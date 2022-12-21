
package com.sofka.dao;


import com.sofka.domain.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author maicol
 */

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    
      /**
     *  Query personalizada para la actualización del nombre en la BD contacto
     * @param id
     * @param idMongoU 
     */
    @Modifying
    @Query("update Usuario u set u.idMongoU= :idMongoU where u.id = :id")
    public void updateIdMongoU(
            @Param(value = "id") Long id,
            @Param(value = "idMongoU") String idMongoU
    );
    
    /**
     *  Query personalizada para la actualización del nombre en la BD contacto
     * @param id
     * @param juego_id_
     
    @Modifying
    @Query("update Usuario u set u.juegoId= :juegoId where u.id = :id")
    public void updateJuegoId(
            @Param(value = "id") Long id,
            @Param(value = "juegoId") Juego juegoId
    );
    */
}
