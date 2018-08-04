/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : amzblog_db

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-07-09 16:57:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `AdminUsername` varchar(32) NOT NULL,
  `AdminPassword` varchar(255) NOT NULL,
  `AdminNickname` varchar(32) NOT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'admin1', '123', 'admin1');
INSERT INTO `admin` VALUES ('4', 'admin2', '123', 'admin2');
INSERT INTO `admin` VALUES ('6', 'admin3', '123', 'admin3');

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `BlogID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) unsigned NOT NULL,
  `BlogTitle` varchar(32) NOT NULL,
  `BlogContent` text,
  `BlogContentHtml` text,
  `BlogCreateTime` datetime NOT NULL,
  PRIMARY KEY (`BlogID`),
  KEY `fk_PublishBlog` (`UserID`),
  CONSTRAINT `fk_PublishBlog` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '1', 'userBlog', '12345678', null, '2018-07-03 11:02:36');
INSERT INTO `blog` VALUES ('4', '7', 'title changed', 'content changed', null, '2018-07-03 15:18:36');
INSERT INTO `blog` VALUES ('5', '1', 'new blog3', 'content', null, '2018-07-03 15:41:24');
INSERT INTO `blog` VALUES ('15', '8', '我的第一篇日志', 'A New Amazing Blog\r\n###### ### bjhbjbguhbhj\r\njiknhjinbjk', '<p>A New Amazing Blog</p>\r\n<h6 id=\"h6--bjhbjbguhbhj\"><a name=\"### bjhbjbguhbhj\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>### bjhbjbguhbhj</h6><p>jiknhjinbjk</p>\r\n', '2018-07-08 17:15:20');
INSERT INTO `blog` VALUES ('27', '1', '123322', 'hahahahahahaha', '<p>hahahahahahaha</p>\r\n', '2018-07-09 00:07:30');
INSERT INTO `blog` VALUES ('29', '8', '我觉得', 'A New Amazing Blog', '<p>A New Amazing Blog</p>\r\n', '2018-07-09 00:12:35');
INSERT INTO `blog` VALUES ('33', '8', '++----', 'A New Amazing Blog', '<p>A New Amazing Blog</p>\r\n', '2018-07-09 16:37:59');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `CommID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) unsigned NOT NULL,
  `BlogID` int(11) unsigned NOT NULL,
  `CommContent` varchar(255) NOT NULL DEFAULT '',
  `CommCreateTime` datetime NOT NULL,
  PRIMARY KEY (`CommID`),
  KEY `fk_SendComm` (`UserID`),
  KEY `fk_GetComm` (`BlogID`),
  CONSTRAINT `fk_GetComm` FOREIGN KEY (`BlogID`) REFERENCES `blog` (`BlogID`) ON DELETE CASCADE,
  CONSTRAINT `fk_SendComm` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '1111', '2018-07-03 17:15:26');
INSERT INTO `comment` VALUES ('2', '8', '15', '21121245', '2018-07-08 22:54:57');
INSERT INTO `comment` VALUES ('4', '1', '27', '444', '2018-07-09 15:49:23');
INSERT INTO `comment` VALUES ('5', '1', '27', '444', '2018-07-09 15:50:05');
INSERT INTO `comment` VALUES ('6', '1', '27', '444', '2018-07-09 15:50:40');
INSERT INTO `comment` VALUES ('7', '1', '27', '444', '2018-07-09 15:51:08');
INSERT INTO `comment` VALUES ('8', '8', '27', 'llllllll', '2018-07-09 16:06:46');

-- ----------------------------
-- Table structure for `feeling`
-- ----------------------------
DROP TABLE IF EXISTS `feeling`;
CREATE TABLE `feeling` (
  `FeelID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) unsigned NOT NULL,
  `FeelContent` varchar(255) NOT NULL,
  `FeelCreateTime` datetime NOT NULL,
  PRIMARY KEY (`FeelID`),
  KEY `fk_SendFeel` (`UserID`),
  CONSTRAINT `fk_SendFeel` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feeling
-- ----------------------------
INSERT INTO `feeling` VALUES ('6', '1', '哦哦哦哦哦', '2018-07-08 16:01:44');
INSERT INTO `feeling` VALUES ('15', '8', '我的心情1哈哈哈', '2018-07-08 17:44:15');
INSERT INTO `feeling` VALUES ('18', '1', '111111111', '2018-07-09 00:07:04');

-- ----------------------------
-- Table structure for `friendship`
-- ----------------------------
DROP TABLE IF EXISTS `friendship`;
CREATE TABLE `friendship` (
  `FriendshipID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) unsigned NOT NULL,
  `FriendID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`FriendshipID`),
  KEY `fk_Me` (`UserID`),
  KEY `fk_Friend` (`FriendID`),
  CONSTRAINT `fk_Friend` FOREIGN KEY (`FriendID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE,
  CONSTRAINT `fk_Me` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friendship
