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
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "pensiones")
public class Pension implements Serializable {
   
    private static final long serialVersionUID = 1L;  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pension")
    private Long idPension;
    
    @Column(name = "t_pension")
    private String tipoPension;

    @Column(name = "mont_pension")
    private double montoPension;

    @Column(name = "ley9188_est_actual_activo")
    private boolean ley9188EstadoActualActivo;

    @Column(name = "ley7972_est_actual_activo")
    private boolean ley7972EstadoActualActivo;
    
    @Column(name = "tipo_ingre_fallec")
    private String tipoIngreFallec;

    @Column(name = "fecha_ingr_fallec")
    private String fechaIngresoFallecimiento;


    @Column(name = "mes_lista")
    private LocalDate mesLista;

    @Column(name = "fiscalizador")
    private String fiscalizador;

    @Column(name = "sinerube")
    private String sinerube;

    @Column(name = "estado")
    private Boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "id_beneficiado")
    private Beneficiado beneficiado;

    // Getters and setters
}  