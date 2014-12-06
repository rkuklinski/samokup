use 15841633_0000002;

drop table if exists `QUERY`;

CREATE TABLE if not exists `QUERY` (
  `id` integer NOT NULL,
  `queryText` varchar(2000) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
commit;