create TABLE `member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(200) DEFAULT NULL,
  `grade` varchar(10) NOT NULL,
  `createdAt` DATETIME(1) DEFAULT NULL,
  `updatedAt` DATETIME(1) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create TABLE `group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(200) DEFAULT NULL,
  `createdAt` datetime(1) DEFAULT NULL,
  `updatedAt` datetime(1) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;