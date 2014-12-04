/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : cart

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2014-12-04 10:42:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('4', 'hjkhkhk', '3500', 'img/2.jpg');
INSERT INTO `cart` VALUES ('9', 'ppp', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('10', 'pp', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('11', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('12', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('13', 'face', '100', 'img/3.jpg');
INSERT INTO `cart` VALUES ('14', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('15', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('16', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('17', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('18', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('19', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('20', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('21', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('22', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('23', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('24', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('25', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('26', 'phone1', '3500', 'img/3.jpg');
INSERT INTO `cart` VALUES ('27', 'phone1', '3500', 'img/3.jpg');
