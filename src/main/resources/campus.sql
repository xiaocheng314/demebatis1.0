/*
 Navicat Premium Data Transfer

 Source Server         : campus
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : campus

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 31/07/2020 21:17:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cartimg
-- ----------------------------
DROP TABLE IF EXISTS `cartimg`;
CREATE TABLE `cartimg`  (
  `cart_num` int(11) NOT NULL AUTO_INCREMENT,
  `oneImg` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `twoImg` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `threeImg` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commodityNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`cart_num`) USING BTREE,
  INDEX `cartimg_commodity_commodityNum_fk`(`commodityNum`) USING BTREE,
  CONSTRAINT `cartimg_commodity_commodityNum_fk` FOREIGN KEY (`commodityNum`) REFERENCES `commodity` (`commodityNum`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品图片地址' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cartimg
-- ----------------------------
INSERT INTO `cartimg` VALUES (15, 'http://localhost:8081/images/221229c6-0fa3-4cd5-bf0f-c007acb2c344.jpg', 'http://localhost:8081/images/9659b081-55c2-40bb-8edc-70e6c723906a.jpg', NULL, '099bec29-ad0f-4ca5-aa7b-08a40d835ff8', '2020-06-28 23:33:11');
INSERT INTO `cartimg` VALUES (16, 'http://localhost:8081/images/ff1499bc-a98d-4c49-b2ec-4f50f0f60720.jpg', NULL, NULL, '6c60c296-117f-43b4-a9f8-f4af05dfe4b6', '2020-06-29 00:45:52');
INSERT INTO `cartimg` VALUES (17, 'http://localhost:8081/images/416da9d6-1c91-4847-b1f0-471fd7fe05f1.jpg', NULL, NULL, 'f779fe29-50e8-453f-a133-55ca2a02e7bc', '2020-06-29 00:58:54');
INSERT INTO `cartimg` VALUES (18, 'http://localhost:8081/images/4dbc612c-79ae-47e8-a349-d2565c862555.jpg', NULL, NULL, '44d07417-2e16-4c7c-8903-ba7ec257f35f', '2020-06-29 01:08:51');
INSERT INTO `cartimg` VALUES (19, 'http://localhost:8081/images/6e9aa12b-8213-41f4-a944-8ac9f06a6261.jpg', NULL, NULL, '2b15a65e-209d-4bd5-be30-e221c510f09e', '2020-06-29 01:14:53');
INSERT INTO `cartimg` VALUES (20, 'http://localhost:8081/images/03eae94e-ce0e-4c3a-9a7c-eb9692def191.jpg', NULL, NULL, '09906c68-6815-4e51-96dc-6fa584de07bd', '2020-06-29 13:08:14');
INSERT INTO `cartimg` VALUES (21, 'http://localhost:8081/images/7b90e304-5177-421c-9ec1-860cafcfa3e0.jpg', NULL, NULL, 'c7495e99-5cb7-40ce-9b3b-b837956609db', '2020-06-29 17:15:39');
INSERT INTO `cartimg` VALUES (22, 'http://localhost:8081/images/5beb5108-c340-430d-92c4-41a59d7803be.jpg', NULL, NULL, 'f3b525c6-4299-432a-b125-15556b104d40', '2020-06-29 17:33:20');
INSERT INTO `cartimg` VALUES (23, 'http://localhost:8081/images/38c7a023-d7c2-4d47-998d-6dbdbb35c5ef.jpg', NULL, NULL, 'f18605eb-1a8a-4688-b008-25eb7ff36163', '2020-06-29 20:43:37');
INSERT INTO `cartimg` VALUES (27, 'http://localhost:8081/images/95c4e40f-986c-4fb9-8cdb-0362e2949dc6.jpg', 'http://localhost:8081/images/d4b94e4d-e116-4e7a-9821-bbfd44d037da.jpg', NULL, '7190f80d-648a-4c84-b1d6-0ce5fa71638c', '2020-07-01 12:12:20');
INSERT INTO `cartimg` VALUES (28, 'http://localhost:8081/images/d6fbd064-b5f9-4a65-93d0-a8c06d9d952e.jpg', NULL, NULL, 'f69f2788-d6b2-418f-b35c-9bf7933f0adb', '2020-07-01 13:57:42');
INSERT INTO `cartimg` VALUES (29, 'http://localhost:8081/images/7d962065-b0dd-4c5a-8acf-3cfab56a0431.jpg', NULL, NULL, '25ef623b-bca1-44b5-99fe-c959afcd76f1', '2020-07-01 18:17:03');
INSERT INTO `cartimg` VALUES (30, 'http://localhost:8081/images/6a6e02c5-fb81-4483-940f-196215280da8.jpg', NULL, NULL, '6bd00a5e-80c4-4f2f-9041-3bab78fe5e19', '2020-07-08 19:53:32');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `commodityNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userId` int(9) NOT NULL,
  `product` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kind` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isNew` tinyint(1) NOT NULL DEFAULT 0,
  `price` int(11) NOT NULL,
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contact` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`commodityNum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('09906c68-6815-4e51-96dc-6fa584de07bd', 151414123, '气象色谱仪系统', '全新', '图书', 1, 100, '操场', '18994234566', '2020-06-29 13:08:14', '2020-06-29 13:08:14');
INSERT INTO `commodity` VALUES ('099bec29-ad0f-4ca5-aa7b-08a40d835ff8', 161414101, '钱包', '蓝色，鳄鱼皮，全新，名牌', '生活', 0, 50, '操场', '12174776436', '2020-06-28 23:33:11', '2020-06-28 23:33:11');
INSERT INTO `commodity` VALUES ('25ef623b-bca1-44b5-99fe-c959afcd76f1', 181414125, '钢笔', '黑色', '其他', 0, 50, '', '18523625465', '2020-07-01 18:17:03', '2020-07-01 18:17:03');
INSERT INTO `commodity` VALUES ('2b15a65e-209d-4bd5-be30-e221c510f09e', 171414103, 'Windows10', '全新', '图书', 1, 60, '宿舍楼门口', '12343325235', '2020-06-29 01:14:53', '2020-06-29 01:14:53');
INSERT INTO `commodity` VALUES ('44d07417-2e16-4c7c-8903-ba7ec257f35f', 181414404, '钢笔', '买了没用过', '其他', 1, 60, '宿舍楼门口', '18912414247', '2020-06-29 01:08:51', '2020-06-29 01:08:51');
INSERT INTO `commodity` VALUES ('6bd00a5e-80c4-4f2f-9041-3bab78fe5e19', 181414141, '钢笔', '绿色', '其他', 1, 20, '操场', '16235265241', '2020-07-08 19:53:32', '2020-07-08 19:53:32');
INSERT INTO `commodity` VALUES ('6c60c296-117f-43b4-a9f8-f4af05dfe4b6', 161414101, '钢笔', '黑色派克钢笔，原价150元买的用了半个月', '其他', 0, 80, '明德楼', '17323834343', '2020-06-29 00:45:52', '2020-06-29 00:45:52');
INSERT INTO `commodity` VALUES ('7190f80d-648a-4c84-b1d6-0ce5fa71638c', 181414148, '钢笔', '黑色和绿色两只', '生活', 0, 59, '', '15766078259', '2020-07-01 12:12:20', '2020-07-01 12:12:20');
INSERT INTO `commodity` VALUES ('c7495e99-5cb7-40ce-9b3b-b837956609db', 181414148, 'search框架图书', '已经学完了', '图书', 1, 30, '', '18992132131', '2020-06-29 17:15:39', '2020-06-29 17:15:39');
INSERT INTO `commodity` VALUES ('f18605eb-1a8a-4688-b008-25eb7ff36163', 181414129, '书本', '全新数据库高级编辑', '图书', 0, 50, '', '17834343232', '2020-06-29 20:43:37', '2020-06-29 20:43:37');
INSERT INTO `commodity` VALUES ('f3b525c6-4299-432a-b125-15556b104d40', 181414126, '钢笔', '全新', '生活', 1, 20, '', '17232342434', '2020-06-29 17:33:19', '2020-06-29 17:33:19');
INSERT INTO `commodity` VALUES ('f69f2788-d6b2-418f-b35c-9bf7933f0adb', 181414148, 'Windows10', '关于 windows 10的使用详解，全新', '图书', 0, 100, '宿舍楼门口', '18952324155', '2020-07-01 13:57:42', '2020-07-01 13:57:42');
INSERT INTO `commodity` VALUES ('f779fe29-50e8-453f-a133-55ca2a02e7bc', 181414404, '计算机书', '去年买的，看完了，有一些笔记', '图书', 0, 50, '教学楼', '17453453453', '2020-06-29 00:58:54', '2020-06-29 00:58:54');

-- ----------------------------
-- Table structure for express
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express`  (
  `stu_id` int(11) NOT NULL,
  `stu_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `express_shelves` int(11) NOT NULL,
  `express_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `express_id` int(11) NULL DEFAULT NULL,
  INDEX `express_user_stu_id_fk`(`stu_id`) USING BTREE,
  INDEX `express_user_stu_id_fk_2`(`express_id`) USING BTREE,
  CONSTRAINT `express_user_stu_id_fk` FOREIGN KEY (`stu_id`) REFERENCES `user` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `express_user_stu_id_fk_2` FOREIGN KEY (`express_id`) REFERENCES `user` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express
-- ----------------------------

-- ----------------------------
-- Table structure for lost_goods
-- ----------------------------
DROP TABLE IF EXISTS `lost_goods`;
CREATE TABLE `lost_goods`  (
  `lost_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `lost_id` int(11) NOT NULL,
  `lost_icon` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '丢失物品的图片',
  `lost_product` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '丢失物品',
  `good_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lost_address` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '丢失的地点',
  `lost_kind` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品的类型\n',
  `lost_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品的大概描述\n',
  `lost_return` tinyint(1) NOT NULL DEFAULT 0 COMMENT '物品是否找到，默认false即\'0\'',
  `pick_id` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加的时间\n',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改的时间',
  PRIMARY KEY (`lost_number`) USING BTREE,
  INDEX `lost_goods_user_stu_id_fk`(`lost_id`) USING BTREE,
  INDEX `lost_goods_user_stu_id_fk_2`(`pick_id`) USING BTREE,
  CONSTRAINT `lost_goods_user_stu_id_fk` FOREIGN KEY (`lost_id`) REFERENCES `user` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `lost_goods_user_stu_id_fk_2` FOREIGN KEY (`pick_id`) REFERENCES `user` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '失物招领的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_goods
-- ----------------------------
INSERT INTO `lost_goods` VALUES (42, 181414148, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '钢笔', 'http://localhost:8081/images/1593576611884.jpg', '操场', '生活', '黑色', 1, 181414125, '2020-07-01 12:10:12', '2020-07-01 18:09:42');
INSERT INTO `lost_goods` VALUES (43, 181414148, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '钱包', 'http://localhost:8081/images/1593578803428.jpg', '宿舍', '生活', '黑色，里面有一张身份证，若干现金', 1, 181414148, '2020-07-01 12:46:43', '2020-07-01 12:47:37');
INSERT INTO `lost_goods` VALUES (44, 145253622, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '钱包', 'http://localhost:8081/images/1593588816843.jpeg', '教学楼', '生活', '皮质钱包', 1, 181414141, '2020-07-01 15:33:37', '2020-07-08 19:48:54');
INSERT INTO `lost_goods` VALUES (45, 125468935, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', 'windows10', 'http://localhost:8081/images/1593589882955.jpg', '明德楼204', '图书', '书籍教材', 0, NULL, '2020-07-01 15:51:23', '2020-07-01 15:51:23');
INSERT INTO `lost_goods` VALUES (46, 125468935, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '大学生移动互联网', 'http://localhost:8081/images/1593589968964.jpg', '教学楼301', '图书', '学习教材', 0, NULL, '2020-07-01 15:52:49', '2020-07-01 15:52:49');
INSERT INTO `lost_goods` VALUES (47, 181414125, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '钱包', 'http://localhost:8081/images/1593598391927.jpg', '宿舍', '生活', '黑色', 0, NULL, '2020-07-01 18:13:12', '2020-07-01 18:13:12');
INSERT INTO `lost_goods` VALUES (48, 181414125, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '钱包', 'http://localhost:8081/images/1594204557550.jpeg', '宿舍', '生活', '褐色', 0, NULL, '2020-07-08 18:35:58', '2020-07-08 18:35:58');
INSERT INTO `lost_goods` VALUES (49, 181414141, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '钱包', 'http://localhost:8081/images/1594209092120.jpg', '宿舍楼', '生活', '黑色', 0, NULL, '2020-07-08 19:51:32', '2020-07-08 19:51:32');

-- ----------------------------
-- Table structure for pick_goods
-- ----------------------------
DROP TABLE IF EXISTS `pick_goods`;
CREATE TABLE `pick_goods`  (
  `pick_number` int(11) NOT NULL AUTO_INCREMENT,
  `pick_id` int(11) NOT NULL,
  `pick_icon` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `good_img` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pick_product` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pick_address` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pick_kind` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pick_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pick_return` tinyint(1) NOT NULL DEFAULT 0,
  `lost_id` int(11) NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`pick_number`) USING BTREE,
  INDEX `pick_goods_user_stu_id_fk`(`pick_id`) USING BTREE,
  INDEX `pick_goods_user_stu_id_fk_2`(`lost_id`) USING BTREE,
  CONSTRAINT `pick_goods_user_stu_id_fk` FOREIGN KEY (`pick_id`) REFERENCES `user` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pick_goods_user_stu_id_fk_2` FOREIGN KEY (`lost_id`) REFERENCES `user` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '寻找物品的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pick_goods
-- ----------------------------
INSERT INTO `pick_goods` VALUES (17, 181414148, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', 'http://localhost:8081/images/1593576658716.jpg', '钢笔', '操场', '生活', '绿色', 1, 181414125, '2020-07-01 12:10:58', '2020-07-01 18:11:29');
INSERT INTO `pick_goods` VALUES (18, 145253622, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', 'http://localhost:8081/images/1593588897259.jpg', '钱包', '教学楼', '生活', '里面有一张身份证和一些现金', 1, 181414141, '2020-07-01 15:34:57', '2020-07-08 19:49:14');
INSERT INTO `pick_goods` VALUES (19, 125468935, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', 'http://localhost:8081/images/1593590091477.jpg', '钢笔', '教学楼501', '生活', '钢笔', 0, NULL, '2020-07-01 15:54:51', '2020-07-01 15:54:51');
INSERT INTO `pick_goods` VALUES (20, 123458967, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', 'http://localhost:8081/images/1593590573734.jpg', '书籍', '饭堂', '图书', '教材', 0, NULL, '2020-07-01 16:02:53', '2020-07-01 16:02:53');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `stu_id` int(8) NOT NULL DEFAULT 0 COMMENT '学号\n',
  `stu_img` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名字\n',
  `stu_grade` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级\n',
  `stu_college` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院',
  `stu_dorm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_tel` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间\n',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (123458967, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '小德', '经管1245', '经管学院', '201-304', '15687942514', '2020-07-01 16:02:20');
INSERT INTO `user` VALUES (125468935, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '小彤', '软件1254', '计算机学院', '201-320', '12354689754', '2020-07-01 15:49:39');
INSERT INTO `user` VALUES (145253622, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '小丽', '经管1455', '经管学院', '301-202', '18985622334', '2020-07-01 15:32:33');
INSERT INTO `user` VALUES (181414107, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '杨海欣', '软件1832', '计算机学院', '616', '15623562352', '2020-07-12 10:27:05');
INSERT INTO `user` VALUES (181414125, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '阮杨俊', '软件1832', '计算机学院', '210-503', '15766278245', '2020-07-01 18:08:34');
INSERT INTO `user` VALUES (181414141, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '小明', '软件1832', '计算机学院', '210-505', '13766078278', '2020-07-08 19:48:01');
INSERT INTO `user` VALUES (181414148, 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKkYaYHWVwHib1moT7JUEjia45hc0uQBSgfDXIy2voRibUGFQcJic3u87Vn1h9m0YpC9tQ5ZmJTgcUzPA/132', '小程', '软件1832', '计算机学院', '210-505', '15766078259', '2020-07-01 12:09:12');

SET FOREIGN_KEY_CHECKS = 1;
