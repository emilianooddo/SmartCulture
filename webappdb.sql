CREATE DATABASE  IF NOT EXISTS `webappdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `webappdb`;
-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: webappdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `friendship`
--

DROP TABLE IF EXISTS `friendship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendship` (
  `friendshipID` varchar(10) NOT NULL,
  `friend1` varchar(30) DEFAULT NULL,
  `friend2` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`friendshipID`),
  KEY `friend1_idx` (`friend1`),
  KEY `friend2_idx` (`friend2`),
  CONSTRAINT `friend1` FOREIGN KEY (`friend1`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `friend2` FOREIGN KEY (`friend2`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship`
--

LOCK TABLES `friendship` WRITE;
/*!40000 ALTER TABLE `friendship` DISABLE KEYS */;
/*!40000 ALTER TABLE `friendship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_location`
--

DROP TABLE IF EXISTS `list_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_location` (
  `user_loc` varchar(30) DEFAULT NULL,
  `loc_name` varchar(45) DEFAULT NULL,
  KEY `user_loc_idx` (`user_loc`),
  KEY `loc_name_idx` (`loc_name`),
  CONSTRAINT `loc_name` FOREIGN KEY (`loc_name`) REFERENCES `location` (`name_location`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_loc` FOREIGN KEY (`user_loc`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_location`
--

LOCK TABLES `list_location` WRITE;
/*!40000 ALTER TABLE `list_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `name_location` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `x_axis` varchar(20) NOT NULL,
  `y_axis` varchar(20) NOT NULL,
  PRIMARY KEY (`name_location`),
  UNIQUE KEY `name_location_UNIQUE` (`name_location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES ('Cappella Palatina','Palermo','Monumento','38.110927','13.353539'),('Cattedrale','Palermo','Chiesa','38.1146','13.356'),('Museo Archeologico Salinas','Palermo','Museo','38.1208','13.3603'),('Palazzina Cinese','Palermo','Monumento','38.167041','13.330349'),('Teatro Massimo','Palermo','Monumento','38.1203','13.3572'),('Teatro Politeama','Palermo','Monumento','38.1253','13.3567');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `idRequest` int(10) NOT NULL,
  `sender` varchar(30) DEFAULT NULL,
  `receiver` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idRequest`),
  KEY `sender_idx` (`sender`),
  KEY `receiver_idx` (`receiver`),
  CONSTRAINT `receiver` FOREIGN KEY (`receiver`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sender` FOREIGN KEY (`sender`) REFERENCES `user` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `name` varchar(40) NOT NULL,
  `surname` varchar(40) NOT NULL,
  `email` varchar(30) NOT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `birth` date DEFAULT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('eleonora','siragusa','ele.sira@gmail.com','female','elesiri','1996-08-30',NULL),('Emiliano','Oddo','emiliano.oddo@gmail.com','male','kingking','1993-05-26','photos/emi.jpg'),('cristina','ciulla','maria.cristina@libero.it','female','cricri','1990-06-01',NULL),('Sino','Patti','sinopatti@libero.it','male','devildevil','1993-10-28',NULL),('vito','oddo','vito@gmail.com','male','vitovito','1986-05-31',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-09  9:47:23
