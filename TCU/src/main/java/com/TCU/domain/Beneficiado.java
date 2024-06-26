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
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
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

    // Getters and Setters

    public Long getIdBeneficiado() {
        return idBeneficiado;
    }

    public void setIdBeneficiado(Long idBeneficiado) {
        this.idBeneficiado = idBeneficiado;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public long getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(long numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUltimaValoracion() {
        return ultimaValoracion;
    }

    public void setUltimaValoracion(String ultimaValoracion) {
        this.ultimaValoracion = ultimaValoracion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
