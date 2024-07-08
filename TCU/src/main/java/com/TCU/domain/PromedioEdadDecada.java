
package com.TCU.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class PromedioEdadDecada {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decada")
    private int decada;
    
    @Column(name = "cantidad_beneficiados")
    private int cantidad;
    
    @Column(name = "porcentaje")
    private double porcentaje;
}
