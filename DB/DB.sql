CREATE DATABASE  IF NOT EXISTS `backendpractica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `backendpractica`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: backendpractica
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `attention`
--

DROP TABLE IF EXISTS `attention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attention` (
  `attentionid` int NOT NULL AUTO_INCREMENT,
  `attention_status_statusid` int DEFAULT NULL,
  `attention_type_attention_typeid` varchar(3) DEFAULT NULL,
  `client_clientid` int DEFAULT NULL,
  `turn_turnid` int DEFAULT NULL,
  PRIMARY KEY (`attentionid`),
  KEY `FKrb9w494sn43soialmjuo5l5sc` (`attention_status_statusid`),
  KEY `FK616wavjiriaqsybt1mvet3ope` (`attention_type_attention_typeid`),
  KEY `FKilc78p8iicyb51jmhoyfruqqc` (`client_clientid`),
  KEY `FKbrv9v9optrc5m133kxk1twaoc` (`turn_turnid`),
  CONSTRAINT `FK616wavjiriaqsybt1mvet3ope` FOREIGN KEY (`attention_type_attention_typeid`) REFERENCES `attention_type` (`attentiontypeid`),
  CONSTRAINT `FKbrv9v9optrc5m133kxk1twaoc` FOREIGN KEY (`turn_turnid`) REFERENCES `turn` (`turnid`),
  CONSTRAINT `FKilc78p8iicyb51jmhoyfruqqc` FOREIGN KEY (`client_clientid`) REFERENCES `client` (`clientid`),
  CONSTRAINT `FKrb9w494sn43soialmjuo5l5sc` FOREIGN KEY (`attention_status_statusid`) REFERENCES `attention_status` (`statusid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention`
--

LOCK TABLES `attention` WRITE;
/*!40000 ALTER TABLE `attention` DISABLE KEYS */;
INSERT INTO `attention` VALUES (1,1,'AC',1,1);
/*!40000 ALTER TABLE `attention` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attention_status`
--

