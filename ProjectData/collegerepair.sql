/*
Navicat MySQL Data Transfer

Source Server         : MyConnection
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : collegerepair

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-07-08 01:35:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `repair_item`
-- ----------------------------
DROP TABLE IF EXISTS `repair_item`;
CREATE TABLE `repair_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `item_phone` varchar(20) DEFAULT NULL,
  `item_address` varchar(50) DEFAULT NULL,
  `item_time` varchar(20) DEFAULT NULL,
  `item_desc` varchar(100) DEFAULT NULL,
  `item_type` int(11) DEFAULT NULL,
  `item_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair_item
-- ----------------------------
INSERT INTO `repair_item` VALUES ('1', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('2', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('3', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('4', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('5', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('6', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('7', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('8', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('9', '1', null, '中山大道西293', null, 'aaaaa', '1', '1');
INSERT INTO `repair_item` VALUES ('10', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('11', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('12', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('13', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('14', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('15', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('16', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('17', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('18', '2', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('19', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('20', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('21', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('22', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('23', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('24', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('25', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('26', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('27', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('28', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('29', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');
INSERT INTO `repair_item` VALUES ('30', '1', null, '中山大道西293', null, 'aaaaa', '1', '0');

-- ----------------------------
-- Table structure for `repair_log`
-- ----------------------------
DROP TABLE IF EXISTS `repair_log`;
CREATE TABLE `repair_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `log_time` varchar(20) DEFAULT NULL,
  `log_type` int(11) DEFAULT NULL,
  `log_msg` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair_log
-- ----------------------------
INSERT INTO `repair_log` VALUES ('1', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('2', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('3', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('4', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('5', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('6', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('7', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('8', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('9', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('10', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('11', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('12', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('13', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('14', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('15', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('16', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('17', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('18', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('19', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('20', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('21', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('22', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('23', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('24', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('25', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('26', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('27', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('28', null, null, null, null, null);
INSERT INTO `repair_log` VALUES ('29', null, null, null, null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(20) NOT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_sex` int(11) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  `user_manager` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '林安成', '1', '13560487066', '中山大道西293', '1');
INSERT INTO `user` VALUES ('2', 'test', '123', '林某', null, '13560487066', null, null);
INSERT INTO `user` VALUES ('3', 'test1', '123', '林某', null, '13560487066', null, null);
INSERT INTO `user` VALUES ('4', '1', '', '', null, '', null, null);
