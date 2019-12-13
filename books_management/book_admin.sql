/*
Navicat MySQL Data Transfer

Source Server         : bookSQL
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : book_admin

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-12-13 19:18:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(15) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `admin_phone` varchar(255) NOT NULL,
  `admin_password` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123456789', '123456789', '123456789');
INSERT INTO `admin` VALUES ('2', '1', '1', '1');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(15) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `book_writer` varchar(255) NOT NULL,
  `book_publish` varchar(255) NOT NULL,
  `book_status` varchar(255) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '高等数学', '张宇', '清华大学出版社', '0');
INSERT INTO `book` VALUES ('2', 'C语言', '郭天祥', '北京出版社', '1');
INSERT INTO `book` VALUES ('3', 'Java2', '张跃平', '同济大学出版社', '0');
INSERT INTO `book` VALUES ('4', 'JavaWeb', '耿一', '同济大学出版社', '0');
INSERT INTO `book` VALUES ('5', '鸟哥的Linux私房菜', '鸟哥', '机械工业出版社', '0');
INSERT INTO `book` VALUES ('6', 'MySQL必知必会', '刘晓霞', '人民邮电出版社', '0');

-- ----------------------------
-- Table structure for book_information
-- ----------------------------
DROP TABLE IF EXISTS `book_information`;
CREATE TABLE `book_information` (
  `book_id` int(50) NOT NULL,
  `reader_name` varchar(255) NOT NULL,
  `borrow_data` varchar(255) DEFAULT NULL,
  `return_data` varchar(255) DEFAULT NULL,
  `book_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_information
-- ----------------------------
INSERT INTO `book_information` VALUES ('2', '1', null, null, '1');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `reader_id` int(50) NOT NULL,
  `reader_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reader _phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reader_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`reader_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('1', '123', '123', '123');
INSERT INTO `reader` VALUES ('2', '1234', '1234', '1234');
INSERT INTO `reader` VALUES ('3', '12345', '12345', '12345');
INSERT INTO `reader` VALUES ('123', '123', '123', '123');
INSERT INTO `reader` VALUES ('1234', '1234', '123', '1234');
