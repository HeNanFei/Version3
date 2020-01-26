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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `sid` int(50) NOT NULL AUTO_INCREMENT,
  `sname` varchar(30) DEFAULT NULL,
  `sgender` varchar(10) DEFAULT NULL,
  `school` varchar(100) DEFAULT NULL,
  `grade` varchar(40) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `pname` varchar(10) DEFAULT NULL,
  `tel` varchar(60) DEFAULT NULL,
  `cid` int(40) DEFAULT NULL,
  `edate` date DEFAULT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sname` (`sname`),
  CONSTRAINT `student_chk_1` CHECK (((`sgender` = _utf8mb4'男') or (`sgender` = _utf8mb4'女')))
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (19,'王树雪','女','昆明八中','初三','昆明','王五','15159085231',NULL,'2019-12-03'),(20,'李萌','女','云南师范大学附属中学','初二','昆明','lishun','15159052221',NULL,'2019-06-06'),(21,'王丽','女','云南师范大学附属中学','初二','昆明','lishun','15159052221',NULL,'2019-06-06'),(22,'李湘','男','云南师范大学附属中学','初二','昆明','lishun','15159052221',NULL,'2019-06-06'),(23,'李想','男','云南师范大学附属小学','三年级','昆明','lishun','15159052221',NULL,'2019-06-06'),(24,'张力','男','昆明小学','六年级','昆明','lishun','15159052221',NULL,'2019-06-06'),(25,'王均','男','昆明小学','四年级','昆明','lishun','15159052221',NULL,'2019-07-04'),(26,'司马顺','男','昆明小学','二年级','昆明','lishun','15159052221',NULL,'2019-07-04'),(27,'欧阳清风','男','曲靖二中','初一','曲靖','lishun','15159052221',NULL,'2019-07-19'),(28,'沐清','男','曲靖二中','初二','曲靖','lishun','15159052221',NULL,'2019-07-27'),(29,'赵家','男','红河中学','初一','红河','lishun','15159052221',NULL,'2019-07-27'),(30,'万股','男','南风中学','初二','红河','lishun','15159052221',NULL,'2019-07-27'),(31,'胡一菲','女','闽侯中学','初二','闽侯','huff','15159086256',NULL,'2020-01-01'),(32,'廖伟生','男','南靖中学','初一','闽侯','huff','15159086256',NULL,'2020-01-01'),(33,'胡伟鹏','男','杨林小学','五年级','杨林','huff','15159086256',NULL,'2020-01-11'),(34,'沈丽','女','杨林小学','二年级','杨林','huff','15159086256',NULL,'2020-01-11'),(35,'王小军','女','嵩明小学','五年级','杨林','huff','15159086256',NULL,'2020-01-11'),(36,'李晓雅','女','嵩明小学','四年级','杨林','huff','15159086256',NULL,'2020-01-11');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-26 18:27:39
