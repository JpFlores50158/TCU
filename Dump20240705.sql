CREATE DATABASE  IF NOT EXISTS `abipam` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `abipam`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: abipam
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades` (
  `id_actividad` int NOT NULL AUTO_INCREMENT,
  `organizacion` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `tipo_actividad` varchar(50) NOT NULL,
  `ninos_0_5` int NOT NULL,
  `ninos_5_12` int NOT NULL,
  `adolescentes` int NOT NULL,
  `adulto_hombre` int NOT NULL,
  `adulto_mujer` int NOT NULL,
  `personas_mayores_65` int NOT NULL,
  PRIMARY KEY (`id_actividad`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
INSERT INTO `actividades` VALUES (1,'1','2024-07-10','socialización',14,2,0,25,0,0),(3,'2','2024-07-03','prevención violencia',2,10,0,0,0,0),(4,'3','2024-07-04','apoyo emocional',0,0,0,50,29,0),(5,'3','2024-07-04','capacitación',0,0,0,0,0,60),(6,'4','2024-07-11','emprendedurismo',3,3,2,0,0,0),(7,'5','2024-07-04','emprendedurismo',3,0,2,1,0,85);
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ayuda`
--

DROP TABLE IF EXISTS `ayuda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ayuda` (
  `id_ayuda` int NOT NULL AUTO_INCREMENT,
  `id_beneficiado` int NOT NULL,
  `alimentacion` decimal(15,2) NOT NULL,
  `articulos_uso_personal_higiene` decimal(15,2) NOT NULL,
  `atencion_social_salud_integral` decimal(15,2) NOT NULL,
  `productos_apoyo_ayudas_tecnicas` decimal(15,2) NOT NULL,
  `equipamiento_casa` decimal(15,2) NOT NULL,
  `alquiler_vivienda_servicios_basicos` decimal(15,2) NOT NULL,
  `familias_solidarias` decimal(15,2) NOT NULL,
  `asistente_domiciliar` decimal(15,2) NOT NULL,
  `ley7972_monto_ayuda` decimal(15,2) NOT NULL,
  `ley9188_monto_ayuda` decimal(15,2) NOT NULL,
  `fecha` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_ayuda`),
  KEY `id_beneficiado` (`id_beneficiado`),
  CONSTRAINT `ayuda_ibfk_1` FOREIGN KEY (`id_beneficiado`) REFERENCES `beneficiado` (`id_beneficiado`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ayuda`
--

LOCK TABLES `ayuda` WRITE;
/*!40000 ALTER TABLE `ayuda` DISABLE KEYS */;
INSERT INTO `ayuda` VALUES (1,1,55932.95,4694.75,31200.00,0.00,0.00,0.00,50000.00,0.00,0.00,141827.70,'2024-07-04',1),(2,2,0.00,0.00,40000.00,0.00,0.00,140000.00,0.00,0.00,0.00,180000.00,'2024-07-04',1),(3,3,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(4,4,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(5,5,58899.93,4694.75,0.00,40298.50,0.00,0.00,0.00,0.00,0.00,103893.18,'2024-07-04',1),(6,6,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(7,7,18213.60,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,18213.60,'2024-07-04',1),(8,8,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(9,9,55932.95,4694.75,0.00,0.00,0.00,135000.00,0.00,0.00,0.00,195627.70,'2024-07-04',1),(10,10,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(11,11,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(12,12,55932.95,4694.75,0.00,0.00,0.00,0.00,51200.00,0.00,0.00,111827.70,'2024-07-04',1),(13,13,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(14,14,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(15,15,58899.93,4694.75,0.00,45090.00,0.00,0.00,0.00,0.00,0.00,108684.68,'2024-07-04',1),(16,16,0.00,0.00,0.00,22545.00,0.00,0.00,0.00,0.00,0.00,22545.00,'2024-07-04',1),(17,17,58899.93,4694.75,0.00,20148.75,0.00,100000.00,0.00,0.00,0.00,183743.43,'2024-07-04',1),(18,18,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(19,19,58899.93,4694.75,41600.00,0.00,0.00,0.00,0.00,0.00,0.00,105194.68,'2024-07-04',1),(20,20,0.00,0.00,0.00,0.00,0.00,151200.00,0.00,0.00,0.00,151200.00,'2024-07-04',1),(21,21,55932.95,4694.75,0.00,0.00,0.00,140000.00,25000.00,0.00,0.00,225627.70,'2024-07-04',1),(22,22,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(23,23,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(24,24,58899.93,4694.75,41600.00,22545.00,0.00,0.00,0.00,0.00,0.00,127739.68,'2024-07-04',1),(25,25,55932.95,4694.75,0.00,0.00,0.00,140000.00,0.00,0.00,0.00,200627.70,'2024-07-04',1),(26,26,0.00,0.00,0.00,0.00,0.00,0.00,51200.00,0.00,0.00,51200.00,'2024-07-04',1),(27,27,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(28,28,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(29,29,55932.95,4694.75,0.00,0.00,0.00,16050.00,0.00,0.00,0.00,76677.70,'2024-07-04',1),(30,30,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(31,31,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(32,32,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(33,33,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(34,34,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(35,35,58899.93,4694.75,0.00,40298.50,0.00,0.00,0.00,0.00,0.00,103893.18,'2024-07-04',1),(36,36,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(37,37,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(38,38,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(39,39,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(40,40,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(41,41,55932.95,4694.75,0.00,22545.00,0.00,0.00,0.00,0.00,0.00,83172.70,'2024-07-04',1),(42,42,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(43,43,0.00,0.00,0.00,22545.00,0.00,0.00,0.00,0.00,0.00,22545.00,'2024-07-04',1),(44,44,58899.93,4694.75,0.00,0.00,0.00,40000.00,0.00,0.00,0.00,103594.68,'2024-07-04',1),(45,45,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(46,46,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(47,47,0.00,0.00,40000.00,0.00,0.00,76200.00,0.00,0.00,0.00,116200.00,'2024-07-04',1),(48,48,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(49,49,83977.08,4694.75,0.00,22545.00,0.00,0.00,0.00,0.00,0.00,111216.83,'2024-07-04',1),(50,50,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(51,51,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(52,52,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(53,53,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(54,54,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(55,55,55932.95,4694.75,0.00,0.00,0.00,150000.00,0.00,0.00,0.00,210627.70,'2024-07-04',1),(56,56,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(57,57,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(58,58,47887.13,0.00,0.00,40298.50,0.00,0.00,0.00,0.00,0.00,88185.63,'2024-07-04',1),(59,59,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(60,60,58899.93,4694.75,0.00,45090.00,0.00,0.00,0.00,0.00,0.00,108684.68,'2024-07-04',1),(61,61,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(62,62,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(63,63,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(64,64,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(65,65,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(66,66,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(67,67,58899.93,4694.75,0.00,45090.00,0.00,0.00,0.00,0.00,0.00,108684.68,'2024-07-04',1),(68,68,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(69,69,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(70,70,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(71,71,58899.93,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,63594.68,'2024-07-04',1),(72,72,55932.95,4694.75,0.00,20148.75,0.00,0.00,0.00,0.00,0.00,80776.45,'2024-07-04',1),(73,73,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(74,74,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(75,75,55932.95,4694.75,31200.00,0.00,0.00,50000.00,0.00,0.00,0.00,141827.70,'2024-07-04',1),(76,76,0.00,0.00,40000.00,0.00,0.00,151200.00,0.00,0.00,0.00,191200.00,'2024-07-04',1),(77,77,55932.95,4694.75,31200.00,0.00,0.00,0.00,0.00,0.00,0.00,91827.70,'2024-07-04',1),(78,78,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(79,79,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(80,80,81010.10,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,85704.85,'2024-07-04',1),(81,81,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(82,82,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(83,83,0.00,0.00,0.00,0.00,0.00,150000.00,0.00,0.00,0.00,150000.00,'2024-07-04',1),(84,84,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(85,85,58899.93,4694.75,0.00,30060.00,0.00,0.00,0.00,0.00,0.00,93654.68,'2024-07-04',1),(86,86,55932.95,4694.75,0.00,0.00,0.00,0.00,0.00,0.00,0.00,60627.70,'2024-07-04',1),(87,87,55932.95,4694.75,0.00,0.00,0.00,150000.00,0.00,0.00,0.00,210627.70,'2024-07-04',1),(88,88,81010.10,4694.75,0.00,45090.00,0.00,0.00,0.00,0.00,0.00,130794.85,'2024-07-04',1),(89,89,55932.95,4694.75,31200.00,45090.00,0.00,0.00,0.00,0.00,0.00,136917.70,'2024-07-04',1),(90,90,0.00,0.00,60000.00,0.00,0.00,0.00,0.00,0.00,0.00,60000.00,'2024-07-04',1),(91,91,0.00,0.00,60000.00,0.00,0.00,0.00,0.00,0.00,0.00,60000.00,'2024-07-04',1),(92,92,0.00,0.00,60000.00,0.00,0.00,0.00,0.00,0.00,0.00,60000.00,'2024-07-04',1),(93,93,0.00,0.00,60000.00,0.00,0.00,0.00,0.00,0.00,0.00,60000.00,'2024-07-04',1),(94,94,0.00,0.00,40000.00,0.00,0.00,0.00,0.00,0.00,0.00,40000.00,'2024-07-04',1);
/*!40000 ALTER TABLE `ayuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beneficiado`
--

DROP TABLE IF EXISTS `beneficiado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beneficiado` (
  `id_beneficiado` int NOT NULL AUTO_INCREMENT,
  `nombre_1` varchar(50) NOT NULL,
  `apellido_1` varchar(50) NOT NULL,
  `apellido_2` varchar(50) NOT NULL,
  `tipo_identificacion` varchar(50) NOT NULL,
  `num_identificacion` bigint NOT NULL,
  `fecha_nac` date NOT NULL,
  `edad` int NOT NULL,
  `sexo` char(1) NOT NULL,
  `modalidad` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `ultima_valoracion` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_beneficiado`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficiado`
--

LOCK TABLES `beneficiado` WRITE;
/*!40000 ALTER TABLE `beneficiado` DISABLE KEYS */;
INSERT INTO `beneficiado` VALUES (1,'SALVADORA DE LOS SANTOS','ABARCA','URENA','Cedula',601010795,'1952-04-10',72,'H','Red de Cuido','2024-07-04','2024-07-04',1),(2,'MIGUEL ANGEL DE JESUS','ALFARO','BARRANTES','Cedula',900090367,'1938-09-06',85,'H','Red de Cuido','2024-07-04','2024-07-04',1),(3,'ANA ISABEL DE LA ASUNCION','FONSECA','ANGULO','Cedula',900370258,'1950-08-15',73,'M','Red de Cuido','2024-07-04','2024-07-04',1),(4,'ARACELLY','JIMENEZ','QUESADA','Cedula',102640493,'1938-07-11',85,'M','Red de Cuido','2024-07-04','2024-07-04',1),(5,'LUZ','ARAYA','CHAVARRIA','Cedula',202160392,'1942-05-01',82,'M','Red de Cuido','2024-07-04','2024-07-04',1),(6,'VERA VIOLETA','ARIAS','OROZCO','Cedula',104580975,'1955-12-20',68,'M','Red de Cuido','2024-07-04','2024-07-04',1),(7,'RAFAEL ANGEL','BENAVIDES','ZAMORA','Cedula',202270715,'1944-01-12',80,'H','Red de Cuido','2024-07-04','2024-07-04',1),(8,'HAYDEE','BERMUDEZ','ALVARADO','Cedula',103690192,'1948-12-15',75,'M','Red de Cuido','2024-07-04','2024-07-04',1),(9,'HERBERT FRANCISCO','CAMPOS','VARGAS','Cedula',401010870,'1951-01-23',73,'H','Red de Cuido','2024-07-04','2024-07-04',1),(10,'XENIA','CASTRO','MORALES','Cedula',202670965,'1949-09-12',74,'M','Red de Cuido','2024-07-04','2024-07-04',1),(11,'BLANCA ROSA','CHAVES','MONTERO','Cedula',201990006,'1939-07-06',84,'M','Red de Cuido','2024-07-04','2024-07-04',1),(12,'TRINIDAD','CORDERO','JIMENEZ','Cedula',201290385,'1926-03-19',98,'M','Red de Cuido','2024-07-04','2024-07-04',1),(13,'MIGUEL ANGEL','CORNEJO','GARCIA','Residencia',122200721332,'1936-09-29',87,'H','Red de Cuido','2024-07-04','2024-07-04',1),(14,'FELIX','CORTES','QUESADA','Cedula',201850977,'1937-01-24',87,'H','Red de Cuido','2024-07-04','2024-07-04',1),(15,'MARIA CRISTINA','RIVERA','LEDEZMA','Cedula',202530569,'1947-08-04',76,'M','Red de Cuido','2024-07-04','2024-07-04',1),(16,'VITALINA','DELGADO','SANCHEZ','Cedula',102890346,'1941-04-05',83,'M','Red de Cuido','2024-07-04','2024-07-04',1),(17,'EMILIANA','DIAZ','GOMEZ','Cedula',600530697,'1939-11-12',84,'M','Red de Cuido','2024-07-04','2024-07-04',1),(18,'MARIA EDITH','ALVARADO','MURILLO','Cedula',401010595,'1951-08-18',72,'M','Red de Cuido','2024-07-04','2024-07-04',1),(19,'EDITH','BARRANTES','MORA','Cedula',103400214,'1946-07-10',77,'M','Red de Cuido','2024-07-04','2024-07-04',1),(20,'EDUARDO ANTONIO DE LA TRINIDAD','PALMA','SOLIS','Cedula',400940558,'1948-03-02',76,'H','Red de Cuido','2024-07-04','2024-07-04',1),(21,'EDUARDO EMILIO','RODRIGUEZ','ARIAS','Cedula',202180691,'1942-07-07',81,'H','Red de Cuido','2024-07-04','2024-07-04',1),(22,'EDWIN GONZALO DE LA TRINIDAD','MORA','MARIN','Cedula',601230706,'1956-03-15',68,'H','Red de Cuido','2024-07-04','2024-07-04',1),(23,'EDWIN GERARDO','SANDI','CARVAJAL','Cedula',104150684,'1953-08-15',70,'H','Red de Cuido','2024-07-04','2024-07-04',1),(24,'ELIZABETH GERARDA DE TRINIDAD','CHAVERRI','JIMENEZ','Cedula',501760251,'1958-01-18',66,'M','Red de Cuido','2024-07-04','2024-07-04',1),(25,'ASDRUBAL GERARDO','ESPINOZA','CONEJO','Cedula',401061078,'1954-07-18',69,'H','Red de Cuido','2024-07-04','2024-07-04',1),(26,'EUGENIA','FONSECA','MARTINEZ','Cedula',102300981,'1933-12-26',90,'M','Red de Cuido','2024-07-04','2024-07-04',1),(27,'FABIO MAMERTO PABLO','ZUNIGA','VILLARREAL','Cedula',501050856,'1940-05-11',84,'H','Red de Cuido','2024-07-04','2024-07-04',1),(28,'SANTOS ANGEL','FAGERSON','MORALES','Residencia',155803527735,'1951-10-02',72,'H','Red de Cuido','2024-07-04','2024-07-04',1),(29,'FRANK GERARDO','FALLAS','PORTUGUEZ','Cedula',401030409,'1952-08-29',71,'H','Red de Cuido','2024-07-04','2024-07-04',1),(30,'FLOR DE MARIA','RODRIGUEZ','ALPIZAR','Cedula',104041239,'1952-07-13',71,'M','Red de Cuido','2024-07-04','2024-07-04',1),(31,'ELISA','CHAVES','FONSECA','Cedula',102170420,'1932-07-03',92,'M','Red de Cuido','2024-07-04','2024-07-04',1),(32,'CARLOS LUIS','FUENTES','MONGE','Cedula',301590413,'1932-12-28',91,'H','Red de Cuido','2024-07-04','2024-07-04',1),(33,'GLADYS MARIA DE LOS ANGELES','SOLIS','MIRANDA','Cedula',401100892,'1955-11-03',68,'M','Red de Cuido','2024-07-04','2024-07-04',1),(34,'GERARDO ANTONIO DE LA TRINIDAD','GOMEZ','ESPINOZA','Cedula',401031487,'1953-02-27',71,'H','Red de Cuido','2024-07-04','2024-07-04',1),(35,'JAVIER','GOMEZ','JIMENEZ','Cedula',102500970,'1936-10-05',87,'H','Red de Cuido','2024-07-04','2024-07-04',1),(36,'SANTOS','GOMEZ','MATARRITA','Cedula',501260036,'1948-10-26',75,'M','Red de Cuido','2024-07-04','2024-07-04',1),(37,'JOSE ANTONIO','GONZALEZ','BARQUERO','Cedula',202160196,'1942-05-11',82,'H','Red de Cuido','2024-07-04','2024-07-04',1),(38,'MERCEDES DEL CARMEN','GONZALEZ','GONZALEZ','Residencia',155809664506,'1947-05-16',77,'M','Red de Cuido','2024-07-04','2024-07-04',1),(39,'REYNALDO MICHELL','GRAHAM','DAWES','Cedula',900510592,'1951-09-28',72,'H','Red de Cuido','2024-07-04','2024-07-04',1),(40,'IRENE','GRANADOS','CORTES','Cedula',301760144,'1948-06-08',76,'M','Red de Cuido','2024-07-04','2024-07-04',1),(41,'GUILLERMO','MILANES','ENRIQUEZ','Cedula',103210153,'1944-06-21',80,'H','Red de Cuido','2024-07-04','2024-07-04',1),(42,'JEANNETTE FATIMA','HERRERA','RIVERA','Cedula',401000243,'1950-11-14',73,'M','Red de Cuido','2024-07-04','2024-07-04',1),(43,'IDALIA ZENEIDA DE LA TRINIDAD','KIDD','ALVAREZ','Cedula',400690328,'1934-03-01',90,'M','Red de Cuido','2024-07-04','2024-07-04',1),(44,'ANA','JARQUIN','MENDOZA','Residencia',155804488427,'1954-03-16',70,'M','Red de Cuido','2024-07-04','2024-07-04',1),(45,'ANTONIA IRENE','JIMENEZ','GOMEZ','Cedula',900720388,'1950-04-27',74,'M','Red de Cuido','2024-07-04','2024-07-04',1),(46,'FLERIDA MARGARITA','JIMENEZ','LOBO','Cedula',102900044,'1941-10-28',82,'M','Red de Cuido','2024-07-04','2024-07-04',1),(47,'CLAUDIA','JIMENEZ','OBALDIA','Cedula',103160651,'1944-06-02',80,'M','Red de Cuido','2024-07-04','2024-07-04',1),(48,'CAYETANO JOSE','LOPEZ','CASTELLON','Residencia',155808146326,'1956-08-07',67,'H','Red de Cuido','2024-07-04','2024-07-04',1),(49,'LUZ MARIA','CALVO','SANDI','Cedula',102630442,'1940-05-11',84,'M','Red de Cuido','2024-07-04','2024-07-04',1),(50,'MARIA AMABLE DEL SOCORRO','HERNANDEZ','VARGAS','Cedula',401040137,'1952-03-05',72,'M','Red de Cuido','2024-07-04','2024-07-04',1),(51,'MARIA AUXILIADORA','CASTRO','AGUILAR','Cedula',400730369,'1936-08-17',87,'M','Red de Cuido','2024-07-04','2024-07-04',1),(52,'MARIA CARMELA','RIVERA','CASCANTE','Cedula',301800259,'1949-04-30',75,'M','Red de Cuido','2024-07-04','2024-07-04',1),(53,'MARIA CECILIA DEL SOCORRO','ALFARO','ALVARADO','Cedula',900210346,'1939-03-13',85,'M','Red de Cuido','2024-07-04','2024-07-04',1),(54,'MARIA DE LOS ANGELES','MORA','VINDAS','Cedula',102920806,'1941-08-25',82,'M','Red de Cuido','2024-07-04','2024-07-04',1),(55,'MARIA ELENA','OBREGON','NORORI','Cedula',800790554,'1953-08-20',70,'M','Red de Cuido','2024-07-04','2024-07-04',1),(56,'MARIA ISABEL DEL SOCORRO','GUZMAN','SOLANO','Cedula',501040030,'1943-10-10',80,'M','Red de Cuido','2024-07-04','2024-07-04',1),(57,'MARIA JULIA','RAMIREZ','AGUILAR','Cedula',800690028,'1947-06-23',77,'M','Red de Cuido','2024-07-04','2024-07-04',1),(58,'MARIA LUISA','MENDEZ','ZUNIGA','Cedula',103090443,'1943-07-12',80,'M','Red de Cuido','2024-07-04','2024-07-04',1),(59,'MARIA OLGA','ESPINOZA','MATARRITA','Cedula',500980264,'1942-05-03',82,'M','Red de Cuido','2024-07-04','2024-07-04',1),(60,'MARIA TERESA','GUEVARA','VIQUEZ','Cedula',301370029,'1939-03-22',85,'M','Red de Cuido','2024-07-04','2024-07-04',1),(61,'ADELAIDA','MARIN','LORIA','Cedula',202881326,'1953-04-28',71,'M','Red de Cuido','2024-07-04','2024-07-04',1),(62,'GERARDA JULIETA','MAROTO','CHACON','Cedula',202730728,'1950-06-12',74,'M','Red de Cuido','2024-07-04','2024-07-04',1),(63,'JUDITH CORINA','MARTINEZ','MENESES','Cedula',301640880,'1945-12-06',78,'M','Red de Cuido','2024-07-04','2024-07-04',1),(64,'VENANCIA','MUNOZ','GONZALEZ','Cedula',800550777,'1951-05-18',73,'M','Red de Cuido','2024-07-04','2024-07-04',1),(65,'NOEMY','SIBAJA','PORRAS','Cedula',202821353,'1951-12-16',72,'M','Red de Cuido','2024-07-04','2024-07-04',1),(66,'GERARDO','OBANDO','SANCHEZ','Cedula',900490534,'1950-07-22',73,'H','Red de Cuido','2024-07-04','2024-07-04',1),(67,'MARTA LORENZA DEL CARMEN','OROZCO','VIQUEZ','Cedula',400640993,'1931-08-10',92,'M','Red de Cuido','2024-07-04','2024-07-04',1),(68,'JULIETA MARIA DE LOS ANGELES','OVIEDO','SANCHEZ','Cedula',401090707,'1955-08-11',68,'M','Red de Cuido','2024-07-04','2024-07-04',1),(69,'MARIA PAULINA VILMA','PALACIOS','ALVARADO','Cedula',500970610,'1942-06-21',82,'M','Red de Cuido','2024-07-04','2024-07-04',1),(70,'MERCEDES MARIA DEL CARMEN','RAMIREZ','CAMPOS','Cedula',400990980,'1950-09-24',73,'M','Red de Cuido','2024-07-04','2024-07-04',1),(71,'RENE JUVENAL DE JESUS','BUSTOS','BUSTOS','Cedula',501180337,'1947-04-23',77,'H','Red de Cuido','2024-07-04','2024-07-04',1),(72,'FLORENCIO DANIEL','RODRIGUEZ','SANTANA','Cedula',500920810,'1941-01-03',83,'H','Red de Cuido','2024-07-04','2024-07-04',1),(73,'HANNIA DIANELL','RODRIGUEZ','LOGHAN','Cedula',700460885,'1951-01-09',73,'M','Red de Cuido','2024-07-04','2024-07-04',1),(74,'RAFAEL ANGEL DEL SOCORRO','ROJAS','SANCHEZ','Cedula',400910676,'1946-10-25',77,'H','Red de Cuido','2024-07-04','2024-07-04',1),(75,'LEONARDO ANTONIO','ROQUE','CACERES','Residencia',155811802602,'1951-11-06',72,'H','Red de Cuido','2024-07-04','2024-07-04',1),(76,'ROSA CRUZ','PENA','ACOSTA','Cedula',600840071,'1948-09-14',75,'M','Red de Cuido','2024-07-04','2024-07-04',1),(77,'ROSA ESMERALDA','BENDANA','CATON','Cedula',801470912,'1957-06-28',67,'M','Red de Cuido','2024-07-04','2024-07-04',1),(78,'ROSA MARIA','VILLALOBOS','BARQUERO','Cedula',202590492,'1948-06-05',76,'M','Red de Cuido','2024-07-04','2024-07-04',1),(79,'ROSARIO','PEREIRA','ACUNA','Cedula',301650641,'1946-02-19',78,'M','Red de Cuido','2024-07-04','2024-07-04',1),(80,'FERNANDO','SABORIO','GONZALEZ','Cedula',102550325,'1956-05-20',68,'H','Red de Cuido','2024-07-04','2024-07-04',1),(81,'DORA EMILIA','SALAZAR','SALAS','Cedula',301941259,'1952-09-01',71,'M','Red de Cuido','2024-07-04','2024-07-04',1),(82,'LUIS FERNANDO','SANCHEZ','CAMPOS','Cedula',400880009,'1942-04-01',82,'H','Red de Cuido','2024-07-04','2024-07-04',1),(83,'LUISA MAYELA DEL CARMEN','SANCHEZ','OROZCO','Cedula',401051067,'1954-01-21',70,'M','Red de Cuido','2024-07-04','2024-07-04',1),(84,'SILVIA','QUESADA','CESPEDES','Cedula',203350554,'1958-10-22',65,'M','Red de Cuido','2024-07-04','2024-07-04',1),(85,'JOSE EFRAIN','SOLANO','SOLANO','Cedula',301360096,'1939-01-02',85,'H','Red de Cuido','2024-07-04','2024-07-04',1),(86,'LIGIA ADITA DEL CARMEN','UGALDE','PORRAS','Cedula',202610376,'1948-06-30',76,'M','Red de Cuido','2024-07-04','2024-07-04',1),(87,'DORA EMILIA','VALVERDE','CHINCHILLA','Cedula',103680145,'1949-01-20',75,'M','Red de Cuido','2024-07-04','2024-07-04',1),(88,'JACOBA ANTONIA','VIDES','MENJIVAR','Residencia',122201068731,'1931-12-08',92,'M','Red de Cuido','2024-07-04','2024-07-04',1),(89,'ESTER DEL SOCORRO','VILLEGAS','MENA','Cedula',900450050,'1949-06-03',75,'M','Red de Cuido','2024-07-04','2024-07-04',1),(90,'BELLA ELISA','BLANCO','HERRERA','Cedula',202350103,'1945-04-04',79,'M','Red de Cuido','2024-07-04','2024-07-04',1),(91,'MARIA ELENA','ARIAS','SOSA','Cedula',501350719,'1950-08-31',73,'M','Red de Cuido','2024-07-04','2024-07-04',1),(92,'ANTONIO','MEZA','OLIVARES','Cedula',103070095,'1943-06-05',81,'H','Red de Cuido','2024-07-04','2024-07-04',1),(93,'JORGE MANUEL ISAIAS','ARAYA','SALAS','Cedula',400870901,'1944-11-07',79,'H','Red de Cuido','2024-07-04','2024-07-04',1),(94,'JOSE LUIS','RAMIREZ','RAMIREZ','Cedula',301210752,'1935-05-06',89,'H','Red de Cuido','2024-07-04','2024-07-04',1);
/*!40000 ALTER TABLE `beneficiado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_espera`
--

DROP TABLE IF EXISTS `lista_espera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_espera` (
  `id_lista_espera` int NOT NULL AUTO_INCREMENT,
  `primer_apellido` varchar(50) NOT NULL,
  `segundo_apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `no_cedula` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `canton` varchar(50) NOT NULL,
  `distrito` varchar(50) NOT NULL,
  `direccion` text NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `descripcion_problema` text NOT NULL,
  `prioridad` int NOT NULL,
  `fuente` varchar(50) NOT NULL,
  `edad` int NOT NULL,
  `notificado_posicion_lista_espera` varchar(50) NOT NULL,
  `observacion` text NOT NULL,
  `sinirubre_estado_justificacion` text NOT NULL,
  PRIMARY KEY (`id_lista_espera`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_espera`
--

LOCK TABLES `lista_espera` WRITE;
/*!40000 ALTER TABLE `lista_espera` DISABLE KEYS */;
INSERT INTO `lista_espera` VALUES (2,'FLORES','MUNOZ','JOSE PABLO','118850158','2003-09-09','Heredia','Central','1','1','1','2024-04-18','1',0,'1',20,'Si','1','Personas no pobres'),(3,'FLORES','MUNOZ','JOSE PABLO','118850158','2024-05-31','Heredia','Santa Bárbara','1','1','1','2024-07-02','1',0,'1',0,'1','1','Pasada a beneficiado'),(4,'MUNOZ','CHACON','IVANNIA DE LA TRINIDAD','107840070','1970-10-08','Heredia','Barva','1','1','1','2024-07-03','1',0,'1',53,'Si','1','Pasada a beneficiado'),(5,'OROZCO','LOPEZ','KENNY ALEJANDRO','118850157','2004-03-03','Heredia','San Rafael','2','2','2','2024-07-03','2',0,'2',20,'Si','2','Pasada a beneficiado'),(6,'CASTRO','CAMPOS','MARIA VIRGITA','202700850','1980-01-01','Heredia','San Isidro','1','1','1','2024-07-03','1',0,'1',44,'Si','1','Personas vulnerables');
/*!40000 ALTER TABLE `lista_espera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pensiones`
--

DROP TABLE IF EXISTS `pensiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pensiones` (
  `id_pension` int NOT NULL AUTO_INCREMENT,
  `id_beneficiado` int NOT NULL,
  `t_pension` varchar(50) NOT NULL,
  `mont_pension` decimal(10,2) NOT NULL,
  `ley9188_est_actual_activo` tinyint(1) NOT NULL,
  `ley7972_est_actual_activo` tinyint(1) NOT NULL,
  `tipo_ingre_fallec` varchar(50) NOT NULL,
  `fecha_ingr_fallec` date NOT NULL,
  `mes_lista` date NOT NULL,
  `fiscalizador` varchar(50) NOT NULL,
  `sinerube` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_pension`),
  KEY `id_beneficiado` (`id_beneficiado`),
  CONSTRAINT `pensiones_ibfk_1` FOREIGN KEY (`id_beneficiado`) REFERENCES `beneficiado` (`id_beneficiado`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pensiones`
--

LOCK TABLES `pensiones` WRITE;
/*!40000 ALTER TABLE `pensiones` DISABLE KEYS */;
INSERT INTO `pensiones` VALUES (1,1,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(2,2,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(3,3,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(4,4,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(5,5,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(6,6,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(7,7,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(8,8,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(9,9,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(10,10,'VIUDEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(11,11,'Ministerio de Trabajo / POR MUERTE',279230.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(12,12,'POR INVALIDEZ-VEJEZ Y MUERTE',155995.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(13,13,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(14,14,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(15,15,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(16,16,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(17,17,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(18,18,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(19,19,'INVALIDEZ RNC/PCP',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(20,20,'PENSION ANTICIPADA CON MONTO REDUCIDO POR VEJEZ',142517.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(21,21,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(22,22,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(23,23,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(24,24,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(25,25,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(26,26,'POR MUERTE',142517.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(27,27,'VEJEZ',142517.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(28,28,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(29,29,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(30,30,'PENSION POR MUERTE',99761.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(31,31,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(32,32,'POR INVALIDEZ',142517.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(33,33,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(34,34,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(35,35,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(36,36,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(37,37,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(38,38,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(39,39,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(40,40,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(41,41,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(42,42,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(43,43,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(44,44,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(45,45,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(46,46,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(47,47,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(48,48,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(49,49,'Invalidez y beneficio F.R.A.P.',149716.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(50,50,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(51,51,'INDIGENTES RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(52,52,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(53,53,'INVALIDEZ RNC/PCP',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(54,54,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(55,55,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(56,56,'INDIGENTES RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(57,57,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(58,58,'POR MUERTE',99761.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(59,59,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(60,60,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(61,61,'VIUDEZ RNC',142517.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(62,62,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(63,63,'VEJEZ REDUCIDA',142517.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(64,64,'POR MUERTE',99761.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(65,65,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(66,66,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(67,67,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(68,68,'POR INVALIDEZ-VEJEZ Y MUERTE',155995.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(69,69,'PENSION POR VEJEZ',142517.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(70,70,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(71,71,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(72,72,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(73,73,'POR INVALIDEZ-VEJEZ Y MUERTE',164277.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(74,74,'INVALIDEZ RNC/PCP',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(75,75,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(76,76,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(77,77,'POR MUERTE',99761.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(78,78,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(79,79,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(80,80,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(81,81,'PENSION POR VEJEZ',150249.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(82,82,'JUPEMA',217172.96,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(83,83,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(84,84,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(85,85,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(86,86,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(87,87,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(88,88,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(89,89,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(90,90,'VEJEZ RNC',82000.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(91,91,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(92,92,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(93,93,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1),(94,94,'NO TIENE',0.00,1,0,'Ingresado','2024-07-04','2024-07-04','Hellen','N/A',1);
/*!40000 ALTER TABLE `pensiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id_rol` bigint NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(50) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nombre_usuario` varchar(50) DEFAULT NULL,
  `primer_apellido` varchar(50) DEFAULT NULL,
  `segundo_apellido` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `id_rol` bigint DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Luis','Núñez','Chacón','luis@gmail.com','7894-8596',0,1),(2,'Usuario','$2a$10$VsW/24JbzK4j4vm4hoPJg.p6BlLYX6FZXhoDffSkjbw3dD7mlaw66','erick','Rivera','Prado','erick@gmail.com','7894-6845',0,2),(4,'1','$2a$10$jyOUEkiJN07e0XXen03u.uQO8Crv12hDhwcrwPnaLja9TCyj8e3Om','1','1','1','1@1.com','1',0,2),(5,'2','$2a$10$bxKuEdswNj71vHVJVxsze.IYeyiyUlmaIWmam1y/0DSz9nlxrS/FO','2','2','2','2@2.com','2',0,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'abipam'
--
/*!50003 DROP PROCEDURE IF EXISTS `grafico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `grafico`()
BEGIN
   SELECT 
        CONCAT(b.nombre_1, ' ', b.apellido_1, ' ', b.apellido_2) AS Nombre_completo,
        b.num_identificacion AS cedula,
        COALESCE(a.ley9188_monto_ayuda, 0) AS monto_ayuda
    FROM ABIPAM.beneficiado b
    LEFT JOIN ABIPAM.ayuda a ON b.id_beneficiado = a.id_beneficiado;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PromedioEdadDecada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PromedioEdadDecada`()
BEGIN
   SELECT
    FLOOR(edad / 10) * 10 AS decada,
    COUNT(*) AS cantidad_beneficiados,
    ROUND((COUNT(*) / (SELECT COUNT(*) FROM ABIPAM.beneficiado)) * 100, 2) AS porcentaje
FROM
    ABIPAM.beneficiado
GROUP BY
    FLOOR(edad / 10)
ORDER BY
    decada;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-05  0:35:02
