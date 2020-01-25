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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `uid` int(40) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (35,'super','$2a$10$kCN9r5pqPt0zIIE5C9GbMuTaLJd7p3IzAKRDtpA.qx7zNkljx5TF2','root'),(36,'lkaksjdkfjka','$2a$10$j/E01nv7kWstRW59CyZ/keNx0HLSgPdqxsUSwXyLnVLyXD0mYKvl6','1,5,'),(37,'lisiljasldf','$2a$10$WdiTVO7Odk9Q3cxR1q/4ge0kja0pg8qJDgKOfpgQMlJuAHxetw7pW','1,2,'),(38,'lisilajsdf','$2a$10$QYEXdVPPPOmk8O7gYzcuge3kk.0qT0is9iP7OcA7rUQ8hdm4qDlsK','7,1,'),(39,'中尉','$2a$10$9frpWBR3dJCyouzho2PszuKXYBMyTsJ1aOS8e5sM3NOC8sy2KzXDu','7,'),(40,'lisi','$2a$10$Nnaat9OoZZAaoX2UBazRh.oNnGUF7JthZiXsYpHg/SEMdm0g8wozW','1,'),(41,'lisi22','$2a$10$JIiD4c8mq78//rs7xoAIGeLk6xY8X.3mNN7rB0l64EXUjalmV0hLW','7,'),(43,'lisi224','$2a$10$.37xBMz0tasqPG/JkoGRV.aeRTZAVOUK3fIkXTrpTd0NEI2wM7Hsu','7,'),(44,'lisi2245','$2a$10$/dglN6ZbEBgcGk6K1PkmUeB4ezOiXgYMGd4T/JwnO.EE41/mxzdIu','7,'),(45,'lisi22456','$2a$10$dqvLKBKCl73gMCurVs4NjenXhRPKaewbLV.tx37wEJkLSUSX8R56S','7,'),(46,'lisi224567','$2a$10$qdu2JnypqTr9pfkJsS79ruQuBAcC8C7iMJd4rLHDcU06VCgpYFoPa','7,'),(47,'lisi2245678','$2a$10$dvpcKvGeKBbOs/CJdqZqkuUPPLe.sXfqMat34gynukllfOmbItmTy','7,'),(48,'lisi22456789','$2a$10$Tmc9rP3UzTgeJJJjd5BHoO0iOl3DMxychCJYyjxt0cpwF6mU20Lfa','7,'),(49,'zzz','$2a$10$rAzFVuLK.72Z6CCd5BpFTejhqtewG93JXDTP.TDYGRIJRyQMqONc2','7,'),(50,'hyh','$2a$10$e6ohBqcvWWF0tUYuZVHYJuqYCsz3elZ2zC0puKGDNOz7/c.iPQIjC','1,'),(52,'hyh2','$2a$10$eRlOtVeXIJel9KNpWbQyBOmmPjNK9iSI6aXu53jTs.g0WMChtWqvS','1,');
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

-- Dump completed on 2020-01-24 15:49:10
