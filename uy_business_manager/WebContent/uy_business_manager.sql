/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : uy_business_manager

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2014-12-04 20:30:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `userpass` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456', '1');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('4', 'hjkhkhk', '3500', 'img/2.jpg');
INSERT INTO `goods` VALUES ('9', 'ppp', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('10', 'pp', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('11', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('12', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('13', 'face', '100', 'img/3.jpg');
INSERT INTO `goods` VALUES ('14', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('15', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('16', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('17', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('18', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('19', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('20', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('21', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('22', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('23', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('24', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('25', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('26', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `goods` VALUES ('27', 'phone1', '3500', 'img/3.jpg');
