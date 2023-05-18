/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 18/05/2023 14:26:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_gear
-- ----------------------------
DROP TABLE IF EXISTS `t_gear`;
CREATE TABLE `t_gear`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT,
                           `type` int(0) NULL DEFAULT NULL COMMENT '类型',
                           `index_number` int(0) NULL DEFAULT NULL COMMENT '序号',
                           `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号',
                           `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
                           `modulus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模数',
                           `materials` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材料 ',
                           `heat_treatment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热处理 \n',
                           `total_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '全长',
                           `head_count` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头数 ',
                           `gear_tooth_machining` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '齿面加工',
                           `gear_precision` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '齿轮精度 ',
                           `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
                           `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 510 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '齿轮参数' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
