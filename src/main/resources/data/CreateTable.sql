/*
Navicat MySQL Data Transfer

Source Server         : VM-10.102.66.82
Source Server Version : 50621
Source Host           : 10.102.66.82:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2014-11-12 12:02:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `firstname` varchar(50) DEFAULT NULL COMMENT '名',
  `lastname` varchar(50) DEFAULT NULL COMMENT '姓',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `money` decimal(10,0) DEFAULT '0' COMMENT '存款',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for demotbl
-- ----------------------------
DROP TABLE IF EXISTS `demotbl`;
CREATE TABLE `demotbl` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `tname` varchar(32) DEFAULT NULL,
  `tpwd` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tname` (`tname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `stu_id` varchar(255) NOT NULL COMMENT '学号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `cls_id` varchar(255) DEFAULT NULL COMMENT '班号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `studentId` (`stu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for test_proceduce
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_proceduce`;
DELIMITER ;;
CREATE DEFINER=`gordon`@`%` PROCEDURE `test_proceduce`()
BEGIN
		SELECT * FROM users;
		SELECT * FROM customer;
	END
;;
DELIMITER ;
