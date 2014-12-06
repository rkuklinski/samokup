use 15841633_0000002;

drop table if exists `USERS`;
drop table if exists `USERPASSWORDS`;
drop table if exists `ROLES`;


CREATE TABLE if not exists `USERS` (
  `email` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(20) NOT NULL DEFAULT '',
  `role` varchar(20) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE if not exists `USERPASSWORDS` (
  `email` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(72) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
CREATE TABLE if not exists `ROLES` (
  `email` varchar(20) NOT NULL DEFAULT '',
  `role` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`email`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
commit;