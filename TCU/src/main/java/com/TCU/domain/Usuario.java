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
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author jp09f
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario  implements Serializable {
   
    private static final long serialVersionUID = 1L;  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @NotEmpty(message = "This field is required")
    private String username; 
    
    @NotEmpty(message = "This field is required")
    private String password; 
    
    private String nombreUsuario;
    private String primerApellido;
    private String segundoApellido; 
    private String correo;
    private String telefono;
    private boolean activo;
    
    @Transient
    private String tempPassword; 
    
   
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    
    
    
    
    
}