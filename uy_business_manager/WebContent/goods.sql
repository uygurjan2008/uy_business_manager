/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : goods

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2014-12-03 21:43:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` char(6) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` char(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('110001', 'admin', '123456');

-- ----------------------------
-- Table structure for `apply`
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(30) DEFAULT NULL,
  `specialtyId` char(3) DEFAULT NULL,
  `reason` varchar(500) DEFAULT NULL,
  `flag` char(1) DEFAULT '0',
  `teaId` char(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `spe_fk` (`specialtyId`),
  KEY `tea_fk` (`teaId`),
  CONSTRAINT `tea_fk` FOREIGN KEY (`teaId`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `spe_fk` FOREIGN KEY (`specialtyId`) REFERENCES `specialty` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('1', 'C语言', '101', '测试', '1', '1001');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` char(6) NOT NULL DEFAULT '',
  `name` varchar(30) DEFAULT NULL,
  `specialtyId` char(3) DEFAULT NULL,
  `teacherId` char(4) DEFAULT NULL,
  `credit` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cou_spec` (`specialtyId`),
  KEY `cou_tea` (`teacherId`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`specialtyId`) REFERENCES `specialty` (`id`),
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('100001', '外语', '101', '1001', '10');
INSERT INTO `course` VALUES ('100002', 'C语言', '101', '1001', '10');

-- ----------------------------
-- Table structure for `dbusers`
-- ----------------------------
DROP TABLE IF EXISTS `dbusers`;
CREATE TABLE `dbusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text,
  `userpass` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dbusers
-- ----------------------------
INSERT INTO `dbusers` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `goods_in`
-- ----------------------------
DROP TABLE IF EXISTS `goods_in`;
CREATE TABLE `goods_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `price` int(11) DEFAULT NULL,
  `description` text,
  `etc` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_in
-- ----------------------------
INSERT INTO `goods_in` VALUES ('1', 'name1', '12', 'cell', 'etc');
INSERT INTO `goods_in` VALUES ('37', '1', '1', '1', null);
INSERT INTO `goods_in` VALUES ('38', '2', '2', '2', null);
INSERT INTO `goods_in` VALUES ('39', '2', '2', '2', null);
INSERT INTO `goods_in` VALUES ('40', '3', '3', '3', null);

-- ----------------------------
-- Table structure for `specialty`
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty` (
  `id` char(3) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `assistant` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialty
-- ----------------------------
INSERT INTO `specialty` VALUES ('101', '计算机科学', '张三');
INSERT INTO `specialty` VALUES ('102', '电子商务', '李二');
INSERT INTO `specialty` VALUES ('103', '网络工程', '李武');
INSERT INTO `specialty` VALUES ('104', '日语', '丽丽');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` char(8) NOT NULL,
  `password` char(6) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `specialtyId` char(3) DEFAULT NULL,
  `sex` set('女','男') DEFAULT NULL,
  `credit` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `stu_spec` (`specialtyId`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`specialtyId`) REFERENCES `specialty` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20112033', '123456', '李三', '101', '女', '10');
INSERT INTO `student` VALUES ('20112034', '123456', '李二', '101', '男', '0');
INSERT INTO `student` VALUES ('20112035', '123456', '学生1', '101', '女', '0');

-- ----------------------------
-- Table structure for `stu_cour`
-- ----------------------------
DROP TABLE IF EXISTS `stu_cour`;
CREATE TABLE `stu_cour` (
  `stuId` char(8) NOT NULL DEFAULT '',
  `courId` char(6) NOT NULL DEFAULT '',
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuId`,`courId`),
  KEY `cour_fk` (`courId`),
  CONSTRAINT `cour_fk` FOREIGN KEY (`courId`) REFERENCES `course` (`id`),
  CONSTRAINT `stu_fk` FOREIGN KEY (`stuId`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_cour
-- ----------------------------
INSERT INTO `stu_cour` VALUES ('20112033', '100001', '89');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` char(4) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` char(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1001', '教师A', '123456');
INSERT INTO `teacher` VALUES ('1002', '教师B', '123456');
