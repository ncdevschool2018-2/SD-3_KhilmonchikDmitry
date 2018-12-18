CREATE TABLE `subscription_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subscriptionId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `billingAccountId` int(11) DEFAULT NULL,
  `daysLeft` int(11) DEFAULT NULL,
  `willBeRenewed` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `creationDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `writeOffDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `subscriptionId` (`subscriptionId`),
  KEY `billingAccountId_idx` (`billingAccountId`),
  KEY `userAccountId_idx` (`userId`),
  CONSTRAINT `billingAccountId` FOREIGN KEY (`billingAccountId`) REFERENCES `billing_account` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `subscriptionId` FOREIGN KEY (`subscriptionId`) REFERENCES `subscription` (`id`),
  CONSTRAINT `userAccountId` FOREIGN KEY (`userId`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;