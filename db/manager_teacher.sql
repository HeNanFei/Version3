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
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teacher` (
  `tid` int(40) NOT NULL AUTO_INCREMENT,
  `tname` varchar(40) DEFAULT NULL,
  `tgender` varchar(10) DEFAULT NULL,
  `college` varchar(60) DEFAULT NULL,
  `tel` varchar(60) DEFAULT NULL,
  `type` varchar(60) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  UNIQUE KEY `tname` (`tname`),
  CONSTRAINT `teacher_chk_1` CHECK (((`tgender` = _utf8mb4'男') or (`tgender` = _utf8mb4'女')))
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (33,'苏亚雷斯','男','乌拉圭','15159085231','7,1,','巴萨罗纳'),(34,'神雕','男','就是打开','15159085231','7,','akshdf'),(46,'神雕1','男','就是打开','15159085231','7,','akshdf'),(49,'神雕12','男','就是打开','15159085231','7,','akshdf'),(51,'神雕123','男','就是打开','15159085231','7,','akshdf'),(52,'神雕1234','男','就是打开','15159085231','7,','akshdf'),(53,'神雕12345','男','就是打开','15159085231','7,','akshdf'),(54,'神雕123456','男','就是打开','15159085231','7,','akshdf'),(55,'神雕1234567','男','就是打开','15159085231','7,','akshdf'),(56,'神雕12345678','男','就是打开','15159085231','7,','akshdf'),(57,'神雕123456789','男','就是打开','15159085231','7,','akshdf'),(58,'神雕12345678910','男','就是打开','15159085231','7,','akshdf'),(59,'asfjdkj','男','aljsfdl','15159085231','7,','kasdfj'),(60,'asfjdkjs','男','aljsfdl','15159085231','7,','kasdfj'),(61,'asfjdkjsss','男','aljsfdl','15159085231','7,','kasdfj'),(62,'中文','男','云南','15159085231','1,2,','lsafdlk'),(63,'苏神','男','巴萨','15159085231','6,','hh'),(64,'123','男','123','15159085231','1,','kjhij');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-24 15:49:12
