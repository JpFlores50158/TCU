
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
@Table(name = "ayuda")
public class Ayuda implements Serializable {
   
    private static final long serialVersionUID = 1L;  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ayuda")
    private Long idAyuda;

  

    @Column(name = "alimentacion")
    private double alimentacion;

    @Column(name = "articulos_uso_personal_higiene")
    private double articulosUsoPersonalHigiene;

    @Column(name = "atencion_social_salud_integral")
    private double atencionSocialSaludIntegral;

    @Column(name = "productos_apoyo_ayudas_tecnicas")
    private double productosApoyoAyudasTecnicas;

    @Column(name = "equipamiento_casa")
    private double equipamientoCasa;

    @Column(name = "alquiler_vivienda_servicios_basicos")
    private double alquilerViviendaServiciosBasicos;

    @Column(name = "familias_solidarias")
    private double familiasSolidarias;

    @Column(name = "asistente_domiciliar")
    private double asistenteDomiciliar;

    @Column(name = "ley7972_monto_ayuda")
    private double ley7972MontoAyuda;

    @Column(name = "ley9188_monto_ayuda")
    private double ley9188MontoAyuda;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado")
    private boolean estado;
    
    
     @ManyToOne
    @JoinColumn(name = "id_beneficiado")
    private Beneficiado beneficiado;
}