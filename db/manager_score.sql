-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: manager
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `score` (
  `sid` int(40) DEFAULT NULL,
  `tid` int(40) DEFAULT NULL,
  `cid` int(40) DEFAULT NULL,
  `score` int(40) DEFAULT NULL,
  `sname` varchar(40) DEFAULT NULL,
  `lname` varchar(40) DEFAULT NULL,
  `cdate` date DEFAULT NULL,
  `scoreid` int(40) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`scoreid`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (5,20,75,15,'王子怡','第一单元','2020-01-08',9),(5,20,67,95,'王子怡','第一单元','2020-01-07',11),(6,20,74,95,'张锦添','期末考','2020-01-15',12),(5,20,73,99,'王子怡','第二单元','2020-01-01',13),(5,20,76,15,'王子怡','第一单元','2020-01-01',44),(5,20,76,75,'王子怡','第二单元','2020-01-01',45),(5,20,76,80,'王子怡','第三单元','2020-01-03',46),(5,20,76,85,'王子怡','第四单元','2020-01-03',47),(5,20,76,90,'王子怡','第五单元','2020-01-03',48),(5,20,76,95,'王子怡','第六单元','2020-01-03',49),(5,20,76,100,'王子怡','第七单元','2020-01-09',50),(5,29,52,35,'王子怡','第一单元','2020-01-01',51),(5,29,52,40,'王子怡','第二单元','2020-01-02',53),(5,29,52,50,'王子怡','第三单元','2020-01-02',54),(5,29,52,60,'王子怡','第四单元','2020-01-02',55),(5,29,52,60,'王子怡','第五单元','2020-01-02',56),(5,29,52,90,'王子怡','第六单元','2020-01-02',57),(5,20,76,98,'王子怡','期末考','2020-01-03',58),(6,20,72,63,'张锦添','第三单元','2020-01-10',62),(6,20,72,96,'张锦添','第四单元测试','2020-01-18',63),(9,29,72,63,'张晶晶','第一单元测试','2020-01-01',64),(9,29,72,79,'张晶晶','第二单元测试','2020-01-03',65),(9,29,72,79,'张晶晶','第四单元测试','2020-01-09',66),(9,29,72,89,'张晶晶','第五单元测试','2020-01-10',67),(6,33,72,52,'张锦添','第九单元','2020-01-08',68),(6,33,72,25,'张锦添','第六单元','2020-01-08',69);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-24 15:49:09
