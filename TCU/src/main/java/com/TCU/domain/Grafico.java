
package com.TCU.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
