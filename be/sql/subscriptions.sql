CREATE TABLE `subscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `perMonth` int(11) DEFAULT NULL,
  `perThreeMonths` int(11) DEFAULT NULL,
  `perYear` int(11) DEFAULT NULL,
  `isBanned` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;