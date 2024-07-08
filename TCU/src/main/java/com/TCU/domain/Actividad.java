package com.TCU.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "actividades", schema = "ABIPAM")
public class Actividad implements Serializable {
   
    private static final long serialVersionUID = 1L;  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long idActividad;

    @Column(name = "organizacion")
    private String organizacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "tipo_actividad")
    private String tipoActividad;

    @Column(name = "ninos_0_5")
    private int ninos0a5;

    @Column(name = "ninos_5_12")
    private int ninos5a12;

    @Column(name = "adolescentes")
    private int adolescentes;

    @Column(name = "adulto_hombre")
    private int adultoHombre;

    @Column(name = "adulto_mujer")
    private int adultoMujer;

    @Column(name = "personas_mayores_65")
    private int personasMayores65;
}