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
import lombok.Data;

/**
 *
 * @author jp09f
 */
@Entity
@Data
public class Grafico {
    
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Nombre_completo")
    private String nombreCompleto;
    
    @Column(name = "cedula")
    private String cedula;
    
    @Column(name = "monto_ayuda")
    private double montoAyuda;
}
