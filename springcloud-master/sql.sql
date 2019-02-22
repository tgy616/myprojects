CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `clouddb01`.`dept` (`deptno`, `dname`, `db_source`) VALUES ('1', '开发部', 'DATABASE()');
INSERT INTO `clouddb01`.`dept` (`deptno`, `dname`, `db_source`) VALUES ('2', '人事部', 'DATABASE()');
INSERT INTO `clouddb01`.`dept` (`deptno`, `dname`, `db_source`) VALUES ('3', '财务部', 'DATABASE()');
INSERT INTO `clouddb01`.`dept` (`deptno`, `dname`, `db_source`) VALUES ('4', '市场部', 'DATABASE()');
INSERT INTO `clouddb01`.`dept` (`deptno`, `dname`, `db_source`) VALUES ('5', '运维部', 'DATABASE()');
