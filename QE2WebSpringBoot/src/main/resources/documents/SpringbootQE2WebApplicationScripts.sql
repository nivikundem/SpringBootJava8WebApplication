/*
SpringbootQE2WebApplication Scripts 18022017
*/


DROP TABLE IF EXISTS `qe2_bridge`.`bridge_crossing_performance`;
CREATE TABLE  `qe2_bridge`.`bridge_crossing_performance` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `gate_number` varchar(45) NOT NULL DEFAULT '',
  `vehicle_type` varchar(45) NOT NULL DEFAULT '',
  `direction` varchar(45) NOT NULL DEFAULT '',
  `vrn` varchar(45) NOT NULL DEFAULT '',
  `crossing_datetime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `crossing_date_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `qe2_bridge`.`proxama_api_table`;
CREATE TABLE  `qe2_bridge`.`proxama_api_table` (
  `keyname` varchar(255) NOT NULL,
  `keyvalue` varchar(255) DEFAULT NULL,
  `token` bigint(20) NOT NULL,
  PRIMARY KEY (`keyname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `qe2_bridge`.`token_registration_table`;
CREATE TABLE  `qe2_bridge`.`token_registration_table` (
  `token` bigint(20) NOT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `qe2_bridge`.`vehicle_details`;
CREATE TABLE  `qe2_bridge`.`vehicle_details` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vrn` varchar(45) NOT NULL DEFAULT '',
  `vehicle_type` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `qe2_bridge`.`vehicleownerdetails`;
CREATE TABLE  `qe2_bridge`.`vehicleownerdetails` (
  `UID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `VRN` varchar(45) NOT NULL DEFAULT '',
  `NAME` varchar(45) NOT NULL DEFAULT '',
  `POSTCODE` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;