-- ----------------------------
INSERT INTO `friendship` VALUES ('90', '8', '11');
INSERT INTO `friendship` VALUES ('91', '11', '8');
INSERT INTO `friendship` VALUES ('94', '8', '17');
INSERT INTO `friendship` VALUES ('95', '17', '8');
INSERT INTO `friendship` VALUES ('96', '17', '1');
INSERT INTO `friendship` VALUES ('97', '1', '17');
INSERT INTO `friendship` VALUES ('102', '18', '7');
INSERT INTO `friendship` VALUES ('103', '7', '18');
INSERT INTO `friendship` VALUES ('104', '18', '12');
INSERT INTO `friendship` VALUES ('105', '12', '18');
INSERT INTO `friendship` VALUES ('106', '18', '11');
INSERT INTO `friendship` VALUES ('107', '11', '18');
INSERT INTO `friendship` VALUES ('118', '8', '1');
INSERT INTO `friendship` VALUES ('119', '1', '8');
INSERT INTO `friendship` VALUES ('120', '19', '8');
INSERT INTO `friendship` VALUES ('121', '8', '19');
INSERT INTO `friendship` VALUES ('122', '8', '14');
INSERT INTO `friendship` VALUES ('123', '14', '8');
INSERT INTO `friendship` VALUES ('124', '8', '14');
INSERT INTO `friendship` VALUES ('125', '14', '8');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `MsgID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) unsigned NOT NULL,
  `MsgContent` varchar(255) NOT NULL DEFAULT '',
  `MsgCreateTime` datetime NOT NULL,
  PRIMARY KEY (`MsgID`),
  KEY `fk_SendMsg` (`UserID`),
  CONSTRAINT `fk_SendMsg` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('5', '2', 'Hello fellow', '2018-07-03 23:14:07');
INSERT INTO `message` VALUES ('23', '8', '12345', '2018-07-08 17:15:46');
INSERT INTO `message` VALUES ('28', '8', '99999999999999', '2018-07-08 23:47:21');
INSERT INTO `message` VALUES ('29', '8', '9999999999999', '2018-07-08 23:47:25');
INSERT INTO `message` VALUES ('31', '8', '111111111111', '2018-07-08 23:55:21');
INSERT INTO `message` VALUES ('34', '8', '88888888888888', '2018-07-09 00:13:10');
INSERT INTO `message` VALUES ('35', '8', '7777777777777777', '2018-07-09 00:13:13');
INSERT INTO `message` VALUES ('36', '8', '666666666666666', '2018-07-09 00:13:16');
INSERT INTO `message` VALUES ('37', '8', '6666666666', '2018-07-09 10:12:26');
INSERT INTO `message` VALUES ('38', '8', '6666666666', '2018-07-09 10:12:33');
INSERT INTO `message` VALUES ('41', '8', '44444444444', '2018-07-09 10:15:04');
INSERT INTO `message` VALUES ('42', '8', '444444444444', '2018-07-09 10:15:21');
INSERT INTO `message` VALUES ('47', '1', 'dddddddddd', '2018-07-09 11:05:24');
INSERT INTO `message` VALUES ('48', '1', 'dddddddddd', '2018-07-09 11:05:29');

-- ----------------------------
-- Table structure for `msgbox`
-- ----------------------------
DROP TABLE IF EXISTS `msgbox`;
CREATE TABLE `msgbox` (
  `MsgBoxID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `MsgID` int(11) unsigned NOT NULL,
  `UserID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`MsgBoxID`),
  KEY `fk_Get` (`MsgID`),
  KEY `fk_Set` (`UserID`),
  CONSTRAINT `fk_Get` FOREIGN KEY (`MsgID`) REFERENCES `message` (`MsgID`) ON DELETE CASCADE,
  CONSTRAINT `fk_Set` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msgbox
-- ----------------------------
INSERT INTO `msgbox` VALUES ('4', '5', '1');
INSERT INTO `msgbox` VALUES ('20', '23', '11');
INSERT INTO `msgbox` VALUES ('25', '28', '19');
INSERT INTO `msgbox` VALUES ('26', '29', '19');
INSERT INTO `msgbox` VALUES ('28', '31', '19');
INSERT INTO `msgbox` VALUES ('31', '34', '19');
INSERT INTO `msgbox` VALUES ('32', '35', '19');
INSERT INTO `msgbox` VALUES ('33', '36', '19');
INSERT INTO `msgbox` VALUES ('34', '37', '1');
INSERT INTO `msgbox` VALUES ('35', '38', '1');
INSERT INTO `msgbox` VALUES ('38', '41', '1');
INSERT INTO `msgbox` VALUES ('39', '42', '1');
INSERT INTO `msgbox` VALUES ('44', '47', '8');
INSERT INTO `msgbox` VALUES ('45', '48', '8');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(32) NOT NULL DEFAULT '',
  `UserPassword` varchar(255) NOT NULL DEFAULT '',
  `UserNickname` varchar(32) NOT NULL DEFAULT '',
  `UserSex` varchar(2) DEFAULT '',
  `UserAge` tinyint(3) unsigned DEFAULT NULL,
  `UserBirthdate` date DEFAULT NULL,
  `UserSelfie` varchar(255) DEFAULT '',
  `UserEmailAddr` varchar(64) DEFAULT '',
  `UserBlogAddr` varchar(64) NOT NULL DEFAULT '',
  `UserWechat` varchar(32) DEFAULT '',
  `UserQQ` varchar(32) DEFAULT '',
  `UserPhone` varchar(32) DEFAULT '',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', '987654321', 'user', '男', '21', '1997-07-08', 'The.Great.Buddha.2017.BD1080P.X264.AAC.Mandarin.CHS.MF_20180508224740.JPG', '939354625@qq.com', 'www.292803281.com', '292803281', '66062646', '8008208320');
INSERT INTO `user` VALUES ('2', '292803', '123456789', 'bruce', '男', '21', '1997-03-25', '软院卫星云图.png', '292803281@qq.com', '292803281@qq.com', '292803281', '292803281', '13114377686');
INSERT INTO `user` VALUES ('5', 'test', '123', 'test', '女', null, null, null, null, 'www.292803281.com', null, null, null);
INSERT INTO `user` VALUES ('7', 'sizhe', '123', '帅哲', null, null, null, null, null, 'www.shuaizhe.com', null, null, null);
INSERT INTO `user` VALUES ('8', 'haitao', '123456789', '小机灵', '男', '21', '1997-08-01', 'The.Great.Buddha.2017.BD1080P.X264.AAC.Mandarin.CHS.MF_20180508224740.JPG', 'null', 'www.haitao.com', '66062646', '939354625', 'null');
INSERT INTO `user` VALUES ('9', 'test8', '123', 'test', null, null, null, null, null, 'www.test.com', null, null, null);
INSERT INTO `user` VALUES ('10', 'test9', '123', 'test', null, null, null, null, null, 'www.test.com', null, null, null);
INSERT INTO `user` VALUES ('11', 'xiaomei', '123', 'xiaomei', null, null, null, null, null, 'www.test.com', null, null, null);
INSERT INTO `user` VALUES ('12', 'pengxu', '123', 'pengxu', null, null, null, null, null, 'www.test.com', null, null, null);
INSERT INTO `user` VALUES ('13', 'test10', '123', 'test10', null, null, null, null, null, 'www.test.com', null, null, null);
INSERT INTO `user` VALUES ('14', 'test11', '123', 'test11', null, null, null, null, null, 'www.test.com', null, null, null);
INSERT INTO `user` VALUES ('15', 'test12', '123', 'test12', null, null, null, null, null, 'www.test.com', null, null, null);
INSERT INTO `user` VALUES ('16', 'rtyu', '741258963', 'rtyu', null, null, null, null, null, 'http://localhost:8080/AmzBlog/servlet/RegisterServlet?null', null, null, null);
INSERT INTO `user` VALUES ('17', 'mumu', '789654123', 'mumu', null, null, null, null, null, 'http://localhost:8080/AmzBlog/servlet/RegisterServlet?null', null, null, null);
INSERT INTO `user` VALUES ('18', 'wuwu', '741258963', 'wuwu', null, null, '2000-01-01', null, null, 'http://localhost:8080/AmzBlog/servlet/RegisterServlet?null', null, null, null);
INSERT INTO `user` VALUES ('19', 'baby', '999999999', 'baby', '男', '18', '2000-01-01', '大叔之爱.Ossans.Love.Ep02.Chi_Jap.HDTVrip.1280X720-ZhuixinFan_20180617135004.JPG', 'null', 'http://localhost:8080/AmzBlog/servlet/RegisterServlet?null', 'null', 'null', 'null');

-- ----------------------------
-- Table structure for `visitor`
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `VisitorID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `RemoteAddr` varchar(255) DEFAULT NULL,
  `VisitTime` datetime DEFAULT NULL,
  `LocalAddr` varchar(255) DEFAULT NULL,
  `RemoteHost` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VisitorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor
-- ----------------------------

-- ----------------------------
-- Table structure for `zone`
-- ----------------------------
DROP TABLE IF EXISTS `zone`;
CREATE TABLE `zone` (
  `ZoneID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(11) unsigned NOT NULL,
  `ZoneName` varchar(32) NOT NULL DEFAULT '',
  `ZoneCreateDate` date NOT NULL,
  `ZoneStyle` varchar(255) DEFAULT '../img/simple.jpg',
  PRIMARY KEY (`ZoneID`),
  KEY `fk_Own` (`UserID`),
  CONSTRAINT `fk_Own` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zone
-- ----------------------------
INSERT INTO `zone` VALUES ('1', '1', '55555555', '2018-08-24', '../img/fresh.jpg');
INSERT INTO `zone` VALUES ('3', '2', 'user2\'s zone', '2018-07-03', '1');
INSERT INTO `zone` VALUES ('4', '8', 'insatiable', '2018-07-07', '../img/antique.png');
INSERT INTO `zone` VALUES ('5', '17', 'mumu', '2018-07-07', '../img/simple.jpg');
INSERT INTO `zone` VALUES ('6', '18', 'wuwu', '2018-07-07', '../img/simple.jpg');
INSERT INTO `zone` VALUES ('7', '19', 'baby', '2018-07-07', '../img/pastoral.jpg');