DROP TABLE IF EXISTS `attention_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attention_status` (
  `statusid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention_status`
--

LOCK TABLES `attention_status` WRITE;
/*!40000 ALTER TABLE `attention_status` DISABLE KEYS */;
INSERT INTO `attention_status` VALUES (1,'Activo'),(2,'Inactivo');
/*!40000 ALTER TABLE `attention_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attention_type`
--

DROP TABLE IF EXISTS `attention_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attention_type` (
  `attentiontypeid` varchar(3) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`attentiontypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention_type`
--

LOCK TABLES `attention_type` WRITE;
/*!40000 ALTER TABLE `attention_type` DISABLE KEYS */;
INSERT INTO `attention_type` VALUES ('AC','Atención al cliente'),('PS','Pago de servicio');
/*!40000 ALTER TABLE `attention_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cash`
--

DROP TABLE IF EXISTS `cash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cash` (
  `cashid` int NOT NULL AUTO_INCREMENT,
  `active` varchar(1) DEFAULT NULL,
  `cashdescription` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cashid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cash`
--

LOCK TABLES `cash` WRITE;
/*!40000 ALTER TABLE `cash` DISABLE KEYS */;
INSERT INTO `cash` VALUES (1,'A','CAJA 0001'),(2,'A','CAJA 0002'),(3,'A','CAJA 0003');
/*!40000 ALTER TABLE `cash` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `clientid` int NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `identification` varchar(13) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(13) DEFAULT NULL,
  `referencceaddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`clientid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'123 Main St, City City de mexico','johndoe@example.com','1234567890','Pamela','Lala a','0912345678','Near Park, City la ciduda de los angesle dd');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contractid` int NOT NULL AUTO_INCREMENT,
  `enddate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `client_clientid` int DEFAULT NULL,
  `methodpayment_methodpaymentid` int DEFAULT NULL,
  `service_serviceid` int DEFAULT NULL,
  `statuscontract_statusid` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`contractid`),
  KEY `FK6ot2cl8p1beyoeekihnydxpum` (`client_clientid`),
  KEY `FKl060cygwcgipciablt2vifu3t` (`methodpayment_methodpaymentid`),
  KEY `FKr746t47pv2eyv6dsubd2n9mjd` (`service_serviceid`),
  KEY `FK6yl5higfhusep04j8u12h58qh` (`statuscontract_statusid`),
  CONSTRAINT `FK6ot2cl8p1beyoeekihnydxpum` FOREIGN KEY (`client_clientid`) REFERENCES `client` (`clientid`),
  CONSTRAINT `FK6yl5higfhusep04j8u12h58qh` FOREIGN KEY (`statuscontract_statusid`) REFERENCES `statuscontract` (`statusid`),
  CONSTRAINT `FKl060cygwcgipciablt2vifu3t` FOREIGN KEY (`methodpayment_methodpaymentid`) REFERENCES `methodpayment` (`methodpaymentid`),
  CONSTRAINT `FKr746t47pv2eyv6dsubd2n9mjd` FOREIGN KEY (`service_serviceid`) REFERENCES `service` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'2024-12-01','2024-04-30',1,1,2,'SUS'),(2,'2024-12-01','2024-04-30',1,4,2,'SUS'),(3,'2024-12-01','2024-04-30',1,2,2,'RCO');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `deviceid` int NOT NULL AUTO_INCREMENT,
  `devicename` varchar(50) DEFAULT NULL,
  `service_serviceid` int DEFAULT NULL,
  PRIMARY KEY (`deviceid`),
  KEY `FKl4q8rc6e7ktwcswi20h0ajx5j` (`service_serviceid`),
  CONSTRAINT `FKl4q8rc6e7ktwcswi20h0ajx5j` FOREIGN KEY (`service_serviceid`) REFERENCES `service` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'Equipo 1',2),(2,'Equipo 2',2);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `methodpayment`
--

DROP TABLE IF EXISTS `methodpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `methodpayment` (
  `methodpaymentid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`methodpaymentid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `methodpayment`
--

LOCK TABLES `methodpayment` WRITE;
/*!40000 ALTER TABLE `methodpayment` DISABLE KEYS */;
INSERT INTO `methodpayment` VALUES (1,'Pagos con tarjeta de crédito o débito.'),(2,'Efectivo'),(3,'Domiciliación bancaria'),(4,'Transferencia automática'),(5,'Transferencias bancarias.'),(6,'Monederos digitales (como Apple Pay y Google Pay)'),(7,'Pagos con criptomonedas.'),(8,'Tarjetas regalo, tarjetas prepago');
/*!40000 ALTER TABLE `methodpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `paymentid` int NOT NULL AUTO_INCREMENT,
  `paymentdate` date DEFAULT NULL,
  `client_clientid` int DEFAULT NULL,
  PRIMARY KEY (`paymentid`),
  KEY `FKqg9iugt8nyde79wef9u9ry97p` (`client_clientid`),
  CONSTRAINT `FKqg9iugt8nyde79wef9u9ry97p` FOREIGN KEY (`client_clientid`) REFERENCES `client` (`clientid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,'2024-04-30',1);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `rol_id` int NOT NULL AUTO_INCREMENT,
  `rol_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Gestores'),(3,'Cajero');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `serviceid` int NOT NULL AUTO_INCREMENT,
  `price` varchar(10) DEFAULT NULL,
  `servicedescription` varchar(150) DEFAULT NULL,
  `servicename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'99.99','Descripción del servicio de prueba','Servicio de Prueba'),(2,'99.99','Descripción del servicio de prueba02','Servicio de Prueba02');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesion`
--

DROP TABLE IF EXISTS `sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sesion` (
  `id_sesion` int NOT NULL AUTO_INCREMENT,
  `cashid` int DEFAULT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `usuarios_id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_sesion`),
  KEY `FKcejpo7x90mklmn2l9cdak0ywl` (`usuarios_id_usuario`),
  CONSTRAINT `FKcejpo7x90mklmn2l9cdak0ywl` FOREIGN KEY (`usuarios_id_usuario`) REFERENCES `userr` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `sesion` WRITE;
/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;
INSERT INTO `sesion` VALUES (11,1,NULL,'2024-05-02',1);
/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statuscontract`
--

DROP TABLE IF EXISTS `statuscontract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statuscontract` (
  `statusid` varchar(3) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statuscontract`
--

LOCK TABLES `statuscontract` WRITE;
/*!40000 ALTER TABLE `statuscontract` DISABLE KEYS */;
INSERT INTO `statuscontract` VALUES ('CCO','Cancelación de Contrato'),('RCO','Renovacion de Contrato'),('SUS','Contrato sustituido'),('VIG','Contrato vigente');
/*!40000 ALTER TABLE `statuscontract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turn`
--

DROP TABLE IF EXISTS `turn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turn` (
  `turnid` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(7) DEFAULT NULL,
  `usergestorid` int DEFAULT NULL,
  `cash_cashid` int DEFAULT NULL,
  PRIMARY KEY (`turnid`),
  KEY `FKaw630keaa9gjwvtanpufrejjm` (`cash_cashid`),
  CONSTRAINT `FKaw630keaa9gjwvtanpufrejjm` FOREIGN KEY (`cash_cashid`) REFERENCES `cash` (`cashid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turn`
--

LOCK TABLES `turn` WRITE;
/*!40000 ALTER TABLE `turn` DISABLE KEYS */;
INSERT INTO `turn` VALUES (1,'2024-04-30','AC0001',3,1);
/*!40000 ALTER TABLE `turn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_status`
--

DROP TABLE IF EXISTS `user_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_status` (
  `statusid` varchar(3) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
INSERT INTO `user_status` VALUES ('A','Active'),('B','Bloqueado'),('I','Inactive');
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercash`
--

DROP TABLE IF EXISTS `usercash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usercash` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cash_cashid` int DEFAULT NULL,
  `user_userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9tl5yc1gpjrnow8d5ntox66i` (`cash_cashid`),
  KEY `FKds4dbf5kxpxbyy1k6osgdo7y9` (`user_userid`),
  CONSTRAINT `FKa9tl5yc1gpjrnow8d5ntox66i` FOREIGN KEY (`cash_cashid`) REFERENCES `cash` (`cashid`),
  CONSTRAINT `FKds4dbf5kxpxbyy1k6osgdo7y9` FOREIGN KEY (`user_userid`) REFERENCES `userr` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercash`
--

LOCK TABLES `usercash` WRITE;
/*!40000 ALTER TABLE `usercash` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercash` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userr`
--

DROP TABLE IF EXISTS `userr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userr` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `creationdate` date DEFAULT NULL,
  `dateapproval` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `userapproval` int DEFAULT NULL,
  `usercreate` int DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `rol_rolid` int DEFAULT NULL,
  `user_status_statusid` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `FK4boh1xrjj9ijc93peqv74i8bk` (`rol_rolid`),
  KEY `FK2p0tj9x9uqba6gfdi54jwgmpq` (`user_status_statusid`),
  CONSTRAINT `FK2p0tj9x9uqba6gfdi54jwgmpq` FOREIGN KEY (`user_status_statusid`) REFERENCES `user_status` (`statusid`),
  CONSTRAINT `FK4boh1xrjj9ijc93peqv74i8bk` FOREIGN KEY (`rol_rolid`) REFERENCES `rol` (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userr`
--

LOCK TABLES `userr` WRITE;
/*!40000 ALTER TABLE `userr` DISABLE KEYS */;
INSERT INTO `userr` VALUES (1,'2024-12-12','2024-12-12','edison@hotmail.com','123456',1,1,'Edison',1,'A');
/*!40000 ALTER TABLE `userr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-02 23:04:10
