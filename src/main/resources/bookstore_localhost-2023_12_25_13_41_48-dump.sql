-- MySQL dump 10.13  Distrib 8.0.34, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL,
  `author` varchar(250) NOT NULL,
  `cover_image` varchar(1500) DEFAULT NULL,
  `description` varchar(1500) NOT NULL,
  `featured` tinyint(1) DEFAULT '0',
  `isbn` varchar(50) DEFAULT NULL,
  `price` decimal(38,2) NOT NULL,
  `qty` int NOT NULL,
  `title` varchar(250) NOT NULL,
  `sub_cat_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfua2os40qawenk3emvpu0ik80` (`sub_cat_id`),
  CONSTRAINT `FKfua2os40qawenk3emvpu0ik80` FOREIGN KEY (`sub_cat_id`) REFERENCES `sub_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Frank Herbert','https://storage.googleapis.com/online-bookstore-2b94e.appspot.com/Dune%20Messiah-9780593098233?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=firebase-adminsdk-pr0bx%40online-bookstore-2b94e.iam.gserviceaccount.com%2F20231225%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20231225T062957Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=58654ff6783b1d9e1f42b67a1e8483529a9d68fdf78620ffba0e89f3f34db37f5de99963e9d5c6a840bed9162f02e409d95483bb60e95f3916f4eeeb0eba5adc210a5f7ccb0f99bd07a4b668546b459a76253cb6a98e8d9339507dbff24d0fbf5edf343c6013a343b385d36d8ace896b89dd33289d3315c8e22afae443c6c0482339dd47f4b65bfb651fa583f5347352315f21402342c361a24932b077d43817dcf33c306a2b6a2c8322854efad70e7e42d93f61d58514bbebfac5021e31b541fa0830c0200aa5d4b5cf7c193961a44375399646926971311ef0b8f8c154b24f34761bd04a93b6c57bbbd84a93784d4a4aa457fbce5968beda3dd66f1227ca65','Dune Messiah continues the story of Paul Atreides, better known and feared as the man christened MuadDib. As Emperor of the known universe, he possesses more power than a single man was ever meant to wield. Worshipped as a religious icon by the fanatical Fremen, Paul faces the enmity of the political houses he displaced when he assumed the throne and a conspiracy conducted within his own sphere of influence.',NULL,'9780593098233',2790.00,5,'Dune Messiah',4),(2,'Holly Jackson','https://storage.googleapis.com/online-bookstore-2b94e.appspot.com/Five%20Survive-9780008507237?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=firebase-adminsdk-pr0bx%40online-bookstore-2b94e.iam.gserviceaccount.com%2F20231225%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20231225T065151Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=3413e5608baf1f43b0b3f0537bf4bca19967860ed3b90e4c1028ef68f5970ba7170bade11317def2fe3d9c1f1d9b2027575c5cf52790b04304bda7e3197dbf7ce498629f9336153775b16213ecf69ff7a5ea56f9b35f83633eb6de26151dc6e1bbe64b362cdcd3cb5a7473bac65c512699143459b9c78131b3a23bed324c00eb7b8421e30a09554d79a9dfb12593a23ead434b98dfaa3d99a2efe8b6829be8bbb131f7b08b64d5b4b384fa73011a9efce225afa33544392b534dcf4195a3d69390625426579214e68e84d097a69d16ef980d7488a82741ad579a0cc01a7e9b495b53dcb13f07514dacbf1069a5ec13967d4369dec869b7ca91da9e7d1c4d36ba','Red Kenny is on a road trip for spring break with five friends: Her best friend the older brother his perfect girlfriend a secret crush a classmate and a killer. When their RV breaks down in the middle of nowhere with no cell service, they soon realize this is no accident. They have been trapped by someone out there in the dark, someone who clearly wants one of them dead. With eight hours until dawn, the six friends must escape, or figure out which of them is the target. But is there a liar among them? Buried secrets will be forced to light and tensions inside the RV will reach deadly levels. Not all of them will survive the night.',NULL,'9780008507237',2590.00,20,'Five Survive',3),(3,'Christopher Paolini','https://storage.googleapis.com/online-bookstore-2b94e.appspot.com/Fractal%20Noise-9781035001125?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=firebase-adminsdk-pr0bx%40online-bookstore-2b94e.iam.gserviceaccount.com%2F20231225%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20231225T065645Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=159edfc512bd25a6871fb1214a85c067f7a6ab51ba12934d8cd6288fcbc1fde808f88e4573398bed7d7c2bced9f38d85486629fe64ed564a7b8f281a3704e698aeb5987022d3d1cb7daae828aae43bb3043cdbd8064c9c582a8544032cce2beac13da8be886e7ad99660bf6924e337e12de0259b326284a584771f228c287a9a841121235f884100be4c152586a9c1b31cd9015d77ae9069f944843f3e0e96a36d4fc2fa0b8624734fdbeca162d1efc1715d7e678df8da48c49af0cda1cc6fa7dd5017f62af0755d0895b0d532e70ed64cfb8e8125908786b2dff411e62195d0f0a179923a0ca43e9560c8fae40306dd24a754e0062fcdd7346398fd4e3d1248','Fractal Noise is the thrilling prequel to the masterful space opera To Sleep in a Sea of Stars by internationally bestselling author of Eragon, Christopher Paolini. On the planet Talos VII, twenty three years before the events of To Sleep in a Sea of Stars, an anomaly is detected: a vast circular pit, with dimensions so perfect that it could only have been the result of conscious design. So a small team is assembled to learn more perhaps even who built the hole and why. Their mission will take them on a hazardous trek to the very edge of existence. For one explorer, this is the opportunity of a lifetime. For another, a risk not worth taking. And for xenobiologist Alex Crichton, its a desperate attempt to find meaning in an uncaring universe. But every step they take towards that mysterious abyss is more punishing than the last. Ultimately, no one is prepared for what they will encounter.',NULL,'9781035001125',3490.00,5,'Fractal Noise',4),(4,'Carl G Jung','https://storage.googleapis.com/online-bookstore-2b94e.appspot.com/Man%20and%20His%20Symbols-9780440351832?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=firebase-adminsdk-pr0bx%40online-bookstore-2b94e.iam.gserviceaccount.com%2F20231225%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20231225T070200Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=2a4ac60bef08407efbd49330ea6eeabc96ee15ecf17f908a302c6e8374c2bd4b36a467af6cd0bda753ce1dd8f589e5a0672258c27fc3de54137a41ecca803cc1aa9b6ac932c98459717163dcc1b4a59dd2702f337574ab86d2b767967ff9c82d08a321b0e3d8f8f4c2d6f13e766f2e7ffe6d3019ee5003f2ad5cd452d54e9021ab47091295d6b45fb4f180b273c696861a7ea261c2f2084f1619f88ebde99b8172c32741d13fbe6cea825894e77d7ed8ece04df3544e4180476dfd8f2d1dd50fa0d309e04981785bfbde86433d3337afcff77fb5c5e96890dee522f6ccd99ca25708a34a35528618f901711917a68faee6470c79e57f998f08dc5cacd5657afd','The landmark text about the inner workings of the unconscious mind from the symbolism that unlocks the meaning of our dreams to their effect on our waking lives and artistic impulses featuring more than a hundred updated images that break down Carl G. Jungs revolutionary ideas. What emerges with great clarity from the book is that Jung has done immense service both to psychology as a science and to our general understanding of man in society. The Guardian Our psyche is part of nature, and its enigma is limitless. Since our inception, humanity has looked to dreams for guidance. But what are they? How can we understand them? And how can we use them to shape our lives? There is perhaps no one more equipped to answer these questions than the legendary psychologist Carl G. Jung. It is in his lifes work that the unconscious mind comes to be understood as an expansive, rich world that is just as vital and true as the conscious mind, and it is in our dreams those integral expressions of our deepest selves that the unconscious communicates itself to us. Man and His Symbols offers us invaluable insight into the symbols we dream that demand understanding, into how they affect our lives, and into why we seek meaning in them at all. It is a seminal text, written explicitly for the general reader, full of fascinating case studies and examples pulled from a variety of surprising sources, that proves to be decades after its conception a relevatory, absorbing, and relevant experience.',NULL,'9780440351832',2490.00,17,'Man and His Symbols',3),(5,'Yoko Ogawa','https://storage.googleapis.com/online-bookstore-2b94e.appspot.com/Memory-9781784700447?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=firebase-adminsdk-pr0bx%40online-bookstore-2b94e.iam.gserviceaccount.com%2F20231225%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20231225T071300Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=6b9ff3b439c7fb5a6094223a6668a4edc240f2987871d15014f370dfd96ca332d5a0ddb2f011ffe445beebbf125de1b56c79141ebe93fd11d8728deabf2a6448710f53f2825012ebe78b2bb7330ba363ed456b56b8286862c20c4184f7ba38a0ec265da698cd8aba30a2a5005544150664daa740d862b28f8f7477b25bc86090749ceab1d2b59be5ebd27e2700a7c03742b8c46443db17770cbbf87d8f1392b0438591708420d5fd3b946461019d3b435bb9708c6d8ba57d69cd5022ca9491dc8f9f25b2de1c4f6d9e01123a0e6f92cba2515b9303bad856a36793e36768401032c02e655589ff3dde83f0375e7712c7a4d0ae5343ebedf1e9f67459ec183452','Discover the International Booker Prize shortlisted novel, an enthralling Orwellian story about the terrors of state surveillance from one of Japans greatest writers. Beautiful Haunting Sunday Times A dreamlike story of dystopia Jia Tolentino Hat, ribbon, bird rose. To the people on the island, a disappeared thing no longer has any meaning. It can be burned in the garden, thrown in the river or handed over to the Memory Police. Soon enough, the island forgets it ever existed. When a young novelist discovers that her editor is in danger of being taken away by the Memory Police, she desperately wants to save him. For some reason, he doesnt forget, and its becoming increasingly difficult for him to hide his memories. Who knows what will vanish next Finalist for the National Book Award 2019. Longlisted for the Translated Book Award 2020, New York Times 100 Notable Books of the Year. This timeless fable of control and loss feels more timely than ever Guardian. Echoes the themes of George Orwells 1984, but it has a voice and power all its own Time',NULL,'9781784700447',2790.00,19,'Memory',2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_seq`
