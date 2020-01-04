CREATE DATABASE  IF NOT EXISTS `team32` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `team32`;
-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: team32
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `comName` varchar(45) NOT NULL,
  PRIMARY KEY (`comName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('4400 Theater Company'),('AI Theater Company'),('Awesome Theater Company'),('EZ Theater Company');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customercreditcard`
--

DROP TABLE IF EXISTS `customercreditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customercreditcard` (
  `username` varchar(45) NOT NULL,
  `creditCardNum` char(16) NOT NULL,
  PRIMARY KEY (`creditCardNum`),
  KEY `fk4_idx` (`username`),
  CONSTRAINT `fk4` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customercreditcard`
--

LOCK TABLES `customercreditcard` WRITE;
/*!40000 ALTER TABLE `customercreditcard` DISABLE KEYS */;
INSERT INTO `customercreditcard` VALUES ('calcultron','1111111111000000'),('calcultron2','1111111100000000'),('calcultron2','1111111110000000'),('calcwizard','1111111111100000'),('cool_class4400','2222222222000000'),('DNAhelix','2220000000000000'),('does2Much','2222222200000000'),('eeqmcsquare','2222222222222200'),('entropyRox','2222222222200000'),('entropyRox','2222222222220000'),('fullMetal','1100000000000000'),('georgep','1111111111110000'),('georgep','1111111111111000'),('georgep','1111111111111100'),('georgep','1111111111111110'),('georgep','1111111111111111'),('ilikemoney$$','2222222222222220'),('ilikemoney$$','2222222222222222'),('ilikemoney$$','9000000000000000'),('imready','1111110000000000'),('isthisthekrustykrab','1110000000000000'),('isthisthekrustykrab','1111000000000000'),('isthisthekrustykrab','1111100000000000'),('notFullMetal','1000000000000000'),('programerAAL','2222222000000000'),('RitzLover28','3333333333333300'),('thePiGuy3.14','2222222220000000'),('theScienceGuy','2222222222222000');
/*!40000 ALTER TABLE `customercreditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerviewmovie`
--

DROP TABLE IF EXISTS `customerviewmovie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerviewmovie` (
  `movName` varchar(45) NOT NULL,
  `movReleaseDate` date NOT NULL,
  `movPlayDate` date NOT NULL,
  `comName` varchar(45) NOT NULL,
  `thName` varchar(45) NOT NULL,
  `creditCardNum` char(16) NOT NULL,
  PRIMARY KEY (`movName`,`movReleaseDate`,`movPlayDate`,`creditCardNum`,`comName`,`thName`),
  KEY `fk11_idx` (`creditCardNum`),
  KEY `fk12_idx` (`movName`,`movReleaseDate`,`movPlayDate`,`comName`,`thName`),
  CONSTRAINT `fk11` FOREIGN KEY (`creditCardNum`) REFERENCES `customercreditcard` (`creditCardNum`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk12` FOREIGN KEY (`movName`, `movReleaseDate`, `movPlayDate`, `comName`, `thName`) REFERENCES `movieplay` (`movName`, `movReleaseDate`, `movPlayDate`, `comName`, `thName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerviewmovie`
--

LOCK TABLES `customerviewmovie` WRITE;
/*!40000 ALTER TABLE `customerviewmovie` DISABLE KEYS */;
INSERT INTO `customerviewmovie` VALUES ('How to Train Your Dragon','2010-03-21','2010-03-25','EZ Theater Company','Star Movies','1111111111111100'),('How to Train Your Dragon','2010-03-21','2010-03-22','EZ Theater Company','Main Movies','1111111111111111'),('How to Train Your Dragon','2010-03-21','2010-03-23','EZ Theater Company','Main Movies','1111111111111111'),('How to Train Your Dragon','2010-03-21','2010-04-02','4400 Theater Company','Cinema Star','1111111111111111');
/*!40000 ALTER TABLE `customerviewmovie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `username` varchar(45) NOT NULL,
  `manStreet` varchar(45) NOT NULL,
  `manCity` varchar(45) NOT NULL,
  `manState` char(2) NOT NULL,
  `manZipcode` char(5) NOT NULL,
  `employeeType` enum('Manager','Admin') NOT NULL,
  `comName` varchar(45) NOT NULL,
  `thName` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk2_idx` (`comName`),
  CONSTRAINT `fk1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('calcultron','123 Peachtree St','Atlanta','GA','30308','Manager','EZ Theater Company','Star Movies'),('cool_class4400','','','','','Admin','',''),('entropyRox','200 Cool Place','San Francisco','CA','94016','Manager','4400 Theater Company','Cinema Star'),('fatherAI','456 Main St','New York','NY','10001','Manager','EZ Theater Company','Main Movies'),('georgep','10 Pearl Dr','Seattle','WA','98105','Manager','4400 Theater Company','Jonathan\'s Movies'),('ghcghc','100 Pi St','Pallet Town','KS','31415','Manager','AI Theater Company','ML Movies'),('imbatman','800 Color Dr','Austin','TX','78653','Manager','Awesome Theater Company','ABC Theater'),('manager1','123 Ferst Drive','Atlanta','GA','30332','Manager','4400 Theater Company',''),('manager2','456 Ferst Drive','Atlanta','GA','30332','Manager','AI Theater Company',''),('manager3','789 Ferst Drive','Atlanta','GA','30332','Manager','4400 Theater Company',''),('manager4','000 Ferst Drive','Atlanta','GA','30332','Manager','4400 Theater Company',''),('radioactivePoRa','100 Blu St','Sunnyvale','CA','94088','Manager','4400 Theater Company','Star Movies');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `username` varchar(45) NOT NULL,
  `manStreet` varchar(45) NOT NULL,
  `manCity` varchar(45) NOT NULL,
  `manState` char(2) NOT NULL,
  `manZipcode` char(5) NOT NULL,
  `employeeType` enum('Manager','Admin') NOT NULL,
  `comName` varchar(45) NOT NULL,
  `thName` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk3_idx` (`comName`),
  CONSTRAINT `fk2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk3` FOREIGN KEY (`comName`) REFERENCES `company` (`comName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('calcultron','123 Peachtree St','Atlanta','GA','30308','Manager','EZ Theater Company','Star Movies'),('entropyRox','200 Cool Place','San Francisco','CA','94016','Manager','4400 Theater Company','Cinema Star'),('fatherAI','456 Main St','New York','NY','10001','Manager','EZ Theater Company','Main Movies'),('georgep','10 Pearl Dr','Seattle','WA','98105','Manager','4400 Theater Company','Jonathan\'s Movies'),('ghcghc','100 Pi St','Pallet Town','KS','31415','Manager','AI Theater Company','ML Movies'),('imbatman','800 Color Dr','Austin','TX','78653','Manager','Awesome Theater Company','ABC Theater'),('manager1','123 Ferst Drive','Atlanta','GA','30332','Manager','4400 Theater Company',''),('manager2','456 Ferst Drive','Atlanta','GA','30332','Manager','AI Theater Company',''),('manager3','789 Ferst Drive','Atlanta','GA','30332','Manager','4400 Theater Company',''),('manager4','000 Ferst Drive','Atlanta','GA','30332','Manager','4400 Theater Company',''),('radioactivePoRa','100 Blu St','Sunnyvale','CA','94088','Manager','4400 Theater Company','Star Movies');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movName` varchar(45) NOT NULL,
  `movReleaseDate` date NOT NULL,
  `duration` int(11) NOT NULL,
  PRIMARY KEY (`movName`,`movReleaseDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('4400 The Movie','2019-08-12',130),('Avengers: Endgame','2019-04-26',181),('Calculus Returns: A ML Story','2019-09-19',314),('George P Burdell\'s Life Story','1927-08-12',100),('Georgia Tech The Movie','1985-08-13',100),('How to Train Your Dragon','2010-03-21',98),('Spaceballs','1987-06-24',96),('Spider-Man: Into the Spider-Verse','2018-12-01',117),('The First Pokemon Movie','1998-07-19',75),('The King\'s Speech','2010-11-26',119);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieplay`
--

DROP TABLE IF EXISTS `movieplay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movieplay` (
  `movName` varchar(45) NOT NULL,
  `movReleaseDate` date NOT NULL,
  `movPlayDate` date NOT NULL,
  `comName` varchar(45) NOT NULL,
  `thName` varchar(45) NOT NULL,
  PRIMARY KEY (`movName`,`movReleaseDate`,`movPlayDate`,`comName`,`thName`),
  KEY `fk7_idx` (`comName`,`thName`),
  CONSTRAINT `fk7` FOREIGN KEY (`comName`, `thName`) REFERENCES `theater` (`comName`, `thName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk8` FOREIGN KEY (`movName`, `movReleaseDate`) REFERENCES `movie` (`movName`, `movReleaseDate`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieplay`
--

LOCK TABLES `movieplay` WRITE;
/*!40000 ALTER TABLE `movieplay` DISABLE KEYS */;
INSERT INTO `movieplay` VALUES ('4400 The Movie','2019-08-12','2019-09-12','4400 Theater Company','Cinema Star'),('George P Burdell\'s Life Story','1927-08-12','2010-05-20','4400 Theater Company','Cinema Star'),('Georgia Tech The Movie','1985-08-13','2019-09-30','4400 Theater Company','Cinema Star'),('How to Train Your Dragon','2010-03-21','2010-04-02','4400 Theater Company','Cinema Star'),('Spaceballs','1987-06-24','2000-02-02','4400 Theater Company','Cinema Star'),('The King\'s Speech','2010-11-26','2019-12-20','4400 Theater Company','Cinema Star'),('Calculus Returns: A ML Story','2019-09-19','2019-10-10','AI Theater Company','ML Movies'),('Calculus Returns: A ML Story','2019-09-19','2019-12-30','AI Theater Company','ML Movies'),('Spaceballs','1987-06-24','2010-04-02','AI Theater Company','ML Movies'),('Spaceballs','1987-06-24','2023-01-23','AI Theater Company','ML Movies'),('Spider-Man: Into the Spider-Verse','2018-12-01','2019-09-30','AI Theater Company','ML Movies'),('4400 The Movie','2019-08-12','2019-10-12','Awesome Theater Company','ABC Theater'),('Georgia Tech The Movie','1985-08-13','1985-08-13','Awesome Theater Company','ABC Theater'),('The First Pokemon Movie','1998-07-19','2018-07-19','Awesome Theater Company','ABC Theater'),('George P Burdell\'s Life Story','1927-08-12','2019-07-14','EZ Theater Company','Main Movies'),('George P Burdell\'s Life Story','1927-08-12','2019-10-22','EZ Theater Company','Main Movies'),('How to Train Your Dragon','2010-03-21','2010-03-22','EZ Theater Company','Main Movies'),('How to Train Your Dragon','2010-03-21','2010-03-23','EZ Theater Company','Main Movies'),('Spaceballs','1987-06-24','1999-06-24','EZ Theater Company','Main Movies'),('The King\'s Speech','2010-11-26','2019-12-20','EZ Theater Company','Main Movies'),('4400 The Movie','2019-08-12','2019-08-12','EZ Theater Company','Star Movies'),('How to Train Your Dragon','2010-03-21','2010-03-25','EZ Theater Company','Star Movies');
/*!40000 ALTER TABLE `movieplay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `comName` varchar(45) NOT NULL,
  `thName` varchar(45) NOT NULL,
  `capacity` int(11) NOT NULL,
  `thStreet` varchar(45) NOT NULL,
  `thCity` varchar(45) NOT NULL,
  `thState` char(2) NOT NULL,
  `thZipcode` char(5) NOT NULL,
  `manUsername` varchar(45) NOT NULL,
  PRIMARY KEY (`comName`,`thName`),
  KEY `fk6_idx` (`manUsername`),
  CONSTRAINT `fk5` FOREIGN KEY (`comName`) REFERENCES `company` (`comName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk6` FOREIGN KEY (`manUsername`) REFERENCES `manager` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES ('4400 Theater Company','Cinema Star',4,'100 Cool Place','San Francisco','CA','94016','entropyRox'),('4400 Theater Company','Jonathan\'s Movies',2,'67 Pearl Dr','Seattle','WA','98101','georgep'),('4400 Theater Company','Star Movies',5,'4400 Rocks Ave','Boulder','CA','80301','radioactivePoRa'),('AI Theater Company','ML Movies',3,'314 Pi St','Pallet Town','KS','31415','ghcghc'),('Awesome Theater Company','ABC Theater',5,'880 Color Dr','Austin','TX','73301','imbatman'),('EZ Theater Company','Main Movies',3,'123 Main St','New York','NY','10001','fatherAI'),('EZ Theater Company','Star Movies',2,'745 GT St','Atlanta','GA','30332','calcultron');
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `userType` enum('Employee','Customer','User','CustomerAdmin','CustomerManager','Manager') NOT NULL,
  `status` enum('Approved','Declined','Pending') NOT NULL DEFAULT 'Pending',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('calcultron','Dwight','Schrute','333333333','CustomerManager','Approved'),('calcultron2','Jim','Halpert','444444444','Customer','Approved'),('calcwizard','Issac','Newton','222222222','Customer','Approved'),('clarinetbeast','Squidward','Tentacles','999999999','Customer','Declined'),('cool_class4400','A. TA','Washere','333333333','CustomerAdmin','Approved'),('DNAhelix','Rosalind','Franklin','777777777','Customer','Approved'),('does2Much','Carl','Gauss','1212121212','Customer','Approved'),('eeqmcsquare','Albert','Einstein','111111110','Customer','Approved'),('entropyRox','Claude','Shannon','999999999','CustomerManager','Approved'),('fatherAI','Alan','Turing','222222222','Manager','Approved'),('fullMetal','Edward','Elric','111111100','Customer','Approved'),('gdanger','Gary','Danger','555555555','User','Declined'),('georgep','George P.','Burdell','111111111','CustomerManager','Approved'),('ghcghc','Grace','Hopper','666666666','Manager','Approved'),('ilikemoney$$','Eugene','Krabs','111111110','Customer','Approved'),('imbatman','Bruce','Wayne','666666666','Manager','Approved'),('imready','Spongebob','Squarepants','777777777','Customer','Approved'),('isthisthekrustykrab','Patrick','Star','888888888','Customer','Approved'),('manager1','Manager','One','1122112211','Manager','Approved'),('manager2','manager','two','3131313131','Manager','Approved'),('manager3','Three','Three','8787878787','Manager','Approved'),('manager4','Four','Four','5755555555','Manager','Approved'),('notFullMetal','Alphonse','Elric','111111100','Customer','Approved'),('programerAAL','Abby','Normal','3131313131','Customer','Approved'),('radioactivePoRa','Marie','Curie','1313131313','Manager','Approved'),('RitzLover28','Abby','Normal','444444444','Customer','Approved'),('smith_j','John','Smith','333333333','User','Pending'),('texasStarKarate','Sandy','Cheeks','111111110','User','Declined'),('thePiGuy3.14','Archimedes','Syracuse','1111111111','Customer','Approved'),('theScienceGuy','Bill','Nye','999999999','Customer','Approved');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uservisittheater`
--

DROP TABLE IF EXISTS `uservisittheater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uservisittheater` (
  `username` varchar(45) NOT NULL,
  `comName` varchar(45) NOT NULL,
  `thName` varchar(45) NOT NULL,
  `visitDate` date NOT NULL,
  `[VisitID]` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`[VisitID]`),
  KEY `fk9_idx` (`username`),
  KEY `fk10_idx` (`comName`,`thName`),
  CONSTRAINT `fk10` FOREIGN KEY (`comName`, `thName`) REFERENCES `theater` (`comName`, `thName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk9` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uservisittheater`
--

LOCK TABLES `uservisittheater` WRITE;
/*!40000 ALTER TABLE `uservisittheater` DISABLE KEYS */;
INSERT INTO `uservisittheater` VALUES ('georgep','EZ Theater Company','Main Movies','2010-03-22',1),('calcwizard','EZ Theater Company','Main Movies','2010-03-22',2),('calcwizard','EZ Theater Company','Star Movies','2010-03-25',3),('imready','EZ Theater Company','Star Movies','2010-03-25',4),('calcwizard','AI Theater Company','ML Movies','2010-03-20',5);
/*!40000 ALTER TABLE `uservisittheater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'team32'
--

--
-- Dumping routines for database 'team32'
--
/*!50003 DROP PROCEDURE IF EXISTS `admin_approve_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_approve_user`(IN i_username VARCHAR(50))
BEGIN
		update user
        set status = 'Approved'
        where username = i_username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_create_mov` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_create_mov`(IN i_movName VARCHAR(50), IN i_movDuration INT, IN i_movRelease DATE)
BEGIN
INSERT INTO movie (movName, movReleaseDate, duration) VALUES (i_movName, i_movRelease, i_movDuration);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_create_theater` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_create_theater`(IN i_thName VARCHAR(50), IN i_comName VARCHAR(50), IN i_thStreet VARCHAR(50), IN i_thCity VARCHAR(50), 
IN i_thState CHAR(2), IN i_thZipcode CHAR(5), IN i_capacity INT, IN i_managerUsername VARCHAR(50))
BEGIN
IF(((select comName from manager where username = i_managerUsername) = i_comName) AND
 ((select thName from manager where username = i_managerUsername) = '')) THEN
INSERT INTO theater (thName, comName, thStreet, thCity,thState,thZipcode,capacity,manUsername) 
VALUES (i_thName, i_comName, i_thStreet, i_thCity, i_thState,i_thZipcode, i_capacity, i_managerUsername);
UPDATE employee
SET thName = i_thName
WHERE username = i_managerUsername;
UPDATE manager
SET thName = i_thName
WHERE username = i_managerUsername;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_decline_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_decline_user`(IN i_username VARCHAR(50))
BEGIN
		IF(SELECT status FROM user WHERE username = i_username) <> 'Approved' THEN
        update user
        set status = 'Declined'
        where username = i_username;
        END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_filter_company` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_filter_company`(IN i_comName VARCHAR(45),IN i_minCity Int,IN i_maxCity Int, IN i_minTheater Int,IN i_maxTheater Int, IN i_minEmployee Int,
IN i_maxEmployee Int, IN i_sortBy ENUM("comName", "numCityCover", "numTheater", "numEmployee", ''), IN i_sortDirection ENUM('DESC','ASC',''))
BEGIN
    IF (i_comName <> 'ALL') THEN 
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
    SELECT t.comName,Count(distinct t.thCity) AS numCityCover, Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName AND t.comName= i_comName  
        Group by t.comName;
  ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is null ) then
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover , Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee       
        From theater t, employee e
        WHERE t.comName = e.comName  
        Group by t.comName
        Having (Count(distinct e.username) >= i_minEmployee)
    order by t.comName DESC;
  ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null ) then
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee       
        From theater t, employee e
        WHERE t.comName = e.comName  
        Group by t.comName
        Having (Count(distinct e.username) between i_minEmployee and i_maxEmployee)
    order by t.comName DESC;
 ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection <> 'ASC' and (i_minCity is not null) and (i_maxCity is not null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null ) then
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName  
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity and i_maxCity)
     order by t.comName DESC;
 ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection <> 'ASC' and (i_minCity is  null) and (i_maxCity is  null) and i_minTheater is not null and i_maxTheater is not null and i_minEmployee is null and i_maxEmployee is null ) then
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee        
        From theater t, employee e
        WHERE t.comName = e.comName  
        Group by t.comName
        Having (Count(distinct t.thName)  between i_minCity and i_maxCity)
     order by t.comName DESC;
 ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null ) then
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee      
        From theater t, employee e
        WHERE t.comName = e.comName  
        Group by t.comName
    order by t.comName DESC;
  ELSEIF (i_sortBy = '' and i_sortDirection = '' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null ) then
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee       
        From theater t, employee e
        WHERE t.comName = e.comName  
        Group by t.comName;
    ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection <> 'ASC' and (i_minCity is NOT null) and (i_maxCity is NOT null) and i_minTheater is NOT null and i_maxTheater is NOT null and i_minEmployee is NOT null and i_maxEmployee is NOT null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee        
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)AND (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater DESC;
  ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection <> 'ASC' and i_minCity is null and i_maxCity is null and i_minTheater is not null and i_maxTheater is not null and i_minEmployee is not null and i_maxEmployee is not null  ) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover , Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName  AND t.comName= i_comName  
        Group by t.comName
    Having (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater DESC;
  ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection <> 'ASC' and i_minCity is not null and i_maxCity is not null and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null  ) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName  AND t.comName= i_comName  
        Group by t.comName
    Having (Count(distinct t.thCity) between i_minCity AND i_maxCity) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater DESC;
  ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee   
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
    order by numTheater DESC;
   ELSEIF (i_sortBy = 'numTheater' and i_sortDirection <> 'ASC') THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
    SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)AND (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater DESC;
    ELSEIF (i_sortBy = 'numTheater' and i_sortDirection <> 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
    SELECT t.comName,Count(distinct t.thCity) AS numCityCover , Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater DESC;
    ELSEIF (i_sortBy = 'numTheater' and i_sortDirection <> 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is not null and i_maxTheater is not null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
    SELECT t.comName,Count(distinct t.thCity) AS numCityCover, Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct t.thName) between i_minTheater AND i_maxTheater)
    order by numTheater DESC;
     ELSEIF (i_sortBy = 'numTheater' and i_sortDirection <> 'ASC'and (i_minCity is not null) and (i_maxCity is not null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
    SELECT t.comName,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee,Count(distinct t.thCity) AS numCityCover
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)
    order by numTheater DESC;
   ELSEIF (i_sortBy = 'numTheater' and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
    SELECT t.comName,Count(distinct t.thCity) AS numCityCover,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName        
    order by numTheater DESC; 
  ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection <> 'ASC' ) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee,Count(distinct t.thCity) AS numCityCover   
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)AND (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numEmployee DESC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having(Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numEmployee DESC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is not null and i_maxTheater is not null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee   
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thName) between i_minTheater AND i_maxTheater)
    order by numEmployee DESC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection <> 'ASC' and (i_minCity is not null) and (i_maxCity is not null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee   
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)
    order by numEmployee DESC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection <> 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover, Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee 
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
    order by numEmployee DESC;
     ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection = 'ASC' ) then
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover , Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)AND (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by t.comName ASC;
    ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection = 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee 
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by t.comName ASC;
    ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection = 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is not null and i_maxTheater is not null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thName) between i_minTheater AND i_maxTheater)
    order by t.comName ASC;
    ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection = 'ASC' and (i_minCity is not null) and (i_maxCity is not null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)
    order by t.comName ASC;
    ELSEIF ((i_sortBy = 'comName' or i_sortBy = '') and i_sortDirection = 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
    order by t.comName ASC;
    ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection = 'ASC') THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)AND (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee 
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having(Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is not null and i_maxTheater is not null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thName) between i_minTheater AND i_maxTheater)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection = 'ASC'and (i_minCity is not null) and (i_maxCity is not null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee   
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numCityCover' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
    order by numTheater ASC;
   ELSEIF (i_sortBy = 'numTheater' and i_sortDirection = 'ASC') THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee 
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)AND (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND  (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numTheater' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee   
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numTheater' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is not null and i_maxTheater is not null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct t.thName) between i_minTheater AND i_maxTheater)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numTheater' and i_sortDirection = 'ASC'and (i_minCity is not null) and (i_maxCity is not null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover , Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)
    order by numTheater ASC;
    ELSEIF (i_sortBy = 'numTheater' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName   
        Group by t.comName
    order by numTheater ASC;
   ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee  
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
    order by numEmployee ASC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection = 'ASC') THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)AND (Count(distinct t.thName) between i_minTheater AND i_maxTheater) AND (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numEmployee ASC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection = 'ASC' and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is not null and i_maxEmployee is not null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct e.username) between i_minEmployee AND i_maxEmployee)
    order by numEmployee ASC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection = 'ASC'and (i_minCity is null) and (i_maxCity is null) and i_minTheater is null and not i_maxTheater is not null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thName) between i_minTheater AND i_maxTheater)
    order by numEmployee ASC;
    ELSEIF (i_sortBy = 'numEmployee' and i_sortDirection = 'ASC'and (i_minCity is not null) and (i_maxCity is not null) and i_minTheater is null and i_maxTheater is null and i_minEmployee is null and i_maxEmployee is null) THEN
    DROP TABLE IF EXISTS AdFilterCom;
    CREATE TABLE AdFilterCom
        SELECT t.comName,Count(distinct t.thCity) AS numCityCover ,Count(distinct t.thName) AS numTheater, Count(distinct e.username) AS numEmployee
        From theater t, employee e
        WHERE t.comName = e.comName    
        Group by t.comName
        Having (Count(distinct t.thCity) between i_minCity AND i_maxCity)
    order by numEmployee ASC;
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_filter_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_filter_user`(IN i_username VARCHAR(50), IN i_status ENUM('Approved','Pending','Declined', 'ALL'), 
IN i_sortBy ENUM('username','creditCardCount','userType','status', ''), IN i_sortDirection ENUM('ASC','DESC',''))
BEGIN
	IF (i_username <> '') THEN 
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE user.username = i_username AND (status = i_status OR i_status = 'ALL');
	ELSEIF ((i_sortBy = 'username' or i_sortBy = '') and i_sortDirection <> 'ASC' ) then
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by username DESC;
    ELSEIF (i_sortBy = 'creditCardCount' and i_sortDirection <> 'ASC') THEN
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by creditCardCOunt DESC;
	 ELSEIF (i_sortBy = 'userType' and i_sortDirection <> 'ASC') THEN
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by userType DESC;
	ELSEIF (i_sortBy = 'status' and i_sortDirection <> 'ASC') THEN
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by status DESC;
	 ELSEIF ((i_sortBy = 'username' or i_sortBy = '')  and i_sortDirection = 'ASC') then
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by username ASC;
    ELSEIF (i_sortBy = 'creditCardCount' and i_sortDirection = 'ASC') THEN
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by creditCardCOunt ASC;
	 ELSEIF (i_sortBy = 'userType' and i_sortDirection = 'ASC') THEN
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by userType ASC;
	ELSEIF (i_sortBy = 'status' and i_sortDirection = 'ASC') THEN
		DROP TABLE IF EXISTS AdFilterUser;
		CREATE TABLE AdFilterUser
		SELECT user.username, count(creditCardNum) as creditCardCount, userType, status
		FROM customercreditcard right join user on user.username = customercreditcard.username
		WHERE status = i_status OR i_status = 'ALL'
		group by username
		order by status ASC;
    END IF;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_view_comDetail_emp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_view_comDetail_emp`(IN i_comName VARCHAR(45))
BEGIN
DROP TABLE IF EXISTS AdComDetailEmp;
CREATE TABLE AdComDetailEmp
SELECT u.firstname as empFirstname, u.lastname as empLastname
FROM user u
JOIN employee e
ON u.username = e.username
WHERE e.comName = i_comName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `admin_view_comDetail_th` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `admin_view_comDetail_th`(IN i_comName VARCHAR(45))
BEGIN
DROP TABLE IF EXISTS AdComDetailTh;
CREATE TABLE AdComDetailTh
SELECT t.thName,e.username as thManagerUsername,t.thCity,t.thState,t.Capacity as thCapacity
FROM theater t
JOIN employee e
ON t.comName = e.comName
WHERE  t.comName= i_comName and manUsername = e.username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_add_creditcard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_add_creditcard`(In i_username VARCHAR(45), In i_creditCardNum VARCHAR(16))
BEGIN
	IF (SELECT count(*) from customercreditcard WHERE i_username = username ) <5 THEN
    
	INSERT INTO customercreditcard (username, creditCardNum) VALUES( i_username, i_creditCardNum );
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_filter_mov` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_filter_mov`(IN i_movName VARCHAR(45), IN i_comName VARCHAR(45), IN i_city VARCHAR(45),IN i_state CHAR(3),
IN i_minMovPlayDate DATE, IN i_maxMovPlayDate DATE)
BEGIN
 DROP TABLE IF EXISTS CosFilterMovie;
    CREATE TABLE CosFilterMovie
    SELECT movName, thName, thStreet, thCity, thState, thZipCode, comName, movPlayDate, movReleaseDate
    FROM movieplay natural join theater
    WHERE 
    (( movPlayDate >= movReleaseDate )) AND
    ((movName = i_movName) or (i_movName = "ALL")) AND
    ((comName = i_comName) or (i_comName = "ALL")) AND
    (thCity = i_city or i_city = "") AND
    (thState = i_state or i_state = "ALL") AND
    ((movPlayDate >= i_minMovPlayDate AND movPlayDate <= i_maxMovPlayDate) or (i_minMovPlayDate is NULL and movPlayDate < i_maxMovPlayDate) or (i_maxMovPlayDate is NULL and movPlayDate > i_minMovPlayDate) or (i_minMovPlayDate is NULL and i_maxMovPlayDate is NULL));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_only_register` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_only_register`(IN i_username VARCHAR(50), IN i_password VARCHAR(50), IN i_firstname VARCHAR(50), IN i_lastname VARCHAR(50))
BEGIN
		INSERT INTO user (username, password, firstname, lastname, userType, status) VALUES (i_username, MD5(i_password), i_firstname, i_lastname, 'Customer', 'Pending');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_view_history` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_view_history`(IN i_cusUsername VARCHAR(50))
BEGIN
	DROP TABLE IF EXISTS CosViewHistory;
    CREATE TABLE CosViewHistory
	select movName, thName, comName, creditCardNum, movPlayDate
    from customerviewmovie
    where creditCardNum in (select creditCardNum
							from customercreditcard
                            where i_cusUsername = username);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_view_mov` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_view_mov`(In i_creditCardNum CHAR(20), In i_movName VARCHAR(45), 
        In i_movReleaseDate DATE, In i_thName VARCHAR(45), 
                                In i_comName VARCHAR(45), In i_movPlayDate DATE)
BEGIN

 Insert into customerviewmovie 
    values (i_movName, i_movReleaseDate, i_movPlayDate,  i_comName, i_thName, i_creditCardNum);
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `manager_customer_add_credictcard` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `manager_customer_add_credictcard`(IN i_username VARCHAR(50), IN i_creditCardNum CHAR(16))
BEGIN
	IF (SELECT count(*) from customercreditcard WHERE i_username = username ) <5 THEN
    
	INSERT INTO customercreditcard (username, creditCardNum) VALUES( i_username, i_creditCardNum );
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `manager_customer_register` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `manager_customer_register`(IN i_username VARCHAR(50), IN i_password VARCHAR(50), IN i_firstname VARCHAR(50), IN i_lastname VARCHAR(50),
IN i_comName VARCHAR(45), IN i_empStreet VARCHAR(45), IN i_empCity VARCHAR(45), IN i_empState CHAR(2), IN i_empZipcode CHAR(5))
BEGIN
		INSERT INTO user(username, password, firstname, lastname, userType)
        VALUES (i_username, MD5(password), i_firstname, i_lastname, 'CustomerManager');
        INSERT INTO employee (username, comName, manStreet, manCity, manState, manZipcode, thName) 
        VALUES ( i_username, i_comName, i_empStreet, i_empCity, i_empState, i_empZipcode, "");
        INSERT INTO manager (username, comName, manStreet, manCity, manState, manZipcode, thName) 
        VALUES ( i_username, i_comName, i_empStreet, i_empCity, i_empState, i_empZipcode, "");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `manager_filter_th` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `manager_filter_th`(IN i_manUsername VARCHAR(50), IN i_movName VARCHAR(50), IN i_minMovDuration INT, IN i_maxMovDuration INT,
IN i_minMovReleaseDate DATE, IN i_maxMovReleaseDate DATE,IN i_minMovPlayDate DATE, IN i_maxMovPlayDate DATE, IN i_includeNotPlayed BOOLEAN)
BEGIN
        IF((NOT i_includeNotPlayed) OR i_includeNotPlayed is NULL) THEN
        DROP TABLE IF EXISTS ManFilterTh;
        CREATE TABLE ManFilterTh
        SELECT movie.movName,duration as movDuration,movie.movReleaseDate,movPlayDate
         FROM (select * FROM movieplay where thName in (select thName from employee where Username = i_manUsername)) as a right join movie on a.movName = movie.movName 
        WHERE
         ((movie.movName = i_movName OR i_movName = "") AND
            ((duration >= i_minMovDuration AND duration <= i_maxMovDuration) OR i_minMovDuration is NULL OR i_maxMovDuration is NULL) AND
            ((movie.movReleaseDate >= i_minMovReleaseDate AND movie.movReleaseDate <= i_maxMovReleaseDate) OR i_minMovReleaseDate is NULL OR i_maxMovReleaseDate is NULL) AND
            ((movPlayDate >= i_minMovPlayDate AND movPlayDate <= i_maxMovPlayDate) OR i_minMovPlayDate is NULL OR i_maxMovPlayDate is NULL OR movPlayDate is NULL));
        ELSE
        DROP TABLE IF EXISTS ManFilterTh;
        CREATE TABLE ManFilterTh
        SELECT movie.movName,duration as movDuration,movie.movReleaseDate, movPlayDate
        FROM (select * FROM movieplay where thName in (select thName from employee where Username = i_manUsername)) as a right join movie on a.movName = movie.movName
        WHERE 
           ((movie.movName = i_movName OR i_movName = "") AND
            ((duration >= i_minMovDuration AND duration <= i_maxMovDuration) OR i_minMovDuration is NULL OR i_maxMovDuration is NULL) AND
            ((movie.movReleaseDate >= i_minMovReleaseDate AND movie.movReleaseDate <= i_maxMovReleaseDate) OR i_minMovReleaseDate is NULL OR i_maxMovReleaseDate is NULL) AND
            (movPlayDate is NULL));
        END IF;
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `manager_only_register` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `manager_only_register`(IN i_username VARCHAR(50), IN i_password VARCHAR(50), IN i_firstname VARCHAR(50), IN i_lastname VARCHAR(50), IN i_comName VARCHAR(50), IN i_empStreet VARCHAR(50), IN i_empCity VARCHAR(50), IN i_empState CHAR(2), IN i_empZipcode CHAR(5))
BEGIN
    INSERT INTO user (username, password, firstname, lastname, userType) 
        VALUES (i_username, MD5(i_password), i_firstname, i_lastname, 'Manager');
        INSERT INTO employee (username, comName, manStreet, manCity, manState, manZipcode,thName)
        VALUES (i_username, i_comName, i_empStreet, i_empCity, i_empState, i_empZipcode,"");
        INSERT INTO manager (username, comName, manStreet, manCity, manState, manZipcode,thName)
        VALUES (i_username, i_comName, i_empStreet, i_empCity, i_empState, i_empZipcode,"");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `manager_schedule_mov` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `manager_schedule_mov`(IN i_manUsername VARCHAR(45), IN i_movName VARCHAR(45), IN i_movReleaseDate DATE, IN i_movPlayDate DATE)
BEGIN
    INSERT INTO movieplay (movName, movReleaseDate, movPlayDate, thName, comName)
    select i_movName, i_movReleaseDate, i_movPlayDate,thName, comName
    from employee
    where username = i_manUsername;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `user_filter_th` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_filter_th`(IN i_thName VARCHAR(50), IN i_comName VARCHAR(50), IN i_city VARCHAR(50), IN i_state VARCHAR(3))
BEGIN
    DROP TABLE IF EXISTS UserFilterTh;
    CREATE TABLE UserFilterTh
	SELECT thName, thStreet, thCity, thState, thZipcode, comName 
    FROM Theater
    WHERE 
		(thName = i_thName OR i_thName = "ALL") AND
        (comName = i_comName OR i_comName = "ALL") AND
        (thCity = i_city OR i_city = "") AND
        (thState = i_state OR i_state = "ALL");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `user_filter_visitHistory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_filter_visitHistory`(IN i_username VARCHAR(50), IN i_minVisitDate DATE, IN i_maxVisitDate DATE)
BEGIN
    DROP TABLE IF EXISTS UserVisitHistory;
    CREATE TABLE UserVisitHistory
	SELECT thName, thStreet, thCity, thState, thZipcode, comName, visitDate
    FROM UserVisitTheater
		NATURAL JOIN
        Theater
	WHERE
		(username = i_username) AND
        (i_minVisitDate IS NULL OR visitDate >= i_minVisitDate) AND
        (i_maxVisitDate IS NULL OR visitDate <= i_maxVisitDate);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `user_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_login`(IN i_username VARCHAR(45), IN i_password VARCHAR(45))
BEGIN
  DROP TABLE IF EXISTS UserLogin;
    CREATE TABLE UserLogin
        SELECT username, status,
        CASE WHEN (SELECT userType FROM user WHERE userName = i_username) = 'Customer' or (SELECT userType FROM user WHERE userName = i_username) = 'CustomerAdmin' or (SELECT userType FROM user WHERE userName = i_username) = 'CustomerManager' THEN '1'
        ELSE '0' END AS isCustomer,
        CASE WHEN (SELECT employeeType FROM employee WHERE userName = i_username) = 'Admin' THEN '1'
        ELSE '0' END AS isAdmin,
        CASE WHEN (SELECT employeeType FROM employee WHERE userName = i_username) = 'Manager' THEN '1'
        ELSE '0' END AS isManager
        FROM user
        WHERE (userName = i_username) AND 
        (password = i_password);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `user_register` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_register`(IN i_username VARCHAR(50), IN i_password VARCHAR(50), IN i_firstname VARCHAR(50), IN i_lastname VARCHAR(50))
BEGIN
		INSERT INTO user (username, password, firstname, lastname) VALUES (i_username, MD5(i_password), i_firstname, i_lastname);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `user_visit_th` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_visit_th`(IN i_thName VARCHAR(50), IN i_comName VARCHAR(50), IN i_visitDate DATE, IN i_username VARCHAR(50))
BEGIN
    INSERT INTO UserVisitTheater (thName, comName, visitDate, username)
    VALUES (i_thName, i_comName, i_visitDate, i_username);
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

-- Dump completed on 2019-11-30  0:26:52
