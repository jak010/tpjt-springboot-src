create TABLE `Member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(200) DEFAULT NULL,
  `createdAt` DATETIME(1) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;