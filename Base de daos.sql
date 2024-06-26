
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

/* Se crea la tabla de ayuda */
CREATE TABLE ABIPAM.ayuda (
    id_ayuda INT NOT NULL AUTO_INCREMENT,
    id_beneficiado INT NOT NULL,
    alimentacion BOOLEAN NOT NULL,
    articulos_uso_personal_higiene BOOLEAN NOT NULL,
    atencion_social_salud_integral BOOLEAN NOT NULL,
    productos_apoyo_ayudas_tecnicas BOOLEAN NOT NULL,
    equipamiento_casa BOOLEAN NOT NULL,
    alquiler_vivienda_servicios_basicos BOOLEAN NOT NULL,
    familias_solidarias BOOLEAN NOT NULL,
    asistente_domiciliar BOOLEAN NOT NULL,
    fecha DATE NOT NULL,
    estado boolean not null,
	ley7972_monto_ayuda DECIMAL(10, 2) NOT NULL,
    ley9188_monto_ayuda DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id_ayuda),
    FOREIGN KEY (id_beneficiado) REFERENCES ABIPAM.beneficiado(id_beneficiado)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
drop table abipam.ayuda


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
    senas TEXT NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    descripcion_problema TEXT NOT NULL,
    prioridad VARCHAR(50) NOT NULL,
    fuente VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    notificado_posicion_lista_espera BOOLEAN NOT NULL,
    observacion TEXT NOT NULL,
    sinirubre_estado_justificacion TEXT NOT NULL,
    PRIMARY KEY (id_lista_espera)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


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
 
 
 
 
 INSERT INTO ABIPAM.beneficiado (nombre_1, apellido_1, apellido_2, tipo_identificacion, num_identificacion, fecha_nac, edad, sexo, modalidad, fecha, ultima_valoracion, estado)
VALUES 
('Juan', 'Pérez', 'Gómez', 'DNI', 12345678, '1980-05-15', 44, 'M', 'Modalidad1', '2024-06-25', '2024-06-01', true),
('María', 'Rodríguez', 'López', 'Pasaporte', 98765432, '1990-11-20', 33, 'F', 'Modalidad2', '2024-06-25', '2024-05-15', true),
('Carlos', 'Fernández', 'Martínez', 'Cédula', 12312312, '1985-02-10', 39, 'M', 'Modalidad3', '2024-06-25', '2024-04-20', true),
('Laura', 'García', 'Sánchez', 'DNI', 45645645, '1978-08-05', 45, 'F', 'Modalidad4', '2024-06-25', '2024-03-10', false),
('Pedro', 'Hernández', 'Ruiz', 'Pasaporte', 78978978, '1995-01-30', 29, 'M', 'Modalidad5', '2024-06-25', '2024-02-25', true),
('Ana', 'González', 'Pérez', 'Cédula', 32132132, '1983-07-25', 40, 'F', 'Modalidad6', '2024-06-25', '2024-01-15', false),
('Luis', 'López', 'Ramírez', 'DNI', 65465465, '1972-12-14', 51, 'M', 'Modalidad7', '2024-06-25', '2023-12-10', true),
('Marta', 'Martínez', 'Hernández', 'Pasaporte', 98798798, '1988-09-09', 35, 'F', 'Modalidad8', '2024-06-25', '2023-11-20', true),
('José', 'Sánchez', 'González', 'Cédula', 45645678, '1992-04-18', 32, 'M', 'Modalidad9', '2024-06-25', '2023-10-30', true),
('Lucía', 'Ruiz', 'López', 'DNI', 12398712, '1981-03-22', 43, 'F', 'Modalidad10', '2024-06-25', '2023-09-25', false);


select * from abipam.beneficiado;

select * from abipam.pensiones;
