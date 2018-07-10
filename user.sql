/*
Navicat MySQL Data Transfer

Source Server         : 172.22.36.38_6018
Source Server Version : 50553
Source Host           : 172.22.36.38:6018
Source Database       : 03lgh

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-07-08 10:12:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(100) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `usergrade` varchar(100) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lgh', '123', '2018-06-13 21:01:27', 'admin', '20', '男', 'normal');
INSERT INTO `user` VALUES ('2', 'lg', '123', '2018-06-13 21:03:35', 'salesman', '21', '男', 'normal');
INSERT INTO `user` VALUES ('13', '张全蛋', '111', '2018-06-15 17:51:00', 'salesman', '20', '男', 'deleted');
INSERT INTO `user` VALUES ('14', '张三', '1234', '2018-06-15 17:51:44', 'salesman', '30', '男', 'normal');
INSERT INTO `user` VALUES ('16', 'dashi', '654321', '2018-06-15 17:53:55', 'salesman', '15', '男', 'normal');
INSERT INTO `user` VALUES ('17', 'iot', '654321', '2018-06-15 17:54:54', 'salesman', '18', '男', 'normal');
INSERT INTO `user` VALUES ('18', '刺客', '666666', '2018-06-15 17:56:23', 'salesman', '20', '男', 'normal');
INSERT INTO `user` VALUES ('20', 'Romes', '13214656', '2018-06-15 17:57:54', 'salesman', '20', '女', 'normal');
INSERT INTO `user` VALUES ('21', 'Tabbitha', '15433', '2018-06-15 17:58:57', 'salesman', '20', '男', 'normal');
INSERT INTO `user` VALUES ('25', 'Elicia', '457212', '2018-06-15 18:00:29', 'salesman', '16', '女', 'normal');
INSERT INTO `user` VALUES ('26', 'Fox', 'kjsadfn', '2018-06-15 18:00:36', 'salesman', '20', '男', 'normal');
INSERT INTO `user` VALUES ('27', 'tiger', 'kjsadfn', '2018-06-15 18:00:42', 'salesman', '29', '女', 'normal');
INSERT INTO `user` VALUES ('29', 'kyla', '123456', '2018-06-15 18:01:07', 'salesman', '21', '女', 'normal');
INSERT INTO `user` VALUES ('30', 'lins', '20151217', '2018-06-15 18:01:22', 'salesman', '26', '男', 'deleted');
INSERT INTO `user` VALUES ('32', 'Dallon', '65423', '2018-06-15 18:01:58', 'salesman', '28', '男', 'normal');
INSERT INTO `user` VALUES ('33', 'Mayne', '65423', '2018-06-15 18:02:12', 'salesman', '12', '女', 'normal');
INSERT INTO `user` VALUES ('35', 'Ardine', '123456', '2018-06-15 18:02:39', 'salesman', '27', '女', 'normal');
INSERT INTO `user` VALUES ('37', 'bu', 'xiaomi', '2018-06-15 18:04:42', 'salesman', '56', '女', 'normal');
INSERT INTO `user` VALUES ('38', 'loly', 'xiaomi', '2018-06-15 18:06:09', 'salesman', '26', '男', 'normal');
INSERT INTO `user` VALUES ('39', 'kkg', 'xiaomi', '2018-06-15 18:06:23', 'salesman', '20', '男', 'normal');
INSERT INTO `user` VALUES ('40', 'Yulma', 'Yulma', '2018-06-15 18:06:42', 'salesman', '24', '女', 'normal');
INSERT INTO `user` VALUES ('41', 'Raddy', 'Raddy12', '2018-06-15 18:07:02', 'salesman', '11', '男', 'normal');
INSERT INTO `user` VALUES ('42', '木子和化石', '2018', '2018-06-15 18:09:49', 'salesman', '20', '男', 'deleted');
INSERT INTO `user` VALUES ('43', '妙之', '123456789', '2018-06-15 18:10:30', 'salesman', '20', '男', 'normal');
INSERT INTO `user` VALUES ('44', 'Ezechiel', 'Ezechi', '2018-06-15 18:10:42', 'salesman', '48', '男', 'normal');
INSERT INTO `user` VALUES ('46', 'root', 'root', '2018-06-17 12:00:50', 'admin', '20', '女', 'normal');
INSERT INTO `user` VALUES ('48', 'admin', 'admin', '2018-06-17 12:31:08', 'admin', '20', '男', 'normal');
INSERT INTO `user` VALUES ('49', '黄秀章', '654321', '2018-07-07 13:15:37', 'salesman', '25', '男', 'normal');
INSERT INTO `user` VALUES ('50', '黄章', '123456', '2018-07-07 13:26:47', 'salesman', '35', '女', 'normal');
