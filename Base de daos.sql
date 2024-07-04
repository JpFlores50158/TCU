
create database ABIPAM;
use ABIPAM;

create user 'usuario_abipam'@'%' identified by 'clave_abipam';

grant all privileges on ABIPAM.* to 'usuario_abipam'@'%';
flush privileges;


/* ================================================================================================ */
drop table abipam.rol;
drop table abipam.usuario;
CREATE TABLE abipam.rol (
    id_rol BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL
);

CREATE TABLE abipam.usuario (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    nombre_usuario VARCHAR(50),
    primer_apellido VARCHAR(50),
    segundo_apellido VARCHAR(50),
    correo VARCHAR(50),
    telefono VARCHAR(20),
    activo BOOLEAN,
    id_rol BIGINT,
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

INSERT INTO abipam.rol (nombre_rol) VALUES ('ROLE_ADMIN');
INSERT INTO abipam.rol (nombre_rol) VALUES ('ROLE_USER');

INSERT INTO abipam.usuario (username, password, nombre_usuario, primer_apellido, segundo_apellido, correo, telefono, activo, id_rol) 
VALUES ('Admin', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'Luis', 'Núñez', 'Chacón', 'luis@gmail.com', '7894-8596', TRUE, 1);

INSERT INTO abipam.usuario (username, password, nombre_usuario, primer_apellido, segundo_apellido, correo, telefono, activo, id_rol) 
VALUES ('Usuario', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'Erick', 'Rivera', 'Prado', 'erick@gmail.com', '7894-6845', TRUE, 2);


/* ================================================================================================ */



/* Se crea la tabla de beneficiados */
CREATE TABLE ABIPAM.beneficiado (
    id_beneficiado INT NOT NULL AUTO_INCREMENT,
    nombre_1 VARCHAR(50) NOT NULL,
    apellido_1 VARCHAR(50) NOT NULL,
    apellido_2 VARCHAR(50) NOT NULL,
    tipo_identificacion VARCHAR(50) NOT NULL,
    num_identificacion bigint NOT NULL,
    fecha_nac DATE NOT NULL,
    edad INT NOT NULL,
    sexo CHAR(1) NOT NULL,
    modalidad VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    ultima_valoracion date not null,
    estado boolean not null,
    
    PRIMARY KEY (id_beneficiado)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/* Se crea la tabla de pensiones */
CREATE TABLE ABIPAM.pensiones (
    id_pension INT NOT NULL AUTO_INCREMENT,
    id_beneficiado INT NOT NULL,
    t_pension VARCHAR(50) NOT NULL,
    mont_pension DECIMAL(10, 2) NOT NULL,
    ley9188_est_actual_activo BOOLEAN NOT NULL,
    ley7972_est_actual_activo BOOLEAN NOT NULL,
    tipo_ingre_fallec VARCHAR(50) NOT NULL,
    fecha_ingr_fallec DATE NOT NULL,
    mes_lista DATE NOT NULL,
    fiscalizador VARCHAR(50) NOT NULL,
    sinerube VARCHAR(50) NOT NULL,
    estado boolean not null,
    PRIMARY KEY (id_pension),
    FOREIGN KEY (id_beneficiado) REFERENCES ABIPAM.beneficiado(id_beneficiado)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE ABIPAM.ayuda (
    id_ayuda INT NOT NULL AUTO_INCREMENT,
    id_beneficiado INT NOT NULL,
    alimentacion DECIMAL(15, 2) NOT NULL,
    articulos_uso_personal_higiene DECIMAL(15, 2) NOT NULL,
    atencion_social_salud_integral DECIMAL(15, 2) NOT NULL,
    productos_apoyo_ayudas_tecnicas DECIMAL(15, 2) NOT NULL,
    equipamiento_casa DECIMAL(15, 2) NOT NULL,
    alquiler_vivienda_servicios_basicos DECIMAL(15, 2) NOT NULL,
    familias_solidarias DECIMAL(15, 2) NOT NULL,
    asistente_domiciliar DECIMAL(15, 2) NOT NULL,
    ley7972_monto_ayuda DECIMAL(15, 2) NOT NULL,
    ley9188_monto_ayuda DECIMAL(15, 2) NOT NULL,
    fecha DATE NOT NULL,
    estado BOOLEAN NOT NULL,
    PRIMARY KEY (id_ayuda),
    FOREIGN KEY (id_beneficiado) REFERENCES ABIPAM.beneficiado(id_beneficiado)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

drop table abipam.ayuda;

select * from abipam.ayuda;
/* Se crea la tabla de lista de espera */
CREATE TABLE ABIPAM.lista_espera (
    id_lista_espera INT NOT NULL AUTO_INCREMENT,
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    no_cedula VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    canton VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    direccion TEXT NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    descripcion_problema TEXT NOT NULL,
    prioridad INT NOT NULL,
    fuente VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    notificado_posicion_lista_espera VARCHAR(50) NOT NULL,
    observacion TEXT NOT NULL,
    sinirubre_estado_justificacion TEXT NOT NULL,
    PRIMARY KEY (id_lista_espera)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


drop table abipam.lista_espera;
/* Se crea la tabla de actividades */
CREATE TABLE ABIPAM.actividades (
    id_actividad INT NOT NULL AUTO_INCREMENT,
    organizacion VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    tipo_actividad VARCHAR(50) NOT NULL,
    ninos_0_5 INT NOT NULL,
    ninos_5_12 INT NOT NULL,
    adolescentes INT NOT NULL,
    adulto_hombre INT NOT NULL,
    adulto_mujer INT NOT NULL,
    personas_mayores_65 INT NOT NULL,
    PRIMARY KEY (id_actividad)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*INSERTS DE USUARIOS*/
insert into ABIPAM.usuario(id_usuario, username, password, nombre_usuario, primer_apellido, segundo_apellido, correo, telefono,  activo) values
('1', 'Admin','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Luis','Núñez','Chacón','luis@gmail.com','7894-8596',true),
('2', 'Gerente','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Jose','Flores','Munoz','jose@gmail.com','4567-8475',true),
('3', 'Usuario','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Erick','Rivera','Prado','erick@gmail.com','7894-6845',true);

insert into ABIPAM.rol (id_rol, nombre_rol, id_usuario) values
 (1,'ROLE_ADMIN',1),
 (2,'ROLE_USER',1),
 (3,'ROLE_ADMIN',2),
 (4,'ROLE_USER',2),
 (5,'ROLE_USER',3);
 
 

DELIMITER //

Create PROCEDURE ABIPAM.obtenerDatosCompletos()
BEGIN
    SELECT 
		b.id_beneficiado,
        CONCAT(b.nombre_1, ' ', b.apellido_1, ' ', b.apellido_2) AS Nombre_completo,
        b.nombre_1,
        b.apellido_1,
        b.apellido_2,
        b.tipo_identificacion AS Tipo_Identific,
        b.num_identificacion AS Num_identifica,
        b.fecha_nac AS Fecha_Nac,
        b.edad AS Edad,
        b.sexo AS Sexo,
        b.modalidad AS Modalidad,
        p.t_pension AS T_Pension,
        p.mont_pension AS Mont_pension,
        p.ley9188_est_actual_activo AS Ley9188_Est_actual_activo,
        p.ley7972_est_actual_activo AS Ley7972_Est_actual_activo,
        p.fecha_ingr_fallec AS Fecha_Ingr_fallec,
        a.ley7972_monto_ayuda AS Ley7972_Monto_ayuda,
        a.ley9188_monto_ayuda AS Ley9188_Monto_ayuda,
        p.mes_lista AS Mes_lista,
        p.fiscalizador AS Fiscalizador,
        p.sinerube AS Sinirube,
        a.alimentacion AS ALIMENTACION,
        a.articulos_uso_personal_higiene AS ARTICULOS_DE_USO_PERSONAL_E_HIGIENE,
        a.atencion_social_salud_integral AS ATENCION_SOCIAL_EN_SALUD_INTEGRAL,
        a.productos_apoyo_ayudas_tecnicas AS PRODUCTOS_DE_APOYO_O_AYUDAS_TECNICAS,
        a.equipamiento_casa AS EQUIPAMIENTO_DE_CASA,
        a.alquiler_vivienda_servicios_basicos AS ALQUILER_DE_VIVIENDA_SERVICIOS_BASICOS_Y_MUNICIPALES,
        a.familias_solidarias AS FAMILIAS_SOLIDARIAS,
        a.asistente_domiciliar AS ASISTENTE_DOMICILIAR
    FROM ABIPAM.beneficiado b
    LEFT JOIN ABIPAM.pensiones p ON b.id_beneficiado = p.id_beneficiado
    LEFT JOIN ABIPAM.ayuda a ON b.id_beneficiado = a.id_beneficiado
    ORDER BY b.nombre_1, b.apellido_1, b.apellido_2;
END //

DELIMITER ;

select * from abipam.ayuda;
select * from abipam.pensiones;

