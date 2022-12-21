package com.sofka.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 * Clase TablaBingo creada con springboot que representa la tabla tablaBingo en
 * POO para poderla implentarla desde Java
 *
 * @author Michael Arango
 */
@Data
@Entity
@Table(name = "tabla_bingo")
public class TablaBingo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tabla_bingo")
    private Long id;

    @Column(name = "b1")
    private Integer b1;

    @Column(name = "b2")
    private Integer b2;

    @Column(name = "b3")
    private Integer b3;

    @Column(name = "b4")
    private Integer b4;

    @Column(name = "b5")
    private Integer b5;

    @Column(name = "i1")
    private Integer i1;

    @Column(name = "i2")
    private Integer i2;

    @Column(name = "i3")
    private Integer i3;

    @Column(name = "i4")
    private Integer i4;

    @Column(name = "i5")
    private Integer i5;

    @Column(name = "n1")
    private Integer n1;

    @Column(name = "n2")
    private Integer n2;

    @Column(name = "n3")
    private String n3;

    @Column(name = "n4")
    private Integer n4;

    @Column(name = "n5")
    private Integer n5;

    @Column(name = "g1")
    private Integer g1;

    @Column(name = "g2")
    private Integer g2;

    @Column(name = "g3")
    private Integer g3;

    @Column(name = "g4")
    private Integer g4;

    @Column(name = "g5")
    private Integer g5;

    @Column(name = "o1")
    private Integer o1;

    @Column(name = "o2")
    private Integer o2;

    @Column(name = "o3")
    private Integer o3;

    @Column(name = "o4")
    private Integer o4;

    @Column(name = "o5")
    private Integer o5;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuarioId;

    public TablaBingo() {
    }

    public TablaBingo llenarTablaBingo(TablaBingo tB) {

        //Llenamos los campos de la letra B
        tB.setB1((int) (Math.random() * 15 + 1));
        Integer num;

        do {
            num = (int) (Math.random() * 15 + 1);
            tB.setB2(num);

        } while (tB.getB1() == num);

        do {
            num = (int) (Math.random() * 15 + 1);
            tB.setB3(num);

        } while (tB.getB1() == num || tB.getB2() == num);

        do {
            num = (int) (Math.random() * 15 + 1);
            tB.setB4(num);

        } while (tB.getB1() == num || tB.getB2() == num || tB.getB3() == num);

        do {
            num = (int) (Math.random() * 15 + 1);
            tB.setB5(num);

        } while (tB.getB1() == num
                || tB.getB2() == num
                || tB.getB3() == num
                || tB.getB4() == num);

        // Llenamos los campos de la letra I
        tB.setI1((int) (Math.random() * 15 + 15 + 1));

        do {
            num = (int) (Math.random() * 15 + 15 + 1);
            tB.setI2(num);

        } while (tB.getI1() == num);

        do {
            num = (int) (Math.random() * 15 + 15 + 1);
            tB.setI3(num);

        } while (tB.getI1() == num || tB.getI2() == num);

        do {
            num = (int) (Math.random() * 15 + 15 + 1);
            tB.setI4(num);

        } while (tB.getI1() == num || tB.getI2() == num || tB.getI3() == num);

        do {
            num = (int) (Math.random() * 15 + 15 + 1);
            tB.setI5(num);

        } while (tB.getI1() == num
                || tB.getI2() == num
                || tB.getI3() == num
                || tB.getI4() == num);

        // Llenamos los campos de la letra N
        tB.setN1((int) (Math.random() * 15 + 30 + 1));

        do {
            num = (int) (Math.random() * 15 + 30 + 1);
            tB.setN2(num);

        } while (tB.getN1() == num);

        tB.setN3("FREE");

        do {
            num = (int) (Math.random() * 15 + 30 + 1);
            tB.setN4(num);

        } while (tB.getN1() == num || tB.getN2() == num);

        do {
            num = (int) (Math.random() * 15 + 30 + 1);
            tB.setN5(num);

        } while (tB.getN1() == num || tB.getN2() == num || tB.getN4() == num);

        // Llenamos las los campos de la letra G
        tB.setG1((int) (Math.random() * 15 + 45 + 1));

        do {
            num = (int) (Math.random() * 15 + 45 + 1);
            tB.setG2(num);

        } while (tB.getG1() == num);

        do {
            num = (int) (Math.random() * 15 + 45 + 1);
            tB.setG3(num);

        } while (tB.getG1() == num || tB.getG2() == num);

        do {
            num = (int) (Math.random() * 15 + 45 + 1);
            tB.setG4(num);

        } while (tB.getG1() == num || tB.getG2() == num || tB.getG3() == num);

        do {
            num = (int) (Math.random() * 15 + 45 + 1);
            tB.setG5(num);

        } while (tB.getG1() == num
                || tB.getG2() == num
                || tB.getG3() == num
                || tB.getG4() == num);

        // Llenamos los campos de la letra O
        tB.setO1((int) (Math.random() * 15 + 60 + 1));

        do {
            num = (int) (Math.random() * 15 + 60 + 1);
            tB.setO2(num);

        } while (tB.getO1() == num);

        do {
            num = (int) (Math.random() * 15 + 60 + 1);
            tB.setO3(num);

        } while (tB.getO1() == num || tB.getO2() == num);

        do {
            num = (int) (Math.random() * 15 + 60 + 1);
            tB.setO4(num);

        } while (tB.getO1() == num || tB.getO2() == num || tB.getO3() == num);

        do {
            num = (int) (Math.random() * 15 + 60 + 1);
            tB.setO5(num);

        } while (tB.getO1() == num
                || tB.getO2() == num
                || tB.getO3() == num
                || tB.getO4() == num);

        return tB;
    }

}
