/*
 Navicat Premium Data Transfer

 Source Server         : JavaPT
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : fruitday

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 26/10/2023 21:46:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fruits
-- ----------------------------
DROP TABLE IF EXISTS `fruits`;
CREATE TABLE `fruits`  (
  `fid` int(0) NOT NULL,
  `fname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `spec` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `up` double(255, 0) NULL DEFAULT NULL,
  `t1` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `t2` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `inum` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fruits
-- ----------------------------
INSERT INTO `fruits` VALUES (1, '佳沛新西兰绿奇异果', '4+2盒', 110, '产地 新西兰 销售规格 6个 商品单重 80-90g ', '储藏方法 0-4度冷藏 营养元素 维生素C、叶酸 特别提醒存放4-5天，成熟后更甜 品牌 佳沛', 3);
INSERT INTO `fruits` VALUES (3, '枣', '2斤', 23, '185-210g', '储藏方法 0-4度冷藏 营养元素 膳食纤维，天然叶酸，VC，钙，铁', 3);
INSERT INTO `fruits` VALUES (4, '菠萝', '1个', 59, '产地\r\n国产\r\n销售规格\r\n2斤/4斤\r\n商品单重\r\n250g以上', '储藏方法\r\n0-4度冷藏保存\r\n营养元素\r\n维生素C，果胶，纤维素', 4);
INSERT INTO `fruits` VALUES (8, '南非青提', '2斤', 68, '产地\r\n南非\r\n销售规格\r\n2斤', '储藏方法\r\n0-4度冷藏\r\n营养元素\r\n白藜芦醇，B类维生素，花青素，钙，蛋白质，果糖', 3);
INSERT INTO `fruits` VALUES (9, '里达葡萄', '2斤', 320, '185-210g', '储藏方法 0-4度冷藏 营养元素 维生素C、叶酸 特别提醒存放4-5天，成熟后更甜 品牌 佳沛', 4);
INSERT INTO `fruits` VALUES (10, '墨西哥牛油果', '6个', 40, '产地 墨西哥 销售规格 6个 商品单重 140g以上 ', '储藏方法 0-4度冷藏  营养元素叶酸，钾，钙，磷', 3);
INSERT INTO `fruits` VALUES (11, '美国华盛顿红地厘蛇果', '6个', 30, '产地\r\n美国销售规格\r\n6个\r\n商品单重\r\n185-210g', '储藏方法\r\n0-4度冷藏保存\r\n营养元素\r\n维生素C，果胶，纤维素', 3);
INSERT INTO `fruits` VALUES (14, '美国佛罗里达葡萄柚', '6个', 40, '产地 美国 销售规格 6个 商品单重 单个重240-310g', '储藏方法 0-4度冷藏 营养元素 膳食纤维，天然叶酸，VC，钙，铁', 3);
INSERT INTO `fruits` VALUES (16, '赣南红心脐橙', '2斤/4斤', 49, '产地\r\n国产\r\n销售规格\r\n2斤/4斤\r\n商品单重\r\n250g以上', '储藏方法\r\n0-4度冷藏\r\n营养元素\r\n胡萝卜素，维生素C，花青素，钾，叶酸，纤维素', 3);
INSERT INTO `fruits` VALUES (20, '紫薯', '500g', 11, '产地\r\n中国\r\n销售规格\r\n500g', '储藏方法\r\n阴凉干燥处\r\n营养元素\r\n纤维素，花青素，硒\r\n烹饪方法\r\n蒸煮煨烤', 3);

-- ----------------------------
-- Table structure for hotfruits
-- ----------------------------
DROP TABLE IF EXISTS `hotfruits`;
CREATE TABLE `hotfruits`  (
  `fid` int(0) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotfruits
-- ----------------------------
INSERT INTO `hotfruits` VALUES (1);
INSERT INTO `hotfruits` VALUES (3);
INSERT INTO `hotfruits` VALUES (4);
INSERT INTO `hotfruits` VALUES (8);
INSERT INTO `hotfruits` VALUES (9);
INSERT INTO `hotfruits` VALUES (10);
INSERT INTO `hotfruits` VALUES (11);
INSERT INTO `hotfruits` VALUES (14);
INSERT INTO `hotfruits` VALUES (16);
INSERT INTO `hotfruits` VALUES (20);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `uid` int(0) NULL DEFAULT NULL,
  `fid` int(0) NULL DEFAULT NULL,
  `isStar` tinyint(1) NULL DEFAULT NULL,
  `isCart` tinyint(1) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (0, 1, 1, 0);
INSERT INTO `shop` VALUES (0, 11, 1, 0);
INSERT INTO `shop` VALUES (0, 14, 1, 1);
INSERT INTO `shop` VALUES (2, 4, 1, 0);
INSERT INTO `shop` VALUES (2, 14, 0, 1);
INSERT INTO `shop` VALUES (2, 20, 1, 0);
INSERT INTO `shop` VALUES (2, 16, 1, 1);
INSERT INTO `shop` VALUES (2, 10, 0, 1);
INSERT INTO `shop` VALUES (2, 8, 1, 0);
INSERT INTO `shop` VALUES (2, 9, 1, 0);
INSERT INTO `shop` VALUES (2, 11, 1, 1);

-- ----------------------------
-- Table structure for shop12
-- ----------------------------
DROP TABLE IF EXISTS `shop12`;
CREATE TABLE `shop12`  (
  `fid` int(0) NOT NULL,
  `isCart` tinyint(0) NULL DEFAULT NULL,
  `isStar` tinyint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop2
-- ----------------------------
DROP TABLE IF EXISTS `shop2`;
CREATE TABLE `shop2`  (
  `fid` int(0) NOT NULL,
  `isStar` tinyint(1) NOT NULL,
  `isCart` tinyint(1) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `uname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'youwillsee2018@qq.com', '15754326763', 'suhong1', 'youwillsee2018@qq.com');
INSERT INTO `user` VALUES (2, 'afgjsk123@qq.com', '123', '123', 'afgjsk123@qq.com');
INSERT INTO `user` VALUES (3, 'fbkj', '123123', '123', 'eee');
INSERT INTO `user` VALUES (4, '123', '1234', '123', 'aaa');
INSERT INTO `user` VALUES (5, 'a2@qq.com', '13581887557', '123', 'a2@qq.com');
INSERT INTO `user` VALUES (6, '111', '111', '111', '123');

SET FOREIGN_KEY_CHECKS = 1;