--

DROP TABLE IF EXISTS `book_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_seq`
--

LOCK TABLES `book_seq` WRITE;
/*!40000 ALTER TABLE `book_seq` DISABLE KEYS */;
INSERT INTO `book_seq` VALUES (101);
/*!40000 ALTER TABLE `book_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL,
  `cat_name` varchar(250) NOT NULL,
  `description` varchar(750) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Novels','Discover a captivating world within the Novel section of our bookshop, where each turn of the page leads to new adventures and diverse characters. From timeless classics to contemporary tales, immerse yourself in the art of storytelling and explore the boundless realms of imagination.'),(2,'Short Stories','Embark on a literary journey through our Short Stories section, where every tale is a concise masterpiece, offering a spectrum of emotions in compact narratives. From heartwarming anecdotes to spine-tingling twists, these bite-sized gems promise to captivate readers with the artistry of brevity.'),(3,'Life Skills','Embark on a literary journey through our Short Stories section, where every tale is a concise masterpiece, offering a spectrum of emotions in compact narratives. From heartwarming anecdotes to spine-tingling twists, these bite-sized gems promise to captivate readers with the artistry of brevity.');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_seq`
--

DROP TABLE IF EXISTS `category_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_seq`
--

LOCK TABLES `category_seq` WRITE;
/*!40000 ALTER TABLE `category_seq` DISABLE KEYS */;
INSERT INTO `category_seq` VALUES (101);
/*!40000 ALTER TABLE `category_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `status` varchar(50) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcpl0mjoeqhxvgeeeq5piwpd3i` (`user_id`),
  CONSTRAINT `FKcpl0mjoeqhxvgeeeq5piwpd3i` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2023-12-25 12:52:48.609156','completed','2023-12-25 12:52:48.609184',1),(2,'2023-12-25 12:52:58.807645','completed','2023-12-25 12:52:58.807667',3),(3,'2023-12-25 12:53:07.909305','completed','2023-12-25 12:53:07.909318',1),(4,'2023-12-25 12:57:47.772054','completed','2023-12-25 12:57:47.772067',1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_book`
--

DROP TABLE IF EXISTS `order_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_book` (
  `order_id` int NOT NULL,
  `book_id` int NOT NULL,
  PRIMARY KEY (`order_id`,`book_id`),
  KEY `FK9yvsui1wgflf4dy9q77rsl280` (`book_id`),
  CONSTRAINT `FK9yvsui1wgflf4dy9q77rsl280` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKb83pmdlor5nyte1i1ffpmd31e` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_book`
--

LOCK TABLES `order_book` WRITE;
/*!40000 ALTER TABLE `order_book` DISABLE KEYS */;
INSERT INTO `order_book` VALUES (1,2),(2,2),(4,2),(1,3),(2,3),(2,4),(3,4);
/*!40000 ALTER TABLE `order_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_seq`
--

DROP TABLE IF EXISTS `order_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_seq`
--

LOCK TABLES `order_seq` WRITE;
/*!40000 ALTER TABLE `order_seq` DISABLE KEYS */;
INSERT INTO `order_seq` VALUES (101);
/*!40000 ALTER TABLE `order_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_category` (
  `id` int NOT NULL,
  `description` varchar(750) NOT NULL,
  `sub_cat_name` varchar(250) NOT NULL,
  `cat_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKemfcytmpyjt4q3j8248klx889` (`cat_id`),
  CONSTRAINT `FKemfcytmpyjt4q3j8248klx889` FOREIGN KEY (`cat_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (1,'Dive into the heartwarming tales and insightful guides of our Family section, where stories of love, resilience, and connection come to life. Explore the intricacies of family dynamics and find inspiration for building stronger bonds that withstand the tests of time.','Family',1),(2,'Indulge in the enchanting world of romance with our Love Stories section, where passion, heartache, and enduring connections unfold in every book. From classic tales of timeless love to contemporary romances that tug at the heartstrings, find your perfect escape into the realms of affection and desire.','Love Stories',1),(3,'Experience pulse-pounding suspense and gripping narratives in our Thriller section, where every page keeps you on the edge of your seat. From cunning detectives solving mysteries to heart-stopping plots with unexpected twists, immerse yourself in a world of intrigue and danger.','Thriller',2),(4,'Embark on thrilling journeys to distant galaxies and explore futuristic realms with our Science Fiction section. From mind-bending adventures to thought-provoking tales of technology and the unknown, let your imagination soar in the vast universe of speculative fiction.','Science Fiction',1),(5,'Delve into the spine-chilling realm of our Horror section, where shadows come to life and nightmares lurk between the pages. From classic tales of supernatural terror to modern psychological thrillers, brace yourself for a chilling journey that will haunt your imagination long after the book is closed.','Horror',2),(6,'Unleash the power of laughter with our Comedy section, where humor takes center stage in a collection of witty tales and hilarious escapades. From witty observations to uproarious anecdotes, these books promise a lighthearted escape into the joyous world of comedy.','Comedy',2),(7,'Navigate the path to financial well-being with our Personal Finance section, offering practical guides and insightful advice to empower your financial journey. From budgeting basics to strategic investment tips, discover the keys to financial success and secure a more stable future.','Personal Finance',3),(8,'Unlock the secrets of success and innovation in our Business section, where practical insights and strategic wisdom converge. From entrepreneurial guides to leadership principles, delve into a wealth of knowledge that will inspire and elevate your professional endeavors.','Business',3);
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_category_seq`
--

DROP TABLE IF EXISTS `sub_category_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_category_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category_seq`
--

LOCK TABLES `sub_category_seq` WRITE;
/*!40000 ALTER TABLE `sub_category_seq` DISABLE KEYS */;
INSERT INTO `sub_category_seq` VALUES (101);
/*!40000 ALTER TABLE `sub_category_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile_number` varchar(50) NOT NULL,
  `name` varchar(250) NOT NULL,
  `state` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `zip_code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Colomo','Sri Lanka','kumara@gmail.com','011-1234567','Kumara Samaranayake','Western','Temple Street','12345'),(2,'Lake Breanamouth','Saint Pierre and Miquelon','Adolf_Bradtke@gmail.com','077-1234567','Jerry Ziemann PhD','Western','Camylle Fort','12356'),(3,'Minot','Turkey','Cecilia_Pfannerstill@gmail.com','071-7658364','Jackie Klocko','Nothern','Kuphal Rest','32356');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (101);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-25 13:41:48
