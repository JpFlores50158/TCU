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
@Data
@Entity
public class ExcelJoin {
    
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiado")
    private Long idBeneficiado;
    
    @Column(name = "nombre_1")
    private String nombre1;
    
    @Column(name = "apellido_1")
    private String apellido1;
    
    @Column(name = "apellido_2")
    private String apellido2;
    
    @Column(name = "Tipo_Identific")
    private String tipoIdentificacion;
    
    @Column(name = "Num_identifica")
    private String numIdentificacion;
    
    @Column(name = "fecha_nac")
    private String fechaNac;
    
    @Column(name = "edad")
    private int edad;
    
    @Column(name = "sexo")
    private char sexo;
    
    @Column(name = "modalidad")
    private String modalidad;
    
    @Column(name = "t_pension")
    private String tPension;
    
    @Column(name = "mont_pension")
    private double montPension;
    
   
    
    @Column(name = "fecha_ingr_fallec")
    private String fechaIngrFallec;
    
    @Column(name = "ley7972_monto_ayuda")
    private double ley7972MontoAyuda;
    
    @Column(name = "ley9188_monto_ayuda")
    private double ley9188MontoAyuda;
    
    @Column(name = "mes_lista")
    private String mesLista;
    
    @Column(name = "fiscalizador")
    private String fiscalizador;
    
    @Column(name = "sinirube")
    private String sinirube;
    
    @Column(name = "alimentacion")
    private double alimentacion;
    
    @Column(name = "ARTICULOS_DE_USO_PERSONAL_E_HIGIENE")
    private double articulosUsoPersonalHigiene;
    
    @Column(name = "ATENCION_SOCIAL_EN_SALUD_INTEGRAL")
    private double atencionSocialSaludIntegral;
    
    @Column(name = "PRODUCTOS_DE_APOYO_O_AYUDAS_TECNICAS")
    private double productosApoyoAyudasTecnicas;
    
    @Column(name = "EQUIPAMIENTO_DE_CASA")
    private double equipamientoCasa;
    
    @Column(name = "ALQUILER_DE_VIVIENDA_SERVICIOS_BASICOS_Y_MUNICIPALES")
    private double alquilerViviendaServiciosBasicos;
    
    @Column(name = "familias_solidarias")
    private double familiasSolidarias;
    
    @Column(name = "asistente_domiciliar")
    private double asistenteDomiciliar;
    
     @Column(name = "ley9188_est_actual_activo")
    private boolean ley9188EstActualActivo;
    
    @Column(name = "ley7972_est_actual_activo")
    private boolean ley7972EstActualActivo;

    public boolean getLey9188EstActualActivo() {
        return ley9188EstActualActivo;
    }
    public boolean getLey7972EstActualActivo() {
        return ley7972EstActualActivo;
    }
    
    
    
}
