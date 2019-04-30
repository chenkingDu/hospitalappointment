/*
Navicat MySQL Data Transfer

Source Server         : King
Source Server Version : 50703
Source Host           : 127.0.0.1:3306
Source Database       : db_yymz

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2018-06-23 11:37:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(500) NOT NULL,
  `time` varchar(200) NOT NULL,
  `name_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '刘三', '测试1', '这是一条测试留言', '2018-06-15 00:41:13', '1');
INSERT INTO `message` VALUES ('2', '刘三', '啊啊啊啊', '服务全方位个', '2018-06-15 14:30:10', '1');

-- ----------------------------
-- Table structure for responds
-- ----------------------------
DROP TABLE IF EXISTS `responds`;
CREATE TABLE `responds` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `respond` varchar(500) NOT NULL,
  `time` varchar(200) NOT NULL,
  `rename_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of responds
-- ----------------------------

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');

-- ----------------------------
-- Table structure for t_guahao
-- ----------------------------
DROP TABLE IF EXISTS `t_guahao`;
CREATE TABLE `t_guahao` (
  `id` int(11) NOT NULL DEFAULT '0',
  `zhuanjiaId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `riqi` varchar(255) DEFAULT NULL,
  `jibing` varchar(255) DEFAULT NULL,
  `xingming` varchar(255) DEFAULT NULL,
  `lianxi` varchar(255) DEFAULT NULL,
  `zt` varchar(255) DEFAULT NULL,
  `huifu` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_guahao
-- ----------------------------
INSERT INTO `t_guahao` VALUES ('7', '2', '1', '2018-05-10', '色调德国', '刘三', '646513', '预约成功', '21日上午9点来科室', '男', '45');
INSERT INTO `t_guahao` VALUES ('8', '2', '1', '2018-06-16', '发烧', '刘三', '13555555555', '预约成功', '明天上午9点来', '男', '45');

-- ----------------------------
-- Table structure for t_jieshao
-- ----------------------------
DROP TABLE IF EXISTS `t_jieshao`;
CREATE TABLE `t_jieshao` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `neirong` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jieshao
-- ----------------------------
INSERT INTO `t_jieshao` VALUES ('1', '医院等级： 三级甲等 <br />\r\n联系地址： 北京市海淀区花园北路49号；[第二门诊部]北京海淀区西三旗育新小区内23号楼；[中央党校院区]北京市海淀区大有庄100号(北五环肖家河桥西侧辅路) <br />\r\n医院网址： http://www.bysy.edu.cn/ <br />\r\n交通指南： 本院：331路、609路、484路、323快北医三院下车；第二门诊部：355路 379路 393路 398路 693路在育新小区下车；中央党校院区：534路、498路、562路，到中央党校北门站下车往东50米；更多乘车路线详见须ddddddddddddddddddd111111111111111dfdfd<br />\r\n医院等级： 三级甲等 <br />\r\n联系地址： 北京市海淀区花园北路49号；[第二门诊部]北京海淀区西三旗育新小区内23号楼；[中央党校院区]北京市海淀区大有庄100号(北五环肖家河桥西侧辅路) <br />\r\n医院网址： http://www.bysy.edu.cn/ <br />\r\n交通指南： 本院：331路、609路、484路、323快北医三院下车；第二门诊部：355路 379路 393路 398路 693路在育新小区下车；中央党校院区：534路、498路、562路，到中央党校北门站下车往东50米；更多乘车路线详见须ddddddddddddddddddd111111111111111dfdfd<br />\r\n医院等级： 三级甲等 <br />\r\n联系地址： 北京市海淀区花园北路49号；[第二门诊部]北京海淀区西三旗育新小区内23号楼；[中央党校院区]北京市海淀区大有庄100号(北五环肖家河桥西侧辅路) <br />\r\n医院网址： http://www.bysy.edu.cn/ <br />\r\n交通指南： 本院：331路、609路、484路、323快北医三院下车；第二门诊部：355路 379路 393路 398路 693路在育新小区下车；中央党校院区：534路、498路、562路，到中央党校北门站下车往东50米；更多乘车路线详见须ddddddddddddddddddd111111111111111dfdfd<br />');

-- ----------------------------
-- Table structure for t_jiuzhen
-- ----------------------------
DROP TABLE IF EXISTS `t_jiuzhen`;
CREATE TABLE `t_jiuzhen` (
  `id` int(11) NOT NULL DEFAULT '0',
  `binglihao` varchar(255) DEFAULT NULL,
  `bingqing` varchar(2550) DEFAULT NULL,
  `zhenduan` varchar(2550) DEFAULT NULL,
  `shijian` varchar(255) DEFAULT NULL,
  `zhuanjiaId` int(255) DEFAULT NULL,
  `guahaoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jiuzhen
-- ----------------------------
INSERT INTO `t_jiuzhen` VALUES ('1', '6476', '脑阔疼', '感冒', '2018-05-06 10:56', '2', '2');
INSERT INTO `t_jiuzhen` VALUES ('3', '123', 'kkk', 'ggg', '2018-05-13 09:35', '2', '1');

-- ----------------------------
-- Table structure for t_keshi
-- ----------------------------
DROP TABLE IF EXISTS `t_keshi`;
CREATE TABLE `t_keshi` (
  `keshi_id` int(11) NOT NULL,
  `keshi_anme` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  `introduce` varchar(2550) DEFAULT NULL,
  PRIMARY KEY (`keshi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_keshi
-- ----------------------------
INSERT INTO `t_keshi` VALUES ('2', '内科', 'no', null);
INSERT INTO `t_keshi` VALUES ('3', '外科', 'no', null);
INSERT INTO `t_keshi` VALUES ('4', '胸科', 'no', null);
INSERT INTO `t_keshi` VALUES ('5', '骨科', 'no', null);
INSERT INTO `t_keshi` VALUES ('6', '儿科', 'yes', null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_pw` varchar(50) DEFAULT NULL,
  `user_realname` varchar(50) DEFAULT NULL,
  `user_sex` varchar(50) DEFAULT NULL,
  `user_age` int(50) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  `user_yue` int(11) DEFAULT NULL,
  `user_del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'liusan', '000000', '刘三', '男', '45', '北京路', '13555555555', null, 'no');
INSERT INTO `t_user` VALUES ('2', 'lisisi', '000000', '李斯', '男', '20', '上海路', '13666666666', null, 'no');
INSERT INTO `t_user` VALUES ('3', '123', '123', '很好', '男', '20', '安徽肯定会', '1455202', null, 'yes');
INSERT INTO `t_user` VALUES ('4', 'asddf', 'asdf', 'asdf', '男', '20', 'adsf', 'asdf', null, 'yes');
INSERT INTO `t_user` VALUES ('5', 'wangxiaoguang', '000000', '王晓光', '男', '40', '药到病除医院', '82438888', null, 'no');
INSERT INTO `t_user` VALUES ('7', 'liulili', '000000', '刘莉莉', '男', '52', '药到病除医院', '82438888', null, 'no');

-- ----------------------------
-- Table structure for t_yaopin
-- ----------------------------
DROP TABLE IF EXISTS `t_yaopin`;
CREATE TABLE `t_yaopin` (
  `id` int(11) NOT NULL DEFAULT '0',
  `mingcheng` varchar(255) DEFAULT NULL,
  `danwei` varchar(11) DEFAULT NULL,
  `guige` varchar(11) DEFAULT NULL,
  `changjia` varchar(255) DEFAULT NULL,
  `danjai` int(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yaopin
-- ----------------------------
INSERT INTO `t_yaopin` VALUES ('3', '九芝堂六味地黄丸浓缩360丸', '瓶', '无', '九芝堂', '26', 'no');
INSERT INTO `t_yaopin` VALUES ('4', '参苓白术丸', '盒', '无', '石家庄以岭药业', '10', 'no');
INSERT INTO `t_yaopin` VALUES ('5', '三九999 感冒灵颗粒', '盒', '无', '华润三九医药股份', '34', 'no');
INSERT INTO `t_yaopin` VALUES ('6', '复方氨酚烷胺胶囊', '盒', '无', '海南亚洲制药有限公司', '13', 'no');

-- ----------------------------
-- Table structure for t_yongyao
-- ----------------------------
DROP TABLE IF EXISTS `t_yongyao`;
CREATE TABLE `t_yongyao` (
  `id` int(11) NOT NULL DEFAULT '0',
  `yaopinId` int(255) DEFAULT NULL,
  `shuliang` int(11) DEFAULT NULL,
  `danjia` int(11) DEFAULT NULL,
  `zongjia` int(255) DEFAULT NULL,
  `jiuzhenId` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yongyao
-- ----------------------------

-- ----------------------------
-- Table structure for t_zhuanjia
-- ----------------------------
DROP TABLE IF EXISTS `t_zhuanjia`;
CREATE TABLE `t_zhuanjia` (
  `id` int(11) NOT NULL DEFAULT '0',
  `xingming` varchar(255) DEFAULT NULL,
  `xingbie` varchar(11) DEFAULT NULL,
  `nianling` int(11) DEFAULT NULL,
  `keshiId` int(11) DEFAULT NULL,
  `shanchang` varchar(255) DEFAULT NULL,
  `fujian` varchar(255) DEFAULT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `loginpw` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT '',
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zhuanjia
-- ----------------------------
INSERT INTO `t_zhuanjia` VALUES ('2', '王晓光', '男', '40', '2', '心脑血管各类疾病', '/upload/1362249942828.jpg', 'wangxiaoguang', '000000', 'no', '5');
INSERT INTO `t_zhuanjia` VALUES ('4', '刘莉莉', '男', '52', '4', '各类口腔科疾病药到病除', '/upload/1362250044364.jpg', 'liulili', '000000', 'no', '7');
INSERT INTO `t_zhuanjia` VALUES ('5', '张志平', '男', '52', '3', '股骨头坏死', '/upload/1528994945630.jpg', 'zhangzhiping', '000000', 'yes', '8');
INSERT INTO `t_zhuanjia` VALUES ('6', '暗示法', '男', '40', '2', '暗示法啊', '/upload/1528995117348.jpg', 'fgq', '000000', 'yes', '9');
