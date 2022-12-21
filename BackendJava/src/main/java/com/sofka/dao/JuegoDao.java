package com.sofka.dao;

import com.sofka.domain.Juego;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author maicol
 */
public interface JuegoDao extends CrudRepository<Juego, Long> {

    /**
     * Query personalizada para la actualización del nombre en la BD contacto
     *
     * @param id
     * @param estadoJuego
     */
    @Modifying
    @Query("update Juego j set j.estadoJuego = :estadoJuego where j.id= :id")
    public void updateEstadoJuego(
            @Param(value = "id") Long id,
            @Param(value = "estadoJuego") String estadoJuego
    );

    /**
     * Query personalizada para la actualización del nombre en la BD databingo
     *
     * @param id
     * @param ganadorJuego
     */
    @Modifying
    @Query(value = "update Juego j set j.ganadorJuego = :ganadorJuego where j.id = :id")
    public void updateGanadorJuego(
            @Param(value = "id") Long id,
            @Param(value = "ganadorJuego") String ganadorJuego
    );

    /**
     * Query personalizada para la actualización de la fechaInicio en la BD
     * databingo
     *
     * @param id
     * @param fechaInicio
     */
    @Modifying
    @Query("update Juego j set j.fechaInicio = :fechaInicio where j.id = :id")
    public void updateFechaInicio(
            @Param(value = "id") Long id,
            @Param(value = "fechaInicio") LocalDateTime fechaInicio
    );

    /**
     * 
     * @param estadoJuego
     * @return 
     */
    @Modifying
    @Query("select j from Juego j where j.estadoJuego = :estadoJuego")
        public Optional<Juego> findbyEnum(
            @Param(value = "estadoJuego") String estadoJuego
            
    );

}
