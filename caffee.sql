/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : caffee

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-06-29 15:44:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `ad_ID` varchar(255) NOT NULL,
  `ad_password` varchar(255) NOT NULL,
  `ad_tele` varchar(255) DEFAULT NULL,
  `ad_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ad_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `amount` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_ID` int NOT NULL,
  `user_ID` varchar(255) NOT NULL,
  `food_name` varchar(255) NOT NULL,
  `food_price` decimal(10,2) NOT NULL,
  `food_amount` varchar(255) NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`order_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `cart_ID` int NOT NULL,
  `user_ID` varchar(255) NOT NULL,
  `food_name` varchar(255) NOT NULL,
  `food_amount` int NOT NULL,
  `food_price` decimal(10,2) NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`cart_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_ID` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_tele` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('110', '110', '15005036023', '12345678@qq.com');
