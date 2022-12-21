
package com.sofka.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;


/**
 * Clase Juego creada con springboot que representa la tabla juego
 * en POO para poderla implentarla desde Java
 * @author Michael Arango
 */
@Data
@Entity
@Table(name = "juego")
public class Juego implements Serializable {
    
     private static final long serialVersionUID = 1L;
     
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Long id;
    
     @Column(name = "estado_juego")
    private String estadoJuego;
     
     @Column(name = "ganador_juego")
    private String ganadorJuego;
     
     @Column(name = "fecha_inicio")
     @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime fechaInicio;
     
   /*  @ManyToOne
     @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
     private Usuario usuarioId;
     */
     
    
   
     
}

