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
  `sname` varchar(20) DEFAULT NULL,
  `sgender` varchar(10) DEFAULT NULL,
  `school` varchar(100) DEFAULT NULL,
  `grade` varchar(40) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `pname` varchar(10) DEFAULT NULL,
  `tel` varchar(60) DEFAULT NULL,
  `cid` int(40) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  CONSTRAINT `student_chk_1` CHECK (((`sgender` = _gbk'��') or (`sgender` = _gbk'Ů')))
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (3,'lkajsfkdj','女','alsdfjl','四年级','alskdjfkl','aslkdjflk','15159085231',NULL),(4,'aosfdl','女','ladflk','一年级','asjdfk','alsdjfl','13959024718',NULL),(5,'王子怡','女','兰州小学','三年级','拉萨酱豆腐','王晓','15159085237',NULL),(6,'张锦添','男','昆明小学','三年级','福建','林秀兰','15159085231',NULL),(8,'绍兴','男','浙江中学','二年级','浙江温州','绍兴','15159085231',NULL),(9,'张晶晶','女','龙门中学','初三','龙门','某某','15159085231',NULL),(11,'黎明','男','龙门中学','初二','laskjdflkj','sjdf','15159085231',NULL),(12,'武则天','女','昆明小学','六年级','卡卡尽快答复','武曌','15159085231',NULL),(13,'党参','男','南京小学','三年级','lnnslkf','klksjd','13959024718',NULL);
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

-- Dump completed on 2020-01-24 15:49:11
