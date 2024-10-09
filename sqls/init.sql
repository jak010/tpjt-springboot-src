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

CREATE TABLE `group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(200) DEFAULT NULL,
  `createdAt` datetime(1) DEFAULT NULL,
  `updatedAt` datetime(1) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


show create table sample.`group`;CREATE TABLE `group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(200) DEFAULT NULL,
  `createdAt` datetime(1) DEFAULT NULL,
  `updatedAt` datetime(1) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO sample.`group` (group_name, createdAt, updatedAt) VALUES('test1', '2024-10-09', '2024-10-09');

INSERT INTO sample.`member` (nick_name, group_id, grade, createdAt, updatedAt) VALUES('user1', 6, 'NORMAL', '2024-10-09', '2024-10-09');
INSERT INTO sample.`member` (nick_name, group_id, grade, createdAt, updatedAt) VALUES('user2', 6, 'NORMAL','2024-10-09', '2024-10-09');
INSERT INTO sample.`member` (nick_name, group_id, grade, createdAt, updatedAt) VALUES('user3', 6, 'NORMAL','2024-10-09', '2024-10-09');