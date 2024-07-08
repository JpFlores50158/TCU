
package com.TCU.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "lista_espera")
public class ListaEspera implements Serializable {
   
    private static final long serialVersionUID = 1L;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_espera")
    private Long idListaEspera;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "no_cedula")
    private String noCedula;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "canton")
    private String canton;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_ingreso")
    private String fechaIngreso;

    @Column(name = "descripcion_problema")
    private String descripcionProblema;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "fuente")
    private String fuente;

    @Column(name = "edad")
    private int edad;

    @Column(name = "notificado_posicion_lista_espera")
    private String notificadoPosicionListaEspera;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "sinirubre_estado_justificacion")
    private String sinirubreEstadoJustificacion;
}
