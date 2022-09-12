CREATE DATABASE  IF NOT EXISTS `foodmapdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `foodmapdb`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: foodmapdb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id_comment` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `id_user` int NOT NULL,
  `id_store` int NOT NULL,
  `created_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `id_user_idx` (`id_user`),
  KEY `id_menu_2_idx` (`id_store`),
  CONSTRAINT `id_menu_2` FOREIGN KEY (`id_store`) REFERENCES `user` (`id_user`),
  CONSTRAINT `id_user_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'hihi',8,3,'2022-08-22 09:19:49','2022-08-22 09:19:49'),(2,'mammay',8,3,'2022-08-22 09:20:40','2022-08-22 09:20:40'),(3,'NGU',8,3,'2022-08-22 10:15:52','2022-08-22 10:15:52'),(4,'say hi',8,3,'2022-08-22 10:19:10','2022-08-22 10:19:10'),(5,'say bye',8,3,'2022-08-22 10:21:55','2022-08-22 10:21:55'),(6,'hi',8,3,'2022-08-22 10:22:48','2022-08-22 10:22:48'),(7,'hi 1',8,3,'2022-08-22 10:25:47','2022-08-22 10:25:47'),(8,'hi2',8,3,'2022-08-22 10:26:52','2022-08-22 10:26:52'),(9,'hi 3',8,3,'2022-08-22 10:27:49','2022-08-22 10:27:49'),(10,'h95',8,3,'2022-08-22 10:29:42','2022-08-22 10:29:42'),(11,'THONG NGU',8,3,'2022-08-22 10:30:48','2022-08-22 10:30:48'),(12,'Cha thom va ngon',8,4,'2022-08-22 10:32:51','2022-08-22 10:32:51'),(13,'Nhin cung ngon nhung chua an',8,2,'2022-09-10 07:13:28','2022-09-10 07:13:28'),(14,'mon an rat ngon\n',8,3,'2022-09-11 00:43:21','2022-09-11 00:43:21'),(15,'goi cuon ngon lam',8,6,'2022-09-11 00:50:18','2022-09-11 00:50:18'),(16,'tra atiso rat tuyet voi',8,6,'2022-09-11 00:50:47','2022-09-11 00:50:47'),(17,'bun bo o day ngon lam nha moi nguoi...sukoi~~~',8,6,'2022-09-11 00:54:28','2022-09-11 00:54:28'),(18,'bun rieu o day tuyet voi lam',8,6,'2022-09-11 00:55:55','2022-09-11 00:55:55');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow` (
  `id_follow` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_store` int NOT NULL,
  PRIMARY KEY (`id_follow`),
  KEY `follow_store_idx` (`id_store`),
  KEY `user_follow_idx` (`id_user`),
  CONSTRAINT `follow_store` FOREIGN KEY (`id_store`) REFERENCES `user` (`id_user`),
  CONSTRAINT `user_follow` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES (28,8,3),(30,8,2),(32,8,4);
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id_menu` int NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `price` float NOT NULL,
  `menu_note` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci,
  `id_store` int DEFAULT NULL,
  `menu_status` bit(1) NOT NULL DEFAULT b'1',
  `menu_from` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `menu_to` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `image` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `id_type` int NOT NULL,
  `is_delete` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id_menu`),
  KEY `id_store_6_idx` (`id_store`),
  KEY `type_idx` (`id_type`),
  CONSTRAINT `id_store_6` FOREIGN KEY (`id_store`) REFERENCES `user` (`id_user`),
  CONSTRAINT `type` FOREIGN KEY (`id_type`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Panna cotta',17000,'Hoi bi nhuc nach',2,_binary '','07:00','11:00','2022-08-21 13:02:27','2022-08-21 13:02:27','https://res.cloudinary.com/djgexdpxq/image/upload/v1661086952/nmazy6bls2fwjkculqto.jpg',2,_binary '\0'),(2,'Bánh crepe ngập sầu 8 cái',105000,'',2,_binary '','07:00','23:00','2022-08-21 13:03:15','2022-08-21 13:03:15','https://res.cloudinary.com/djgexdpxq/image/upload/v1661086998/s5s1q3lgbezmxpransma.jpg',1,_binary '\0'),(3,'Sữa chua phô mai đà lạt',13000,'',2,_binary '','07:00','23:00','2022-08-21 13:03:34','2022-08-21 13:03:34','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087017/fcjiqtlkhrd3q6rpapxe.jpg',1,_binary '\0'),(4,'Bánh crepe ngập sầu 4 cái',55000,'',2,_binary '','07:00','23:00','2022-08-21 13:04:03','2022-08-21 13:04:03','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087048/ppy7fxdowcw4pseo2ghb.jpg',1,_binary '\0'),(5,'Bánh crepe ngập sầu 10 cái',130000,'',2,_binary '','07:00','23:00','2022-08-21 13:04:28','2022-08-21 13:04:28','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087072/f1ar8oik4qkuij39c1ve.jpg',1,_binary '\0'),(6,'Bánh sầu riêng ngàn lớp 12cm',135000,'',2,_binary '','07:00','23:00','2022-08-21 13:04:59','2022-08-21 13:04:59','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087103/updsv2ogt095rarxcxmz.jpg',1,_binary '\0'),(7,'Sữa chua uống trái cây',20000,'',2,_binary '','07:00','23:00','2022-08-21 13:05:18','2022-08-21 13:05:18','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087122/jpiq21gned91xyseucmw.jpg',1,_binary '\0'),(8,'Bánh sầu riêng ngàn lớp 16cm',170000,'',2,_binary '','07:00','23:00','2022-08-21 13:05:38','2022-08-21 13:05:38','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087143/mqudnxgebroihyc8gz6j.jpg',1,_binary '\0'),(9,'Bánh crepe ngập sầu 6 cái',80000,'',2,_binary '','07:00','23:00','2022-08-21 13:06:04','2022-08-21 13:06:04','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087167/ggg74y1jhwqtuzx6uggk.jpg',1,_binary '\0'),(10,'Combo bánh riêng ngàn lớp 12cm + 2 crepe',155000,'',2,_binary '','07:00','23:00','2022-08-21 13:06:41','2022-08-21 13:06:41','https://res.cloudinary.com/djgexdpxq/image/upload/v1661087205/wpjzaf29jhmw2sg7jqnx.jpg',1,_binary '\0'),(11,'Mì Dầu Hào Chả Cá HongKong Thượng Hạng - 港式蚝油捞面-鱼片',69000,'',3,_binary '','07:00','23:00','2022-08-21 13:30:12','2022-08-21 13:30:12','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088616/qvx5aylzngrfns4hpoxl.jpg',1,_binary '\0'),(12,'Đậu Hủ Cá Viên HongKong Thượng Hạng - 港式豆腐鱼丸',65000,'',3,_binary '','07:00','23:00','2022-08-21 13:30:31','2022-08-21 13:30:31','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088634/nlyt1lj945fxwqlipev4.jpg',1,_binary '\0'),(13,'Trôi Nước Đậu Phộng HongKong - 港式花生汤圆',39000,'',3,_binary '','07:00','23:00','2022-08-21 13:30:52','2022-08-21 13:30:52','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088655/pf3djzitlxphsg8x0a4r.jpg',1,_binary '\0'),(14,'Set Mì Dầu Hào HongKong và Soup Tôm Tươi Phỉ Thuý',98000,'',3,_binary '','07:00','23:00','2022-08-21 13:31:38','2022-08-21 13:31:38','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088701/hokfvn8q3f57fek0esew.jpg',1,_binary '\0'),(15,'Trà Sữa HongKong Thượng Hạng Chai 450ml - 港式奶茶瓶装 450ml',59000,'',3,_binary '','07:00','23:00','2022-08-21 13:31:54','2022-08-21 13:31:54','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088718/xayhvprucu3hb67hokx6.jpg',1,_binary '\0'),(16,'Mì Dầu Hào Cồi Sò Điệp HongKong Thượng Hạng - 港式蚝油捞面-扇贝',69000,'',3,_binary '','07:00','23:00','2022-08-21 13:32:18','2022-08-21 13:32:18','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088743/fcgy25mgpet0gntxf5pz.jpg',1,_binary '\0'),(17,'Kaya Butter Toast - 咖椰吐司',22000,'',3,_binary '','07:00','23:00','2022-08-21 13:32:38','2022-08-21 13:32:38','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088764/vaxzt44jxwomlz8wuu1d.jpg',1,_binary '\0'),(18,'Đậu Hủ Ky Cuộn Tôm Tươi Chiên HongKong - 港式鲜虾腐竹卷',98000,'',3,_binary '','07:00','23:00','2022-08-21 13:33:02','2022-08-21 13:33:02','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088788/c3mcf9f5vpzrpsl8rmge.jpg',1,_binary '\0'),(19,'Cá Viên HongKong - 港式鱼丸',58000,'',3,_binary '','07:00','23:00','2022-08-21 13:33:20','2022-08-21 13:33:20','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088805/ef0xjugkykg2b6vu20gn.jpg',1,_binary '\0'),(20,'Pudding Thỏ Dâu Tây - 小兔布丁',30000,'',3,_binary '','07:00','23:00','2022-08-21 13:33:35','2022-08-21 13:33:35','https://res.cloudinary.com/djgexdpxq/image/upload/v1661088819/y0gilrzxwpvkr13wspt4.jpg',1,_binary '\0'),(21,'Chè khúc bạch',35000,'',5,_binary '','07:00','23:00','2022-08-21 13:38:04','2022-08-21 13:38:04','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089093/orjruswqroo4jo0yidhc.jpg',1,_binary '\0'),(22,'Sữa chua mít đác (new)',35000,'',5,_binary '','07:00','23:00','2022-08-21 13:38:39','2022-08-21 13:38:39','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089123/mfaep7zznipifma7ufcu.jpg',1,_binary '\0'),(23,'Đậu thập cẩm',25000,'',5,_binary '','07:00','23:00','2022-08-21 13:38:54','2022-08-21 13:38:54','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089139/euqpm5mrnjvep8sqq0os.jpg',1,_binary '\0'),(24,'Trà Đào Cam Sả',35000,'',5,_binary '','07:00','23:00','2022-08-21 13:39:15','2022-08-21 13:39:15','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089159/lhg1l8kzzxgvrakgvzpy.jpg',1,_binary '\0'),(25,'Trà Đào Vải',35000,'',5,_binary '','07:00','23:00','2022-08-21 13:39:34','2022-08-21 13:39:34','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089178/vxzdmvredjyvwrmxrbie.jpg',1,_binary '\0'),(26,'Chè thái đặc biệt',38000,'',5,_binary '','07:00','23:00','2022-08-21 13:39:53','2022-08-21 13:39:53','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089197/ch5ykxzczwgpm2wgnbba.jpg',1,_binary '\0'),(27,'Sầu riêng bánh lọt',35000,'',5,_binary '','07:00','23:00','2022-08-21 13:40:16','2022-08-21 13:40:16','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089220/y7urvybz180bvuny57rj.jpg',1,_binary '\0'),(28,'Bánh lọt thập cẩm',25000,'',5,_binary '','07:00','23:00','2022-08-21 13:40:32','2022-08-21 13:40:32','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089236/sp3vfvjq7tjxwerckfds.jpg',1,_binary '\0'),(29,'Trà đào mơ',35000,'',5,_binary '','07:00','23:00','2022-08-21 13:40:49','2022-08-21 13:40:49','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089253/z7ydmxv6tkgqx274b4oh.jpg',1,_binary '\0'),(30,'Sâm bổ lượng',30000,'',5,_binary '','07:00','23:00','2022-08-21 13:41:07','2022-08-21 13:41:07','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089272/ivhvxhkdd3kdqncyj4fs.jpg',1,_binary '\0'),(31,'Phần Đầy Đủ (kèm phồng tôm)',65000,'',4,_binary '','07:00','23:00','2022-08-21 13:49:12','2022-08-21 13:49:12','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089757/dhg6w3pzvsvo2uz6zxbb.jpg',1,_binary '\0'),(32,'Chả Nem Trộn (kèm phồng tôm)',55000,'',4,_binary '','07:00','23:00','2022-08-21 13:49:35','2022-08-21 13:49:35','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089779/eag62x1asjxpxk2nfo1c.jpg',1,_binary '\0'),(33,'Phồng Tôm (5 chiếc)',5000,'',4,_binary '','07:00','23:00','2022-08-21 13:49:56','2022-08-21 13:49:56','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089800/vzh8uhnjh5gvflccc6hm.jpg',1,_binary '\0'),(34,'Phần Đặc Biệt (kèm phồng tôm)',85000,'',4,_binary '','07:00','23:00','2022-08-21 13:50:18','2022-08-21 13:50:18','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089822/xfez7v2ahdxi8ffuzsnl.jpg',1,_binary '\0'),(35,'Chả Trộn (kèm phồng tôm)',55000,'',4,_binary '','07:00','23:00','2022-08-21 13:50:39','2022-08-21 13:50:39','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089844/ry2jynmdtfjc4bc3fmal.jpg',1,_binary '\0'),(36,'Nem Chua (2 chiếc)',10000,'',4,_binary '','07:00','23:00','2022-08-21 13:51:04','2022-08-21 13:51:04','https://res.cloudinary.com/djgexdpxq/image/upload/v1661089870/rpcp7lypvzdfgxonhb56.jpg',1,_binary '\0'),(37,'Cuốn tươi thanh mát',52000,'',6,_binary '','07:00','23:00','2022-08-21 13:54:15','2022-08-21 13:54:15','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090058/yyhx3vx0sjdqv9gscc2d.jpg',1,_binary '\0'),(38,'Cuốn xanh rộn ràng',52000,'',6,_binary '','07:00','23:00','2022-08-21 13:54:38','2022-08-21 13:54:38','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090082/sc7hlgewgynkkrl0gp5w.jpg',1,_binary '\0'),(39,'Bún riêu cua chả hoa + trà Atiso lá dứa hạt chia',80000,'',6,_binary '','07:00','23:00','2022-08-21 13:55:39','2022-08-21 13:55:39','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090142/yuqtfekfsjd7oihvifzb.jpg',1,_binary '\0'),(40,'Gỏi xoài tôm khô + Trà Atiso Lá dứa hạt chia',80000,'',6,_binary '','07:00','23:00','2022-08-21 13:56:25','2022-08-21 13:56:25','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090188/luf5soill7pprn6tn9f5.jpg',1,_binary '\0'),(41,'Đại tiệc cuốn: 6 món',430000,'',6,_binary '','07:00','23:00','2022-08-21 13:56:54','2022-08-21 13:56:54','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090217/tobl17fsma5llpifbe9p.jpg',1,_binary '\0'),(42,'Bún riêu cua chả hoa',53000,'',6,_binary '','07:00','23:00','2022-08-21 13:57:18','2022-08-21 13:57:18','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090243/amdsstgcb2ngoi1874v8.jpg',1,_binary '\0'),(43,'Gỏi xoài tôm khô',52000,'',6,_binary '','07:00','23:00','2022-08-21 13:57:40','2022-08-21 13:57:40','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090263/yhw4exo3nfeezxcys3h7.jpg',1,_binary '\0'),(44,'Cuốn xanh tươi mát + Trà Atiso Lá dứa hạt chia',80000,'',6,_binary '','07:00','23:00','2022-08-21 13:58:41','2022-08-21 13:58:41','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090325/ezqmaxp0ba63eq7jyn0l.jpg',1,_binary '\0'),(45,'Cuốn xanh rộn ràng + Trà Atiso Lá dứa hạt chia',80000,'',6,_binary '','07:00','23:00','2022-08-21 13:59:13','2022-08-21 13:59:13','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090356/dslwm6uyrzifg2hmnkqm.jpg',1,_binary '\0'),(46,'Bún nem, thịt nước & chả giò',85000,'',6,_binary '','07:00','23:00','2022-08-21 13:59:37','2022-08-21 13:59:37','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090381/vfqquzcsvo6xnm7mxm59.jpg',1,_binary '\0'),(47,'Bánh Tráng Trộn Bơ Mỡ Hành',30000,'',7,_binary '','07:00','23:00','2022-08-21 14:03:10','2022-08-21 14:03:10','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090594/exvy3ip89m0orcpvvlxf.jpg',1,_binary '\0'),(48,'Bánh Tráng Trộn',30000,'',7,_binary '','07:00','23:00','2022-08-21 14:03:32','2022-08-21 14:03:32','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090616/kfxwh2qdd8chnnvaopnn.jpg',1,_binary '\0'),(49,'Bánh tráng Trộn Khô Gà',30000,'',7,_binary '','07:00','23:00','2022-08-21 14:03:53','2022-08-21 14:03:53','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090637/lr3f5kyzi2plqg0xwrh3.jpg',1,_binary '\0'),(50,'Khô Bò',40000,'',7,_binary '','07:00','23:00','2022-08-21 14:04:08','2022-08-21 14:04:08','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090652/knaqfwmxsuhssq3vghud.jpg',1,_binary '\0'),(51,'Xúc Xích Chiên(1 cây)',15000,'',7,_binary '','07:00','23:00','2022-08-21 14:04:28','2022-08-21 14:04:28','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090672/jd26vhc43spq4tjfm1mm.jpg',1,_binary '\0'),(52,'Trứng Gà Luộc(1 Trứng)',7000,'',7,_binary '','07:00','23:00','2022-08-21 14:05:04','2022-08-21 14:05:04','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090708/wd0dg2flpkxhkudf7wzh.jpg',1,_binary '\0'),(53,'Bánh tráng Trộn Khô Bò',30000,'',7,_binary '','07:00','23:00','2022-08-21 14:05:26','2022-08-21 14:05:26','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090729/gjl1s8z6ojspcabhprya.jpg',1,_binary '\0'),(54,'Khô Gà',40000,'',7,_binary '','07:00','23:00','2022-08-21 14:05:42','2022-08-21 14:05:42','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090746/clcfdqo4iylsml5popoe.jpg',1,_binary '\0'),(55,'Bánh tráng Muối Nhuyễn',13000,'',7,_binary '','07:00','23:00','2022-08-21 14:06:02','2022-08-21 14:06:02','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090766/vctraeypden9gkxcjnos.jpg',1,_binary '\0'),(56,'Chả Cá Hàn Quốc Chiên',10000,'',7,_binary '','07:00','23:00','2022-08-21 14:06:23','2022-08-21 14:06:23','https://res.cloudinary.com/djgexdpxq/image/upload/v1661090786/gdyldfhoth8tfw1atsl9.jpg',1,_binary '\0'),(61,'Mi xao',10000,'',26,_binary '','07:00','23:00','2022-09-11 01:32:20','2022-09-11 01:32:20','https://res.cloudinary.com/djgexdpxq/image/upload/v1662859958/oteywn7knxbxrbxatrmp.jpg',1,_binary '\0');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_order`
--

DROP TABLE IF EXISTS `menu_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_order` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `total` float NOT NULL,
  `note` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci,
  `created_date` datetime NOT NULL,
  `type_payment` varchar(10) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `id_user_5_idx` (`id_user`),
  CONSTRAINT `id_user_5` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_order`
--

LOCK TABLES `menu_order` WRITE;
/*!40000 ALTER TABLE `menu_order` DISABLE KEYS */;
INSERT INTO `menu_order` VALUES (1,8,5200,NULL,'2022-08-22 08:14:25',NULL),(2,8,11500,NULL,'2022-08-22 16:24:54',NULL),(3,8,69000,NULL,'2022-08-26 07:33:53',NULL),(4,8,100000,NULL,'2022-08-30 15:47:16',NULL),(5,8,33,NULL,'2022-09-02 15:30:26',NULL),(6,8,34000,NULL,'2022-09-03 18:34:11',NULL),(7,8,34000,NULL,'2022-09-03 18:36:28',NULL),(9,8,34000,NULL,'2022-09-03 18:48:51',NULL),(10,8,34000,NULL,'2022-09-03 18:53:33',NULL),(11,8,34000,NULL,'2022-09-03 18:59:34','Offline'),(12,8,210000,NULL,'2022-09-10 07:20:07','Momo'),(13,8,80000,NULL,'2022-09-10 07:31:06','Momo'),(14,8,27000,NULL,'2022-09-10 16:47:25','Offline'),(15,8,138000,NULL,'2022-09-11 00:44:44','Momo'),(16,8,20000,NULL,'2022-09-11 01:35:40','Momo');
/*!40000 ALTER TABLE `menu_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id_order_detail` int NOT NULL AUTO_INCREMENT,
  `id_order` int NOT NULL,
  `id_menu` int NOT NULL,
  `quantity` int NOT NULL,
  `unit_price` float NOT NULL,
  `status_order` smallint NOT NULL DEFAULT '2',
  PRIMARY KEY (`id_order_detail`),
  KEY `id_menu_4_idx` (`id_menu`),
  KEY `id_orther_1_idx` (`id_order`),
  CONSTRAINT `id_menu_4` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`),
  CONSTRAINT `id_orther_1` FOREIGN KEY (`id_order`) REFERENCES `menu_order` (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,51,1,15000,1),(2,1,52,1,7000,0),(3,1,47,1,30000,0),(4,2,32,2,55000,0),(5,2,33,1,5000,0),(6,3,11,1,69000,2),(7,4,21,1,35000,2),(8,4,31,1,65000,2),(9,5,3,1,13000,1),(10,5,7,1,20000,1),(11,6,1,2,17000,1),(12,7,1,2,17000,1),(13,9,1,2,17000,1),(14,10,1,2,17000,1),(15,11,1,2,17000,1),(16,12,2,2,105000,0),(17,13,9,1,80000,0),(18,14,1,1,17000,2),(19,15,11,2,69000,2),(20,16,61,2,10000,1);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `id_rating` int NOT NULL AUTO_INCREMENT,
  `rate_quality` int NOT NULL,
  `id_user` int NOT NULL,
  `id_store` int NOT NULL,
  `created_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `rate_service` int NOT NULL,
  `rate_space` int NOT NULL,
  `rate_location` int NOT NULL,
  `rate_price` int NOT NULL,
  PRIMARY KEY (`id_rating`),
  KEY `id_user_2_idx` (`id_user`),
  KEY `id_store_3_idx` (`id_store`),
  CONSTRAINT `id_store_3` FOREIGN KEY (`id_store`) REFERENCES `user` (`id_user`),
  CONSTRAINT `id_user_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (11,1,8,2,'2022-09-01 09:49:16','0000-00-00 00:00:00',0,0,0,0),(12,5,8,2,'2022-09-10 07:13:45','2022-09-10 07:13:45',2,2,2,2),(14,5,8,3,'2022-09-11 00:41:24','2022-09-11 00:42:37',5,5,5,5);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_frame`
--

DROP TABLE IF EXISTS `time_frame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_frame` (
  `id_time_frame` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `from` datetime NOT NULL,
  `to` datetime NOT NULL,
  PRIMARY KEY (`id_time_frame`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_frame`
