/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TCU.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

/**
 *
 * @author jp09f
 */
@Data
@Entity
@Table(name = "beneficiado")
public class Beneficiado implements Serializable {
   
    private static final long serialVersionUID = 1L;  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiado", nullable = false)
    private Long idBeneficiado;
    @Column(name = "nombre_1")
    private String nombre1;
     @Column(name = "apellido_1")
    private String apellido1;
     @Column(name = "apellido_2")
    private String apellido2;
    private String tipoIdentificacion;
    private long numIdentificacion;
    private String fechaNac;
    private int edad;
    private char sexo;
    private String modalidad;
    private LocalDate fecha;
    private String ultimaValoracion;
    private boolean estado;
    
    
    @OneToMany
    @JoinColumn(name = "id_beneficiado",updatable=false)
    private List<Pension> pensiones;
     
    @OneToMany
    @JoinColumn(name = "id_beneficiado",updatable=false)
    private List<Ayuda> ayudas;




    // Getters and Setters

   
}
