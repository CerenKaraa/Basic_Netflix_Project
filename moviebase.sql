-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: prolab
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullanici` (
  `ad` varchar(45) DEFAULT NULL,
  `mail` varchar(45) NOT NULL,
  `sifre` varchar(45) DEFAULT NULL,
  `Dogum_Tarihi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanici`
--

LOCK TABLES `kullanici` WRITE;
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` VALUES ('Alperen','alperen61','6161','15.05.99'),('Ceren','ceren58','5858','11.12.99');
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullaniciprogram`
--

DROP TABLE IF EXISTS `kullaniciprogram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kullaniciprogram` (
  `İzleıd` int NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `filmadi` varchar(45) DEFAULT NULL,
  `bölüm` varchar(45) DEFAULT NULL,
  `süre` varchar(45) DEFAULT NULL,
  `tarih` varchar(45) DEFAULT NULL,
  `puan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`İzleıd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullaniciprogram`
--

LOCK TABLES `kullaniciprogram` WRITE;
/*!40000 ALTER TABLE `kullaniciprogram` DISABLE KEYS */;
INSERT INTO `kullaniciprogram` VALUES (0,'ceren58','Angry Birds','1','2690','Mon Jun 01 22:30:05 EEST 2020','6'),(1,'ceren58','Yüzüklerin Efendisi İki Kule','1','2261','Mon Jun 01 22:30:21 EEST 2020','8');
/*!40000 ALTER TABLE `kullaniciprogram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `FilmID` int NOT NULL,
  `Ad` varchar(45) NOT NULL,
  `Tip` varchar(45) DEFAULT NULL,
  `Bolum` int DEFAULT NULL,
  `Uzunluk` int DEFAULT NULL,
  `Puan` double DEFAULT NULL,
  `PuanSayisi` int DEFAULT NULL,
  PRIMARY KEY (`FilmID`,`Ad`),
  UNIQUE KEY `Ad_UNIQUE` (`Ad`),
  UNIQUE KEY `FilmID_UNIQUE` (`FilmID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'72 Sevimli Hayvan','Film',1,2,5,10),(2,'Alaca Karanlık','Film',1,2,5,10),(3,'Alvin ve Sincaplar','Film',1,2,5,10),(4,'Angry Birds','Dizi',25,1,6,11),(5,'Arif V 216','Film',1,2,7,10),(6,'Assasins Creed','Film',1,2,5,10),(7,'Atiye','Dizi',25,1,5,10),(8,'Aydaki Son Adam','Film',1,2,5,10),(9,'Basketball or Nothing','Tv Show',11,3,7.4,10),(10,'Başlangıç','Film',1,2,5,10),(11,'Ben Efsaneyim','Film',1,2,5,10),(12,'Beni Boyle Sev','Dizi',25,1,5,10),(13,'Beyblade','Dizi',25,1,7,10),(14,'Bizi Hatirla','Film',1,2,6,10),(15,'Büyük Tasarımlar','Tv Show',11,3,5,10),(16,'Car Masters','Tv Show',11,3,8.9,10),(17,'Charlienin Çikolata Fabrikasi','Film',1,2,5,10),(18,'Criminal','Dizi',25,1,7,10),(19,'Da Vinci Şifresi','Film',1,2,6,10),(20,'Dangal','Film',1,2,5,10),(21,'Delibal','Film',1,2,6,10),(22,'Diriliş Ertuğrul','Dizi',25,1,5,10),(23,'Dream Big','Film',1,2,6,10),(24,'Dünyanın En Sıradışı Evleri','Tv Show',11,3,7.5,10),(25,'Ejderhalar','Dizi',25,1,5,10),(26,'Fantastik Canavarlar','Film',1,2,5,10),(27,'Frankestein','Film',1,2,5,10),(28,'Gezegenimiz','Film',1,2,5,10),(29,'Harry Potter Ölüm Yadigarları','Film',1,2,5,10),(30,'How I Met Your Mother','Dizi',25,1,9,10),(31,'Intersetellar','Film',1,2,5,10),(32,'Jaws','Film',1,2,5,10),(33,'Jurassic Park','Film',1,2,5,10),(34,'Jurassic World','Film',1,2,5,10),(35,'Kara Şövalye','Film',1,2,5,10),(36,'Kardeşim Benim','Film',1,2,5,10),(37,'Kung Fu Panda','Film',1,2,5,10),(38,'Kung Fu Panda Muhteşem Sırlar','Dizi',25,1,5,10),(39,'Kuşçular','Film',1,2,5,10),(40,'Kuşlarla Dans','Film',1,2,5,10),(41,'Leyla İle Mecnun','Dizi',25,1,8,10),(42,'Marsta Keşif','Film',1,2,5,10),(43,'Marwel Iron Fist','Dizi',25,1,5,10),(44,'Maşa ile Koca Ayı','Dizi',25,1,5,10),(45,'Maske','Film',1,2,5,10),(46,'Mega Zeka','Film',1,2,5,10),(47,'Mercan Pesinde','Film',1,2,5,10),(48,'Mission Blue','Film',1,2,6,10),(49,'Mr. Bean Tatilde','Film',1,2,5,10),(50,'Ninja Kaplumbagalar','Film',1,2,5,10),(51,'Örumcek Adam','Film',1,2,5,10),(52,'Pandemic','Film',1,2,5,10),(53,'Patron Bebek Yine İş Başında','Dizi',25,1,5,10),(54,'PK','Film',1,2,5,10),(55,'Plastik Okyanus','Film',1,2,5,10),(56,'Pokemon','Film',1,2,5,10),(57,'Rakamlarla Tahmin','Film',1,2,5,10),(58,'Recep İvedik 6','Film',1,2,5,10),(59,'Scooby-Doo','Film',1,2,5,10),(60,'Sherlock Holmes','Film',1,2,5,10),(61,'Shrek','Film',1,2,5,10),(62,'Şirinler','Film',1,2,5,10),(63,'Sıradışı Kulübeler','Tv Show',11,3,7,10),(64,'Sonic X','Dizi',25,1,6,10),(65,'Stranger Things','Dizi',25,1,5,10),(66,'Sungerbob','Dizi',25,1,5,10),(67,'The Big Family Cooking','Tv Show',11,3,7.1,10),(68,'The Blacklist','Dizi',25,1,5,10),(69,'The Originals','Dizi',25,1,5,10),(70,'Transformers Kayip Cag','Film',1,2,5,10),(71,'Trol Avcilari:Arcadia Hikayeleri','Dizi',25,1,5,10),(72,'Yerçekimi','Film',1,2,5,10),(73,'Yüzüklerin Efendisi İki Kule','Film',1,2,8.75,12),(74,'Yüzüklerin Efendisi Kralin Dönüsü','Film',1,2,8.9,10);
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tür`
--

DROP TABLE IF EXISTS `tür`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tür` (
  `TürID` int NOT NULL,
  `TürAdi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TürID`),
  KEY `TürID_idx` (`TürID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tür`
--

LOCK TABLES `tür` WRITE;
/*!40000 ALTER TABLE `tür` DISABLE KEYS */;
INSERT INTO `tür` VALUES (1,'Aksiyon ve Macera'),(2,'Bilim Kurgu ve Fantastik Yapımlar'),(3,'Romantik'),(4,'Drama'),(5,'Çocuk ve Aile'),(6,'Belgesel'),(7,'Korku'),(8,'Bilim ve Doğa'),(9,'Komedi'),(10,'Gerilim'),(11,'Anime'),(12,'Reality Program');
/*!40000 ALTER TABLE `tür` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `türprogram`
--

DROP TABLE IF EXISTS `türprogram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `türprogram` (
  `tpID` varchar(45) NOT NULL,
  `FilmID` int DEFAULT NULL,
  `TürID` int DEFAULT NULL,
  PRIMARY KEY (`tpID`),
  KEY `FilmID_idx` (`FilmID`),
  KEY `TürID_idx` (`TürID`),
  CONSTRAINT `FilmID` FOREIGN KEY (`FilmID`) REFERENCES `program` (`FilmID`),
  CONSTRAINT `TürID` FOREIGN KEY (`TürID`) REFERENCES `tür` (`TürID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `türprogram`
--

LOCK TABLES `türprogram` WRITE;
/*!40000 ALTER TABLE `türprogram` DISABLE KEYS */;
INSERT INTO `türprogram` VALUES ('1',1,6),('10',7,1),('100',67,12),('101',68,1),('102',68,10),('103',69,4),('104',69,7),('105',70,1),('106',71,1),('107',71,5),('108',72,2),('109',72,4),('11',7,3),('110',73,1),('111',73,2),('112',52,6),('113',52,8),('114',74,1),('115',74,2),('116',4,5),('12',8,6),('13',9,12),('14',10,1),('15',11,2),('16',12,3),('17',12,4),('18',13,5),('19',13,11),('2',1,8),('20',14,4),('21',15,12),('22',16,12),('23',17,5),('24',17,9),('25',18,10),('26',19,10),('27',20,4),('28',21,4),('29',21,3),('3',2,1),('30',22,1),('31',23,6),('32',24,12),('33',25,1),('34',25,5),('35',4,9),('36',26,1),('37',26,5),('38',27,2),('39',27,1),('4',2,3),('40',27,7),('41',28,6),('42',28,8),('43',29,1),('44',29,2),('45',29,5),('46',30,3),('47',31,1),('48',31,4),('49',32,10),('5',3,5),('50',33,2),('51',33,1),('52',34,1),('53',35,1),('54',35,2),('55',36,4),('56',36,9),('57',37,5),('58',37,1),('59',38,1),('6',5,2),('60',39,6),('61',39,8),('62',40,6),('63',41,3),('64',42,6),('65',42,8),('66',43,1),('67',44,5),('68',45,1),('69',45,2),('7',5,9),('70',46,5),('71',46,9),('72',47,6),('73',48,6),('74',49,5),('75',50,1),('76',50,2),('77',51,1),('78',51,2),('79',53,5),('8',6,1),('80',53,9),('81',54,3),('82',54,2),('83',55,6),('84',56,5),('85',57,6),('86',58,1),('87',59,5),('88',60,1),('89',61,5),('9',6,2),('90',61,9),('91',62,5),('92',62,9),('93',63,12),('94',64,11),('95',64,1),('96',65,1),('97',65,7),('98',66,9),('99',66,5);
/*!40000 ALTER TABLE `türprogram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'prolab'
--

--
-- Dumping routines for database 'prolab'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-01 22:55:48
