-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: LibraryManagement
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `BookData`
--

DROP TABLE IF EXISTS `BookData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BookData` (
  `BookID` int(100) NOT NULL,
  `BookName` varchar(100) DEFAULT NULL,
  `Quantity` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BookData`
--

LOCK TABLES `BookData` WRITE;
/*!40000 ALTER TABLE `BookData` DISABLE KEYS */;
INSERT INTO `BookData` VALUES (2953114,'BOOK2','10'),(6512951,'BOOK1','22'),(6871395,'HHHHH','111111'),(8941996,'HARSHIT','111');
/*!40000 ALTER TABLE `BookData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FacultyData`
--

DROP TABLE IF EXISTS `FacultyData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FacultyData` (
  `FacultyID` int(100) DEFAULT NULL,
  `FacultyName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FacultyData`
--

LOCK TABLES `FacultyData` WRITE;
/*!40000 ALTER TABLE `FacultyData` DISABLE KEYS */;
INSERT INTO `FacultyData` VALUES (7488251,'Faculty1');
/*!40000 ALTER TABLE `FacultyData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LibrarianData`
--

DROP TABLE IF EXISTS `LibrarianData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LibrarianData` (
  `LibrarianID` int(100) DEFAULT NULL,
  `LibrarianName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibrarianData`
--

LOCK TABLES `LibrarianData` WRITE;
/*!40000 ALTER TABLE `LibrarianData` DISABLE KEYS */;
INSERT INTO `LibrarianData` VALUES (6216465,'Librarian2'),(7843753,'Librarian1');
/*!40000 ALTER TABLE `LibrarianData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudentData`
--

DROP TABLE IF EXISTS `StudentData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StudentData` (
  `StudentID` int(100) DEFAULT NULL,
  `StudentName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudentData`
--

LOCK TABLES `StudentData` WRITE;
/*!40000 ALTER TABLE `StudentData` DISABLE KEYS */;
INSERT INTO `StudentData` VALUES (9875526,'Student1'),(1139565,'student1');
/*!40000 ALTER TABLE `StudentData` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-08 13:21:15
