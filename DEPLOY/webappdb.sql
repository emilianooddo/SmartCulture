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
  `idFriendship` int(10) NOT NULL AUTO_INCREMENT,
  `friend1` varchar(30) DEFAULT NULL,
  `friend2` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idFriendship`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship`
--

LOCK TABLES `friendship` WRITE;
/*!40000 ALTER TABLE `friendship` DISABLE KEYS */;
INSERT INTO `friendship` VALUES (87,'vito.oddo','emiliano.oddo'),(88,'sino.patti','vito.oddo'),(90,'sino.patti','emiliano.oddo'),(91,'emiliano.oddo','maria.livorno'),(92,'emiliano.oddo','riccardo.corleo'),(93,'silvia.randazzo','riccardo.corleo');
/*!40000 ALTER TABLE `friendship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_location`
--

DROP TABLE IF EXISTS `list_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_location` (
  `idList` int(10) NOT NULL AUTO_INCREMENT,
  `user_loc` varchar(30) DEFAULT NULL,
  `loc_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idList`),
  KEY `loc_name_idx` (`loc_name`),
  KEY `user_loc_idx` (`user_loc`),
  CONSTRAINT `loc_name` FOREIGN KEY (`loc_name`) REFERENCES `location` (`name_location`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_loc` FOREIGN KEY (`user_loc`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_location`
--

LOCK TABLES `list_location` WRITE;
/*!40000 ALTER TABLE `list_location` DISABLE KEYS */;
INSERT INTO `list_location` VALUES (7,'emiliano.oddo','Palazzina Cinese'),(11,'emiliano.oddo','Teatro Politeama'),(12,'sino.patti','Teatro Massimo'),(13,'emiliano.oddo','Cappella Palatina'),(15,'emiliano.oddo','Museo Archeologico Salinas'),(16,'maria.livorno','Teatro Politeama'),(17,'riccardo.corleo','Teatro Massimo'),(18,'emiliano.oddo','Teatro Massimo');
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
  `idRequest` int(10) NOT NULL AUTO_INCREMENT,
  `sender` varchar(30) DEFAULT NULL,
  `receiver` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idRequest`),
  KEY `sender_idx` (`sender`),
  KEY `receiver_idx` (`receiver`),
  CONSTRAINT `receiver` FOREIGN KEY (`receiver`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sender` FOREIGN KEY (`sender`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `username` varchar(30) NOT NULL,
  `name` varchar(40) NOT NULL,
  `surname` varchar(40) NOT NULL,
  `email` varchar(30) NOT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `birth` date NOT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nickname` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('emiliano.oddo','Emiliano','Oddo','emiliano.oddo@gmail.com','male','kingking','1993-05-26','photos/emi.jpg'),('maria.livorno','Maria','Livorno','marialivorno@gmail.com','female','mariamaria','1956-05-25','photos/donna.jpg'),('riccardo.corleo','Riccardo','Corleo','riccardo.c@gmail.com','male','riccardo','1992-02-26','photos/uomo.jpg'),('silvia.randazzo','Silvia','Randazzo','silvi@gmail.com','female','silvisilvi','1995-09-14','photos/donna.jpg'),('sino.patti','Sino','Patti','sinopatti@libero.it','male','sinosino','1993-10-28','photos/uomo.jpg'),('vito.oddo','Vito','Oddo','vitod86@gmail.com','male','vitovito','1986-05-31','photos/uomo.jpg');
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

-- Dump completed on 2017-07-18 21:25:29
