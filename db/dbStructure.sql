create database if not exists SpringSecurity;
#Sample from http://www.journaldev.com/2715/spring-security-in-servlet-web-application-using-dao-jdbc-in-memory-authentication
 
use SpringSecurity;

drop table if exists `Users`;
drop table if exists `UserPasswords`;
drop table if exists `Roles`;


CREATE TABLE if not exists `Users` (
  `email` varchar(20) NOT NULL DEFAULT '',
  `username` varchar(20) NOT NULL DEFAULT '',
  `role` varchar(20) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE if not exists `UserPasswords` (
  `email` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(72) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
CREATE TABLE if not exists `Roles` (
  `email` varchar(20) NOT NULL DEFAULT '',
  `role` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`email`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
commit;