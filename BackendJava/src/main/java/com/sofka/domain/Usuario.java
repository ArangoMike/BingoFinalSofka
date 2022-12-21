package com.sofka.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;


import lombok.Data;

/**
 * Clase Usuario creada con springboot que representa la tabla usuario en POO
 * para poderla implentarla desde Java
 *
 * @author Michael Arango
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "id_mongoU")
    private String idMongoU;

    /*   
     @ManyToOne
     @JoinColumn(name = "juego_id", referencedColumnName = "id_juego")
     private Juego juegoId; 
        
     */


}