--

LOCK TABLES `time_frame` WRITE;
/*!40000 ALTER TABLE `time_frame` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_frame` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'All day'),(2,'Morning'),(3,'Noon'),(4,'Afternoon'),(5,'Evening'),(6,'Night'),(7,'Custom');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `name_store` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'b''null''',
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'b''null''',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'b''null''',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'b''null''',
  `user_role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'b''null''',
  `active` bit(1) NOT NULL DEFAULT b'1',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'b''null''',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'b''null''',
  `ship_price` float DEFAULT NULL,
  `user_iframe` longtext COLLATE utf8mb4_unicode_520_ci,
  `is_delete` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_name_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `id_role_1_idx` (`user_role`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',NULL,'b\'null\'','b\'null\'','b\'null\'','b\'null\'','ROLE_ADMIN',_binary '','b\'null\'','2022-08-21 15:16:21','2022-08-21 15:16:21','b\'null\'',0,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(2,'store1','$2a$10$spXEJiQNKxG4AdcaE5lOTOnGoaUY5F0e84LMS5F1YSHEw/gUyhBsS','Bánh 9 Sạch - Bánh Sầu Riêng - Lê Văn Thọ','Nguyen Thi ','A','01234567891','312 Lê Văn Thọ, P. 11,  Quận Gò Vấp, TP. HCM','ROLE_STORE',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1661070888/tyno4acrhpalla4cqglw.jpg','2022-08-21 08:34:42','2022-09-11 00:37:06','store1@gmail.com',5000,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(3,'store2','$2a$10$Q4xT9ekYNYpON0Cbj6KS6.03MeimU9jmPsguQi5JxN/7TtXYqHwgS','Mì Dầu Hào Chả Cá HongKong Thượng Hạng - 港式蚝油捞面','Nguyen Van','B','01234567892','28 Phan Phú Tiên, P. 10,  Quận 5, TP. HCM','ROLE_STORE',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1661071989/ws4l2k5ulzids9hzdwcd.jpg','2022-08-21 08:53:04','2022-08-21 08:53:04','store2@gmail.com',0,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(4,'store3','$2a$10$pZI0H3k0xvV9yFRDZ3k5WuQQpN5Fi8vA/Jlkb/d2yMLOytfID65Be','GABO - Tré Trộn - Âu Cơ','Nguyen Thi','C','01234567893','403 Âu Cơ, P. Phú Trung,  Quận Tân Phú, TP. HCM','ROLE_STORE',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1661072195/oxypumepgrpommgb7spg.jpg','2022-08-21 08:56:31','2022-08-21 08:56:31','store3@gmail.com',0,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(5,'store4','$2a$10$yuEVZVCX1TH7klzMIGWQCetvbPiI.qeTL123.LUXeaeZwKpDZexnS','Chè Út Lyly - Nguyễn Trọng Tuyển','Nguyen Thi','D','01234567894','384 Nguyễn Trọng Tuyển, P. 2,  Quận Tân Bình, TP. HCM','ROLE_STORE',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1661072318/rhm2vaw3sxwbmi19i7w5.jpg','2022-08-21 08:58:33','2022-08-21 08:58:33','store4@gmail.com',0,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(6,'store5','$2a$10$BBYqfbm4ai9i3H5MAmZZr.flYybjM.LsxRfXTLNoPyjevE3Z0XKXW','Wrap&Roll - Gigamall','Nguyen Van','E','01234567895','Tầng 3,  Tầng 3 Giga Mall, 240 Phạm Văn Đồng, P. Hiệp Bình Chánh,  Tp. Thủ Đức, TP. HCM','ROLE_STORE',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1661072407/pe3e60y9cvxacexpgsec.jpg','2022-08-21 09:00:02','2022-08-21 09:00:02','store5@gmail.com',0,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(7,'store6','$2a$10$k3Ay5eDUNCiotVBKfbZbLequeX7F0rMtlPrCiseW1Z63fjWKcJcD6','Tiệm Ăn Vặt Bột Béo & Chân Gà Sốt Thái - Trần Trọng Cung','Nguyen Thi','F','01234567896','37/17 Trần Trọng Cung, P. Tân Thuận Đông,  Quận 7, TP. HCM','ROLE_STORE',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1661072469/y5c1frbkfpj2lacpek5y.jpg','2022-08-21 09:01:05','2022-08-21 09:01:05','store6@gmail.com',0,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(8,'user1','$2a$10$dbgtOsCFfOM6/HUq7RK.quztsinFmdCyuZIB69yjhQR4SqFYZ7lKO',NULL,'Nguyễn','Lâmm','0326397949','20/2 Pham Huy Thong','ROLE_USER',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1662793656/glyqabewgigyrksvlvax.jpg','2022-08-22 08:04:57','2022-09-10 07:07:35','1951052098lam@ou.edu.vn',NULL,'<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.7180676960506!2d106.6797885154033!3d10.832874261109993!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528ff4f900fe3%3A0x1ce13516cdd6e921!2zMjAgUGjhuqFtIEh1eSBUaMO0bmcsIFBoxrDhu51uZyA3LCBHw7IgVuG6pXAsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1662123704470!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>',_binary '\0'),(26,'storedemo','$2a$10$XJazqiRa6gf78DTqUDlzm.Z.CgG511rQVrxXHrW6HGz9g0MONo9T.','Sting Trung','Lam','Nguyen','0231562345','20/2 Pham Huy Thong','ROLE_STORE',_binary '','https://res.cloudinary.com/djgexdpxq/image/upload/v1662859845/wgjc7mp8g8qfapd0nn0j.jpg','2022-09-11 01:30:26','2022-09-11 01:30:26','exlovevnvn@gmail.com',NULL,NULL,_binary '\0');
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

-- Dump completed on 2022-09-12 21:53:49
