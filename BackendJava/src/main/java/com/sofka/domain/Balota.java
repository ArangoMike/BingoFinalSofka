package com.sofka.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


/**
 * Clase Balota creada con springboot que representa la balota que saca el
 * locutor en POO para poderla implentarla desde Java
 *
 * @author Michael Arango
 */
@Data
@Entity
@Table(name = "balota")
public class Balota implements Serializable {

    private static final long serialVersionUID = 1L;
   

    @Id
    @Column(name = "id_balota")
    private Long id;

    @Column(name = "balota")
    private String balota;

    public Balota(Long id, String balota) {
        this.id = id;
        this.balota = balota;
    }

    


    public Balota() {
    }

 
    

}
