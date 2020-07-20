/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.11.125
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 172.16.11.125:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 20/07/2020 22:21:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NOT NULL,
  `birthday` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_g8gqk4e142wekcb1t6d3v2mwx`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (2, 'shanghai', 21, '1999-01-01', 'lisi', '13777777777');
INSERT INTO `t_user` VALUES (3, 'beijing', 22, '1998-01-01', 'wangwu', '13666666666');
INSERT INTO `t_user` VALUES (4, 'guangzhou', 23, '1997-01-01', 'zhaoliu', '13555555555');
INSERT INTO `t_user` VALUES (5, 'wuhu', 24, '1996-01-01', 'sunqi', '13444444444');
INSERT INTO `t_user` VALUES (6, 'hangzhou', 31, '1989-05-21', 'aa123', '15666666666');
INSERT INTO `t_user` VALUES (8, 'suzhou', 42, '1978-03-15', 'cc123', '13999999999');
INSERT INTO `t_user` VALUES (10, 'xian', 32, '1988-06-07', 'bb123', '13455555555');
INSERT INTO `t_user` VALUES (18, 'changsha', 22, '1998-05-24', 'xx123', '18222222222');

SET FOREIGN_KEY_CHECKS = 1;
