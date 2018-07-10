/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : 03lgh

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-08 10:54:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance` (
  `orderid` int(255) NOT NULL AUTO_INCREMENT,
  `policyholderid` varchar(18) DEFAULT NULL,
  `policyholder` varchar(50) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `policyname` varchar(50) DEFAULT NULL,
  `cost` decimal(10,2) DEFAULT NULL,
  `effecttime` datetime DEFAULT NULL,
  `failuretime` datetime DEFAULT NULL,
  `saler` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insurance
-- ----------------------------
INSERT INTO `insurance` VALUES ('1', '216546514510215465', 'lgh', '13632055236', '医疗保险', '199.00', '2018-06-25 12:03:15', '2019-06-25 12:03:15', '1');
INSERT INTO `insurance` VALUES ('3', '216786514564215465', 'lin', '12316266666', '医疗保险', '99.00', '2018-06-25 12:26:27', '2021-06-25 12:26:27', '2');
INSERT INTO `insurance` VALUES ('4', '216546514564215465', 'lkjl', '13632017609', '人身安全', '99.00', '2018-06-25 21:55:44', '2021-06-25 21:55:44', '48');
INSERT INTO `insurance` VALUES ('6', '216546514564215411', 'tuki', '12345678921', '人身安全', '99.00', '2018-06-25 21:58:41', '2019-06-25 21:58:41', '48');
INSERT INTO `insurance` VALUES ('7', '216546511234215465', '李斯', '13632165456', '人身安全', '99.00', '2018-06-25 22:01:48', '2020-06-25 22:01:48', '42');
INSERT INTO `insurance` VALUES ('8', '216444514564215465', 'sui', '18396998555', '人身安全', '99.00', '2018-06-25 22:05:55', '2019-06-25 22:05:55', '40');
INSERT INTO `insurance` VALUES ('9', '216546514500015465', 'lgh', '18366966886', '商业保险', '99.00', '2018-06-29 14:01:33', '2020-06-29 14:01:33', '48');
INSERT INTO `insurance` VALUES ('10', '442356133362323000', 'guli', '15133212321', '财产安全', '199.00', '2018-06-30 12:07:22', '2022-06-30 12:07:22', '2');
INSERT INTO `insurance` VALUES ('11', '216345641261454121', 'ttt', '16324654514', '人身安全', '99.00', '2018-07-01 15:59:46', '2019-07-01 15:59:46', '1');
INSERT INTO `insurance` VALUES ('12', '126454215241624121', 'jj', '15235656234', '医疗保险', '199.00', '2018-07-05 10:47:29', '2020-07-05 10:47:29', '1');
INSERT INTO `insurance` VALUES ('13', '216546514564215465', 'kkl', '12412456124', '人身安全', '99.00', '2018-07-05 10:56:18', '2019-07-05 10:56:18', '26');
INSERT INTO `insurance` VALUES ('14', '216546514564215465', 'kkl', '12412456124', '人身安全', '99.00', '2018-07-05 10:56:30', '2019-07-05 10:56:30', '26');
INSERT INTO `insurance` VALUES ('15', '432162465124165412', 'fox', '18123465456', '人身安全', '99.00', '2018-07-05 11:01:16', '2020-07-05 11:01:16', '26');
INSERT INTO `insurance` VALUES ('16', '558863336655225663', 'gg', '13662855886', '财产安全', '99.00', '2018-07-05 11:23:58', '2019-07-05 11:23:58', '2');
INSERT INTO `insurance` VALUES ('17', '165456126165451264', 'obanl', '15456412415', '医疗保险', '99.00', '2018-07-05 21:49:02', '2022-07-05 21:49:02', '12');
INSERT INTO `insurance` VALUES ('18', '165412365465241964', 'admin', '15236356542', '商业保险', '399.00', '2018-07-05 22:06:47', '2019-07-05 22:06:47', '48');
INSERT INTO `insurance` VALUES ('19', '431264654162146541', 'admin', '13654121545', '养老保险', '99.00', '2018-07-05 22:07:18', '2019-07-05 22:07:18', '48');
INSERT INTO `insurance` VALUES ('20', '431264654162146541', 'admin', '13654121545', '养老保险', '99.00', '2018-07-05 22:07:25', '2019-07-05 22:07:25', '48');
INSERT INTO `insurance` VALUES ('21', '453214512154152135', '黄章', '13216524121', '养老保险', '99.00', '2018-07-07 13:27:46', '2019-07-07 13:27:46', '50');
INSERT INTO `insurance` VALUES ('22', '132131654521652165', '黄秀章', '12154321346', '医疗保险', '499.00', '2018-07-07 13:29:14', '2019-07-07 13:29:14', '50');
INSERT INTO `insurance` VALUES ('23', '132165461264564124', 'admin', '12645241624', '商业保险', '599.00', '2018-07-07 13:31:14', '2020-07-07 13:31:14', '48');
