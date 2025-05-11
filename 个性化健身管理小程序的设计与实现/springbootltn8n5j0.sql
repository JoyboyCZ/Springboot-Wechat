/*
 Navicat Premium Data Transfer

 Source Server         : localhost_33061
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:33061
 Source Schema         : springbootltn8n5j0

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 29/04/2025 21:55:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aboutus
-- ----------------------------
DROP TABLE IF EXISTS `aboutus`;
CREATE TABLE `aboutus`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `subtitle` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '副标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `picture1` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片1',
  `picture2` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片2',
  `picture3` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '关于我们' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aboutus
-- ----------------------------
INSERT INTO `aboutus` VALUES (1, '2025-04-14 18:26:47', '关于我们', 'ABOUT US', '当你设想门外是寒冷可怕的世界时，你还应该开门出去看看，是否真的如此。如果你有信心，你对前途就不犹豫了。如果你有勇气，你就不怕前途是否有困难或危险了每个人心中都应有两盏灯，一盏是希望的灯，一盏是勇气的灯。有了这两盏灯，我们就不怕海上的黑暗和风涛的险恶了。人的一生很像是在雾中行走。远远望去，只是迷蒙一片，辨不出方向和吉凶。可是，当你鼓起勇气，放下恐惧和怀疑，一步一步向前走去的时候，你就会发现，每走一步，你都能把下一步路看得清楚一点。“往前走，别站在远远的地方观望！”你就可以找到你的方向。', 'upload/aboutus_picture1.jpg', 'upload/aboutus_picture2.jpg', 'upload/aboutus_picture3.jpg');

-- ----------------------------
-- Table structure for chatmessage
-- ----------------------------
DROP TABLE IF EXISTS `chatmessage`;
CREATE TABLE `chatmessage`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `format` int(11) DEFAULT NULL COMMENT '格式(1:文字，2:图片)',
  `isread` int(11) DEFAULT 0 COMMENT '消息已读(0:未读，1:已读)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chatmessage
-- ----------------------------
INSERT INTO `chatmessage` VALUES (34, '2025-04-17 12:29:31', 1744704586982, 1744704470625, '我是一个高血压肥胖患者，请你帮我制定我的饮食计划', 1, 1);
INSERT INTO `chatmessage` VALUES (35, '2025-04-17 12:30:08', 1744704586982, 1744704515207, '我是一个高血压肥胖患者，体重65kg，身高160cm，请你制定一个计划给我', 1, 1);
INSERT INTO `chatmessage` VALUES (36, '2025-04-17 12:31:29', 1744704515207, 1744704586982, '好的，注意在健身计划中查收', 1, 1);
INSERT INTO `chatmessage` VALUES (37, '2025-04-17 12:37:08', 1744704470625, 1744704586982, '好的，我制定一个计划，发送到你的健身计划中', 1, 1);
INSERT INTO `chatmessage` VALUES (38, '2025-04-17 12:46:45', 1, 1744704586982, '1', 1, 0);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/picture1.jpg', NULL);
INSERT INTO `config` VALUES (2, 'picture2', 'upload/picture2.jpg', NULL);
INSERT INTO `config` VALUES (3, 'picture3', 'upload/picture3.jpg', NULL);

-- ----------------------------
-- Table structure for discussjianshenjianyi
-- ----------------------------
DROP TABLE IF EXISTS `discussjianshenjianyi`;
CREATE TABLE `discussjianshenjianyi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nickname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT '赞',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  `istop` int(11) DEFAULT 0 COMMENT '置顶(1:置顶,0:非置顶)',
  `tuserids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '赞用户ids',
  `cuserids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '踩用户ids',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健身建议评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussjianshenjianyi
-- ----------------------------
INSERT INTO `discussjianshenjianyi` VALUES (3, '2025-04-16 14:52:29', 10, 1744704586982, 'upload/1744704585205.jpg', 'lzx', '<p>1</p>', '', 0, 0, 0, '', '');
INSERT INTO `discussjianshenjianyi` VALUES (4, '2025-04-17 13:55:27', 13, 1744704586982, 'upload/1744704585205.jpg', 'lzx', '<p>1</p>', '', 0, 0, 0, '', '');

-- ----------------------------
-- Table structure for discussyinshijianyi
-- ----------------------------
DROP TABLE IF EXISTS `discussyinshijianyi`;
CREATE TABLE `discussyinshijianyi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nickname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT '赞',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  `istop` int(11) DEFAULT 0 COMMENT '置顶(1:置顶,0:非置顶)',
  `tuserids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '赞用户ids',
  `cuserids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '踩用户ids',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '饮食建议评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussyinshijianyi
-- ----------------------------
INSERT INTO `discussyinshijianyi` VALUES (3, '2025-04-16 14:53:06', 10, 1744704586982, 'upload/1744704585205.jpg', 'lzx', '<p>1</p>', '', 0, 0, 0, '', '');
INSERT INTO `discussyinshijianyi` VALUES (4, '2025-04-17 13:55:38', 12, 1744704586982, 'upload/1744704585205.jpg', 'lzx', '<p>1</p>', '', 0, 0, 0, '', '');

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `isdone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
  `istop` int(11) DEFAULT 0 COMMENT '是否置顶',
  `toptime` datetime(0) DEFAULT NULL COMMENT '置顶时间',
  `typename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `cover` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `isanon` int(11) DEFAULT 0 COMMENT '是否匿名(1:是,0:否)',
  `delflag` int(11) DEFAULT 0 COMMENT '是否删除(1:是,0:否)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `typename`(`typename`) USING BTREE,
  CONSTRAINT `forum_ibfk_1` FOREIGN KEY (`typename`) REFERENCES `forumtype` (`typename`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '交流论坛' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES (12, '2025-04-16 16:32:43', NULL, '<p>你这是哪个学校</p>', 7, 1744704586982, 'lzx', 'upload/1744704585205.jpg', NULL, 0, '2025-04-16 16:32:47', NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for forumreport
-- ----------------------------
DROP TABLE IF EXISTS `forumreport`;
CREATE TABLE `forumreport`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `forumid` bigint(20) DEFAULT NULL COMMENT '论坛id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `userid` bigint(20) NOT NULL COMMENT '举报用户id',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '举报用户名',
  `reporteduserid` bigint(20) NOT NULL COMMENT '被举报用户id',
  `reportedusername` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被举报用户名',
  `reason` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '举报原因',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片补充',
  `handleadvise` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '处理建议',
  `status` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '处理中' COMMENT '状态',
  `reporttype` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '主题帖举报' COMMENT '举报类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '交流论坛举报' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forumreport
-- ----------------------------
INSERT INTO `forumreport` VALUES (9, '2025-04-16 14:48:32', 7, '帖子标题7', 1744704586982, 'lzx', 7, '用户名7', '我', '', '', '处理中', '主题帖举报');
INSERT INTO `forumreport` VALUES (10, '2025-04-16 14:54:13', 6, '帖子标题6', 1744704586982, 'lzx', 6, '用户名6', '违规了', '', '', '处理中', '主题帖举报');
INSERT INTO `forumreport` VALUES (11, '2025-04-17 12:43:12', 8, '帖子标题8', 1744704586982, 'lzx', 8, '用户名8', '1', '', '', '处理中', '主题帖举报');

-- ----------------------------
-- Table structure for forumtype
-- ----------------------------
DROP TABLE IF EXISTS `forumtype`;
CREATE TABLE `forumtype`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `typename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `forumtype_78p8`(`typename`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '交流论坛类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forumtype
-- ----------------------------
INSERT INTO `forumtype` VALUES (7, '2025-04-14 18:26:46', '饮食专区');
INSERT INTO `forumtype` VALUES (8, '2025-04-14 18:26:46', '健身专区');

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `role` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `tablename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `alias` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '别名',
  `type` int(11) DEFAULT 0 COMMENT '类型(0:好友申请，1:好友，2:消息)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '好友表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (1, '2025-04-14 18:40:14', 11, 21, '账号1', 'upload/jianshenzhuanjia_touxiang1.jpg', NULL, 'jianshenzhuanjia', NULL, 2);
INSERT INTO `friend` VALUES (2, '2025-04-14 18:40:15', 21, 11, '用户账号1', 'upload/yonghu_touxiang1.jpg', NULL, 'yonghu', NULL, 2);
INSERT INTO `friend` VALUES (3, '2025-04-14 18:47:38', 11, 31, '营养师账号1', 'upload/yingyangzhuanjia_touxiang1.jpg', NULL, 'yingyangzhuanjia', NULL, 2);
INSERT INTO `friend` VALUES (4, '2025-04-14 18:47:38', 31, 11, '用户账号1', '\"upload/image1.jpg\"', NULL, 'yonghu', NULL, 2);
INSERT INTO `friend` VALUES (7, '2025-04-15 16:46:16', 1744704586982, 1744704515207, '2214100419', 'upload/1744704510259.png', NULL, 'jianshenzhuanjia', NULL, 2);
INSERT INTO `friend` VALUES (8, '2025-04-15 16:46:16', 1744704515207, 1744704586982, 'lzx', 'upload/1744704585205.jpg', NULL, 'yonghu', NULL, 2);
INSERT INTO `friend` VALUES (9, '2025-04-15 16:48:08', 1744704586982, 1744704470625, '2114100419', 'upload/1744704464255.jpg', NULL, 'yingyangzhuanjia', NULL, 2);
INSERT INTO `friend` VALUES (10, '2025-04-15 16:48:08', 1744704470625, 1744704586982, 'lzx', 'upload/1744704585205.jpg', NULL, 'yonghu', NULL, 2);
INSERT INTO `friend` VALUES (11, '2025-04-17 12:46:45', 1, 1744704586982, 'lzx', 'upload/1744704585205.jpg', NULL, 'yonghu', NULL, 2);
INSERT INTO `friend` VALUES (12, '2025-04-17 12:46:45', 1744704586982, 1, 'admin', 'upload/image1.jpg', NULL, 'users', NULL, 2);

-- ----------------------------
-- Table structure for jianshendingzhi
-- ----------------------------
DROP TABLE IF EXISTS `jianshendingzhi`;
CREATE TABLE `jianshendingzhi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `jihuabiaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '计划标题',
  `yundongleixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运动类型',
  `tupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `xunlianfangshi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练方式',
  `xunlianpinlv` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练频率',
  `yuqimubiao` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '预期目标',
  `xunliantianshu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练天数',
  `jihuaxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '计划详情',
  `jihuashijian` date DEFAULT NULL COMMENT '计划时间',
  `zhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健身定制' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jianshendingzhi
-- ----------------------------
INSERT INTO `jianshendingzhi` VALUES (10, '2025-04-15 16:20:21', 'lzx', 'lzx', '合理训练-练成大肌肉', '力量训练', 'upload/1744705081509.jpg', '每天一组平板支撑，每次1分钟，三次为一组。', '一周一次', '肌肉线条更加明显，二头肌更大', '3', '<p>每天一组平板支撑，每次1分钟，三次为一组。</p>', '2025-04-15', '2214100419', '张健身专家', '是', '1');
INSERT INTO `jianshendingzhi` VALUES (12, '2025-04-17 12:33:13', 'lzx', 'lzx', '高血压肥胖患者健身定制计划', '耐力训练', 'upload/1744864330642.jpg', '慢跑', '一周三次', ' 逐步增强心肺功能、改善血压状况', '24天', '<p style=\"margin-bottom: 20px;\">运动前热身：正式慢走前，先进行 5 分钟简单拉伸（如腿部、腰部轻缓伸展），提升关节灵活性。</p><p style=\"margin-bottom: 20px;\">监测身体反应：若运动中出现头晕、头痛、胸闷等不适，立即停止并休息。高血压患者可在运动前后测量血压，观察波动情况。</p><p style=\"margin-bottom: 20px;\">姿势与呼吸：保持抬头挺胸，手臂自然摆动，步伐适中；采用腹式呼吸，避免憋气，呼吸节奏与步伐协调（如走三步吸气、走三步呼气）。</p><p style=\"margin-bottom: 20px;\">环境选择：选择平坦、空气清新的场地（如公园步道），避免坡地、拥挤或路面不平的区域，减少摔倒风险。</p><p style=\"margin-bottom: 20px;\">长期坚持与调整：坚持 6-8 周后，若身体适应良好（如血压稳定、运动时无不适），可在医生或健身教练指导下，适当增加运动时长（如每次 25-30 分钟）或尝试其他低强度运动（如泳池慢走、卧式自行车），进一步提升心肺功能与代谢水平。</p><p style=\"margin-bottom: 20px;\">此计划以安全为前提，逐步改善体质，建议在实施前咨询医生，确保运动方案适合个人健康状况。</p>', '2025-04-17', '2214100419', '张健身专家', '是', '1');

-- ----------------------------
-- Table structure for jianshendingzhi_copy1
-- ----------------------------
DROP TABLE IF EXISTS `jianshendingzhi_copy1`;
CREATE TABLE `jianshendingzhi_copy1`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `jihuabiaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '计划标题',
  `yundongleixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运动类型',
  `tupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `xunlianfangshi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练方式',
  `xunlianpinlv` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练频率',
  `yuqimubiao` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '预期目标',
  `xunliantianshu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练天数',
  `jihuaxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '计划详情',
  `jihuashijian` date DEFAULT NULL COMMENT '计划时间',
  `zhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `sfsh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健身定制' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jianshenjianyi
-- ----------------------------
DROP TABLE IF EXISTS `jianshenjianyi`;
CREATE TABLE `jianshenjianyi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `neirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `zhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT '赞',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  `discussnum` int(11) DEFAULT 0 COMMENT '评论数',
  `storeupnum` int(11) DEFAULT 0 COMMENT '收藏数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健身建议' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jianshenjianyi
-- ----------------------------
INSERT INTO `jianshenjianyi` VALUES (13, '2025-04-17 12:28:35', '深蹲训练', 'upload/1744864107184.jpg', '<p>1.&nbsp;规范动作，确保效果与安全</p><p>图中展示的深蹲动作，是锻炼下肢（大腿、臀部）与核心力量的经典复合动作。注意保持腰背挺直，膝盖与脚尖方向一致（不内扣），下蹲时膝盖不超过脚尖，避免关节损伤。若动作不熟练，可先从徒手深蹲开始，逐步增加重量或难度。</p><p>2.&nbsp;选择合适的运动装备</p><p>穿着透气、吸汗的运动背心与紧身裤（如图中所示），可提升舒适度与灵活性；搭配防滑运动鞋，保护双脚并稳定支撑。合适的装备能减少运动阻碍，降低受伤风险。</p><p>3.&nbsp;坚持规律锻炼，合理安排频率</p><p>建议每周进行 3 - 4 次力量训练（如深蹲、器械练习等），每次 30 - 60 分钟，配合有氧运动（如跑步、游泳），全面提升体能。注意给肌肉留出恢复时间（如隔天训练）。</p><p>4.&nbsp;重视热身与放松</p><p>锻炼前需热身（如动态拉伸、快走），激活肌肉；锻炼后进行静态拉伸（如腿部拉伸），缓解肌肉紧张，促进恢复。图中场景若为跟练课程，可借助教练指导完成热身与冷却环节。</p><p>5.&nbsp;关注饮食与休息</p><p>健身期间保证蛋白质摄入（如鸡蛋、牛奶、瘦肉），修复肌肉；补充水分，维持代谢。每天保证 7 - 8 小时睡眠，助力身体恢复与肌肉生长。</p><p>6.&nbsp;寻求专业指导</p><p>若为健身新手，可聘请教练制定计划，或参加团体课程（如图中集体训练氛围），确保动作规范，避免因错误动作导致损伤。</p>', '2025-04-17', '2214100419', '张健身专家', 1, 0, 1, 0);

-- ----------------------------
-- Table structure for jianshenjilu
-- ----------------------------
DROP TABLE IF EXISTS `jianshenjilu`;
CREATE TABLE `jianshenjilu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jihuabiaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '计划标题',
  `yundongleixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运动类型',
  `tupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `xunlianfangshi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练方式',
  `xunlianpinlv` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练频率',
  `yuqimubiao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预期目标',
  `shijimubiao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '实际目标',
  `yundongzhuangtai` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运动状态',
  `beizhu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `jilushijian` date DEFAULT NULL COMMENT '记录时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健身记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jianshenjindu
-- ----------------------------
DROP TABLE IF EXISTS `jianshenjindu`;
CREATE TABLE `jianshenjindu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jihuabiaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '计划标题',
  `yundongleixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运动类型',
  `tupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `xunlianfangshi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练方式',
  `xunlianpinlv` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练频率',
  `yuqimubiao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预期目标',
  `xunlianshizhang` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练时长',
  `tianshu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '天数',
  `xunlianzhuangtai` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '训练状态',
  `xunlianshijian` date DEFAULT NULL COMMENT '训练时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健身进度' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jianshenjindu
-- ----------------------------
INSERT INTO `jianshenjindu` VALUES (10, '2025-04-16 14:54:29', '合理训练-练成大肌肉', '力量训练', 'upload/1744705081509.jpg', '每天一组平板支撑，每次1分钟，三次为一组。', '一周一次', '肌肉线条更加明显，二头肌更大', '1', '第1天', '已完成', '2025-04-16', 'lzx', 'lzx');
INSERT INTO `jianshenjindu` VALUES (11, '2025-04-16 15:15:13', '适应期训练，高血压健身第一天', '', 'upload/1744787272706.jpg', '多进行有氧运动', '一周三次', '能够提高跑步速度、心肺功能', '1h', '第1天', '已完成', '2025-04-16', 'lzx', 'lzx');
INSERT INTO `jianshenjindu` VALUES (12, '2025-04-17 12:40:15', '高血压肥胖患者健身定制计划', '耐力训练', 'upload/1744864330642.jpg', '慢跑', '一周三次', ' 逐步增强心肺功能、改善血压状况', '1', '第1天', '已完成', '2025-04-17', 'lzx', 'lzx');

-- ----------------------------
-- Table structure for jianshenzhuanjia
-- ----------------------------
DROP TABLE IF EXISTS `jianshenzhuanjia`;
CREATE TABLE `jianshenzhuanjia`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `xingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `lianxifangshi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `touxiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `zhanghao`(`zhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1744704515208 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健身专家' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jianshenzhuanjia
-- ----------------------------
INSERT INTO `jianshenzhuanjia` VALUES (1744704515207, '2025-04-15 16:08:35', '2214100419', '2214100419', '张健身专家', '男', '17325884187', 'upload/1744704510259.png');

-- ----------------------------
-- Table structure for jianyileixing
-- ----------------------------
DROP TABLE IF EXISTS `jianyileixing`;
CREATE TABLE `jianyileixing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jianyileixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '建议类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '建议类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jianyileixing
-- ----------------------------
INSERT INTO `jianyileixing` VALUES (6, '2025-04-14 18:26:46', '高蛋白类型');
INSERT INTO `jianyileixing` VALUES (7, '2025-04-14 18:26:46', '糖尿病适配型');
INSERT INTO `jianyileixing` VALUES (8, '2025-04-14 18:26:46', '高血压保护型');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '菜单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '2025-04-14 18:26:47', '[{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"私聊\"],\"appFrontIcon\":\"cuIcon-medal\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"私聊\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\",\"parentMenuName\":\"用户管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"私聊\"}],\"id\":100099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"私聊\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健身专家\",\"menuJump\":\"列表\",\"tableName\":\"jianshenzhuanjia\",\"parentMenuName\":\"用户管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"私聊\"}],\"id\":200099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"私聊\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"营养专家\",\"menuJump\":\"列表\",\"tableName\":\"yingyangzhuanjia\",\"parentMenuName\":\"用户管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"私聊\"}],\"id\":300099}],\"menu\":\"用户管理\",\"id\":1000},{\"child\":[],\"menu\":\"健身专家管理\",\"id\":2000},{\"child\":[],\"menu\":\"营养专家管理\",\"id\":3000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"健身建议\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjianyi\",\"parentMenuName\":\"健身建议管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"查看评论\"},{\"menu\":\"私聊\"}],\"id\":400099}],\"menu\":\"健身建议管理\",\"id\":4000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"运动类型\",\"menuJump\":\"列表\",\"tableName\":\"yundongleixing\",\"parentMenuName\":\"运动类型管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":500099}],\"menu\":\"运动类型管理\",\"id\":5000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"健身打卡\"],\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"健身定制\",\"menuJump\":\"列表\",\"tableName\":\"jianshendingzhi\",\"parentMenuName\":\"健身定制管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"审核\"},{\"menu\":\"健身打卡\"}],\"id\":600099}],\"menu\":\"健身定制管理\",\"id\":6000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"健身记录\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"删除\",\"修改\",\"查看\"],\"menu\":\"健身进度\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjindu\",\"parentMenuName\":\"健身进度管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"健身记录\"}],\"id\":700099}],\"menu\":\"健身进度管理\",\"id\":7000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-discover\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"健身记录\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjilu\",\"parentMenuName\":\"健身记录管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":800099}],\"menu\":\"健身记录管理\",\"id\":8000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"早餐总摄入量\",\"午餐总摄入量\",\"晚餐总摄入量\",\"加餐总摄入量\",\"总摄入热量\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"早餐总摄入量\",\"午餐总摄入量\",\"晚餐总摄入量\",\"加餐总摄入量\",\"总摄入热量\"],\"menu\":\"饮食记录\",\"menuJump\":\"列表\",\"tableName\":\"yinshijilu\",\"parentMenuName\":\"饮食记录管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"早餐总摄入量\"},{\"menu\":\"午餐总摄入量\"},{\"menu\":\"晚餐总摄入量\"},{\"menu\":\"加餐总摄入量\"},{\"menu\":\"总摄入热量\"},{\"menu\":\"首页总数\"},{\"menu\":\"首页统计\"}],\"id\":900099}],\"menu\":\"饮食记录管理\",\"id\":9000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"建议类型\",\"menuJump\":\"列表\",\"tableName\":\"jianyileixing\",\"parentMenuName\":\"建议类型管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1000099}],\"menu\":\"建议类型管理\",\"id\":10000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"饮食建议\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\",\"parentMenuName\":\"饮食建议管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"},{\"menu\":\"查看评论\"},{\"menu\":\"私聊\"}],\"id\":1100099}],\"menu\":\"饮食建议管理\",\"id\":11000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"食物分类\",\"menuJump\":\"列表\",\"tableName\":\"shiwufenlei\",\"parentMenuName\":\"食物分类管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1200099}],\"menu\":\"食物分类管理\",\"id\":12000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"饮食定制\",\"menuJump\":\"列表\",\"tableName\":\"yinshidingzhi\",\"parentMenuName\":\"饮食定制管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1300099}],\"menu\":\"饮食定制管理\",\"id\":13000},{\"child\":[],\"menu\":\"论坛分类管理\",\"id\":14000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"弹窗提醒\",\"tableName\":\"popupremind\",\"parentMenuName\":\"弹窗提醒管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1500099}],\"menu\":\"弹窗提醒管理\",\"id\":15000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-group\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"交流论坛\",\"tableName\":\"forum\",\"parentMenuName\":\"交流论坛\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1600099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-similar\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"论坛分类\",\"tableName\":\"forumtype\",\"parentMenuName\":\"交流论坛\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1400099}],\"menu\":\"交流论坛\",\"id\":16000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"举报记录\",\"tableName\":\"forumreport\",\"parentMenuName\":\"举报记录管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1700099}],\"menu\":\"举报记录管理\",\"id\":17000},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"查看\",\"修改\"],\"menu\":\"轮播图管理\",\"tableName\":\"config\",\"parentMenuName\":\"系统管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":1800099},{\"allButtons\":[\"查看\",\"修改\"],\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\",\"修改\"],\"menu\":\"关于我们\",\"tableName\":\"aboutus\",\"parentMenuName\":\"系统管理\",\"allbtns\":[{\"menu\":\"查看\"},{\"menu\":\"修改\"}],\"id\":1900099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康资讯分类\",\"tableName\":\"newstype\",\"parentMenuName\":\"系统管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":2000099},{\"allButtons\":[\"查看\",\"编辑名称\",\"编辑父级\",\"编辑权限\",\"删除\"],\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"编辑名称\",\"编辑父级\",\"编辑权限\",\"删除\"],\"menu\":\"菜单列表\",\"tableName\":\"menu\",\"parentMenuName\":\"系统管理\",\"allbtns\":[{\"menu\":\"查看\"},{\"menu\":\"编辑名称\"},{\"menu\":\"编辑父级\"},{\"menu\":\"编辑权限\"},{\"menu\":\"删除\"}],\"id\":2100099},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康资讯\",\"tableName\":\"news\",\"parentMenuName\":\"系统管理\",\"allbtns\":[{\"menu\":\"新增\"},{\"menu\":\"查看\"},{\"menu\":\"修改\"},{\"menu\":\"删除\"}],\"id\":2200099}],\"menu\":\"系统管理\",\"id\":18000}],\"frontMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"私聊\"],\"menu\":\"健身建议列表\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjianyi\"}],\"menu\":\"健身建议模块\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"私聊\"],\"menu\":\"饮食建议列表\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\"}],\"menu\":\"饮食建议模块\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"健身打卡\"],\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"查看\",\"健身进度\",\"健身打卡\"],\"menu\":\"健身定制\",\"menuJump\":\"列表\",\"tableName\":\"jianshendingzhi\"}],\"menu\":\"健身定制管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"健身记录\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"查看\",\"健身记录\"],\"menu\":\"健身进度\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjindu\"}],\"menu\":\"健身进度管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-discover\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"健身记录\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjilu\"}],\"menu\":\"健身记录管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"早餐总摄入量\",\"午餐总摄入量\",\"晚餐总摄入量\",\"加餐总摄入量\",\"总摄入热量\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"新增\"],\"menu\":\"饮食记录\",\"menuJump\":\"列表\",\"tableName\":\"yinshijilu\"}],\"menu\":\"饮食记录管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"饮食定制\",\"menuJump\":\"列表\",\"tableName\":\"yinshidingzhi\"}],\"menu\":\"饮食定制管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\"],\"menu\":\"举报记录\",\"tableName\":\"forumreport\"}],\"menu\":\"举报记录管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-favor\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"menu\":\"我的收藏管理\"}],\"frontMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"私聊\"],\"menu\":\"健身建议列表\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjianyi\"}],\"menu\":\"健身建议模块\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"私聊\"],\"menu\":\"饮食建议列表\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\"}],\"menu\":\"饮食建议模块\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"健身建议\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjianyi\"}],\"menu\":\"健身建议管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"健身打卡\"],\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"查看\",\"新增\",\"修改\",\"删除\"],\"menu\":\"健身定制\",\"menuJump\":\"列表\",\"tableName\":\"jianshendingzhi\"}],\"menu\":\"健身定制管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"健身记录\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"查看\"],\"menu\":\"健身进度\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjindu\"}],\"menu\":\"健身进度管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-discover\",\"buttons\":[\"查看\"],\"menu\":\"健身记录\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjilu\"}],\"menu\":\"健身记录管理\"}],\"frontMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"私聊\"],\"menu\":\"健身建议列表\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjianyi\"}],\"menu\":\"健身建议模块\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"私聊\"],\"menu\":\"饮食建议列表\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\"}],\"menu\":\"饮食建议模块\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"健身专家\",\"tableName\":\"jianshenzhuanjia\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"饮食建议\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\"}],\"menu\":\"饮食建议管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"饮食定制\",\"menuJump\":\"列表\",\"tableName\":\"yinshidingzhi\"}],\"menu\":\"饮食定制管理\"}],\"frontMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"私聊\"],\"menu\":\"健身建议列表\",\"menuJump\":\"列表\",\"tableName\":\"jianshenjianyi\"}],\"menu\":\"健身建议模块\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"私聊\"],\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"私聊\"],\"menu\":\"饮食建议列表\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\"}],\"menu\":\"饮食建议模块\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"营养专家\",\"tableName\":\"yingyangzhuanjia\"}]');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `typename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布人',
  `headportrait` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `clicknum` int(11) DEFAULT 0 COMMENT '点击次数',
  `clicktime` datetime(0) DEFAULT NULL COMMENT '最近点击时间',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT '赞',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  `storeupnum` int(11) DEFAULT 0 COMMENT '收藏数',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `typename`(`typename`) USING BTREE,
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`typename`) REFERENCES `newstype` (`typename`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康资讯' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (7, '2025-04-17 12:07:02', '2025 年健身新趋势：功能性训练与科技融合引领潮流', '2025 年，健身领域迎来重大革新，功能性训练与科技应用成为核心趋势，助力健身爱好者更高效、科学地达成目标。', '健身前沿资讯', '管理员', '', 1, '2025-04-17 12:42:59', 1, 0, 1, 'upload/1744862820457.png', '<h3>功能性训练崛起</h3><p>功能性训练聚焦于提升日常活动能力与运动表现，通过模拟真实生活场景的动作（如深蹲、推拉等），增强肌肉协调性与关节稳定性。相较于传统孤立训练，它更注重全身联动，有效预防运动损伤，深受追求实用健康人群的青睐。</p><p><br></p><h3>科技赋能健身体验</h3><ul><li><span style=\"color: rgb(0, 0, 0);\">智能穿戴设备</span>：实时监测心率、血氧、运动轨迹等数据，结合 AI 分析提供个性化训练建议，让运动更精准。</li><li><span style=\"color: rgb(0, 0, 0);\">VR 健身</span>：虚拟现实技术融入，打造沉浸式运动场景，如虚拟骑行、健身游戏，提升趣味性与坚持度。</li></ul><p><br></p>');
INSERT INTO `news` VALUES (8, '2025-04-17 12:09:01', '2025 饮食新潮流：个性化与可持续成焦点', '2025 饮食前沿聚焦个性化定制、植物基蛋白及超级食物新发展，引领健康饮食新方向。\n', '饮食前沿资讯', '管理员', '', 3, '2025-04-17 12:48:45', 0, 0, 0, 'upload/1744862939825.png', '<p><span style=\"color: rgba(0, 0, 0, 0.85);\">2025 年，饮食领域前沿趋势亮点纷呈。个性化营养备受瞩目，借助基因检测、肠道菌群分析等技术定制专属食谱，精准匹配健康需求。植物基替代蛋白迎来技术飞跃，口感与营养双重优化，成为可持续饮食的热门选择。超级食物范畴拓展，除奇亚籽等经典品类，沙棘、猴面包果等新食材因富含抗氧化剂等营养成分崭露头角。这些趋势推动饮食向更精准、健康且环保的方向演进。</span></p>');

-- ----------------------------
-- Table structure for newstype
-- ----------------------------
DROP TABLE IF EXISTS `newstype`;
CREATE TABLE `newstype`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `typename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `newstype_6p8h`(`typename`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '健康资讯分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newstype
-- ----------------------------
INSERT INTO `newstype` VALUES (7, '2025-04-14 18:26:47', '健身前沿资讯');
INSERT INTO `newstype` VALUES (8, '2025-04-14 18:26:47', '饮食前沿资讯');

-- ----------------------------
-- Table structure for popupremind
-- ----------------------------
DROP TABLE IF EXISTS `popupremind`;
CREATE TABLE `popupremind`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '发布人id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '个人' COMMENT '类型',
  `brief` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `remindtime` datetime(0) DEFAULT NULL COMMENT '提醒时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '弹窗提醒' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of popupremind
-- ----------------------------
INSERT INTO `popupremind` VALUES (1, '2025-04-14 18:26:47', 1, '标题1', '个人', '简介1', '内容1', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (2, '2025-04-14 18:26:47', 2, '标题2', '个人', '简介2', '内容2', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (3, '2025-04-14 18:26:47', 3, '标题3', '个人', '简介3', '内容3', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (4, '2025-04-14 18:26:47', 4, '标题4', '个人', '简介4', '内容4', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (5, '2025-04-14 18:26:47', 5, '标题5', '个人', '简介5', '内容5', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (6, '2025-04-14 18:26:47', 6, '标题6', '个人', '简介6', '内容6', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (7, '2025-04-14 18:26:47', 7, '标题7', '个人', '简介7', '内容7', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (8, '2025-04-14 18:26:47', 8, '标题8', '个人', '简介8', '内容8', '2025-04-14 18:26:47');
INSERT INTO `popupremind` VALUES (9, '2025-04-14 18:46:26', 11, '健身定制', '个人', '审核通过', '你提交的“健身定制”申请审核通过', '2025-04-14 18:46:25');
INSERT INTO `popupremind` VALUES (10, '2025-04-16 14:49:16', 1744704586982, '健身定制', '个人', '审核通过', '你提交的“健身定制”申请审核通过', '2025-04-16 14:49:16');
INSERT INTO `popupremind` VALUES (11, '2025-04-16 15:14:21', 1744704586982, '健身定制', '个人', '审核通过', '你提交的“健身定制”申请审核通过', '2025-04-16 15:14:21');
INSERT INTO `popupremind` VALUES (12, '2025-04-17 12:39:55', 1744704586982, '健身定制', '个人', '审核通过', '你提交的“健身定制”申请审核通过', '2025-04-17 12:39:55');

-- ----------------------------
-- Table structure for shiwufenlei
-- ----------------------------
DROP TABLE IF EXISTS `shiwufenlei`;
CREATE TABLE `shiwufenlei`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shiwufenlei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '食物分类',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `shiwufenlei`(`shiwufenlei`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '食物分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shiwufenlei
-- ----------------------------
INSERT INTO `shiwufenlei` VALUES (7, '2025-04-14 18:26:46', '低盐饮食');
INSERT INTO `shiwufenlei` VALUES (8, '2025-04-14 18:26:46', '高蛋白饮食');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storeup
-- ----------------------------
INSERT INTO `storeup` VALUES (1, '2025-04-14 18:46:28', 11, 9, 'popupremind', '健身定制', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (4, '2025-04-16 14:09:19', 1744704515207, 1, 'forum', '帖子标题1', 'upload/forum_cover1.jpg', '1', NULL, NULL);
INSERT INTO `storeup` VALUES (5, '2025-04-16 14:09:22', 1744704515207, 1, 'forum', '帖子标题1', 'upload/forum_cover1.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (9, '2025-04-16 14:49:20', 1744704586982, 10, 'popupremind', '健身定制', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (14, '2025-04-16 15:14:42', 1744704586982, 11, 'popupremind', '健身定制', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (15, '2025-04-16 15:14:43', 1744704586982, 11, 'popupremind', '健身定制', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (16, '2025-04-17 12:40:02', 1744704586982, 12, 'popupremind', '健身定制', NULL, '61', NULL, NULL);
INSERT INTO `storeup` VALUES (17, '2025-04-17 12:43:00', 1744704586982, 7, 'news', '2025 年健身新趋势：功能性训练与科技融合引领潮流', 'upload/1744862820457.png', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (18, '2025-04-17 12:43:01', 1744704586982, 7, 'news', '2025 年健身新趋势：功能性训练与科技融合引领潮流', 'upload/1744862820457.png', '1', NULL, NULL);
INSERT INTO `storeup` VALUES (19, '2025-04-17 12:43:07', 1744704586982, 8, 'forum', '帖子标题8', 'upload/forum_cover8.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (20, '2025-04-17 13:55:20', 1744704586982, 13, 'jianshenjianyi', '深蹲训练', 'upload/1744864107184.jpg', '21', NULL, NULL);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 11, '用户账号1', 'yonghu', '用户', 'kdhwocnd4xf503x64s9qmluimexu5n28', '2025-04-14 18:39:33', '2025-04-16 11:43:10');
INSERT INTO `token` VALUES (2, 21, '账号1', 'jianshenzhuanjia', '健身专家', 'pv6th87rh9nilt6c2tczz53o9hhxfw1q', '2025-04-14 18:40:37', '2025-04-14 19:40:37');
INSERT INTO `token` VALUES (3, 1, 'admin', 'users', '管理员', 'zkt1savlk16am6f4ri1dtxpuy07309lx', '2025-04-14 18:46:04', '2025-04-17 15:00:15');
INSERT INTO `token` VALUES (4, 31, '营养师账号1', 'yingyangzhuanjia', '营养专家', 'e6e2xvj8lgjgljsh0yhfyg1yvsydtx63', '2025-04-14 18:48:01', '2025-04-14 19:48:02');
INSERT INTO `token` VALUES (5, 1744704586982, 'lzx', 'yonghu', '用户', 'tb8di85s603aunemt9ylcda59uz8w2rj', '2025-04-15 16:11:26', '2025-04-17 18:31:18');
INSERT INTO `token` VALUES (6, 1744704515207, '2214100419', 'jianshenzhuanjia', '健身专家', '1o46ftt1hpphh3uyyvvn83mnfjvkza04', '2025-04-15 16:13:15', '2025-04-17 20:49:06');
INSERT INTO `token` VALUES (7, 1744704470625, '2114100419', 'yingyangzhuanjia', '营养专家', 'xhiy7f6l85oubfbe5x7of3e5lnl75n8c', '2025-04-15 16:21:44', '2025-04-17 13:34:07');
INSERT INTO `token` VALUES (8, 1744791671311, '1', 'yonghu', '用户', 'hizlalb2wnle7ik2hayml6gddvjfsz0u', '2025-04-16 16:21:23', '2025-04-16 17:21:24');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', 'upload/image1.jpg', '管理员', '2025-04-14 18:26:47');

-- ----------------------------
-- Table structure for yingyangzhuanjia
-- ----------------------------
DROP TABLE IF EXISTS `yingyangzhuanjia`;
CREATE TABLE `yingyangzhuanjia`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yingyangshizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '营养师账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `yingyangshixingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '营养师姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `touxiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yingyangshizhanghao`(`yingyangshizhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1744704470626 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '营养专家' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yingyangzhuanjia
-- ----------------------------
INSERT INTO `yingyangzhuanjia` VALUES (1744704470625, '2025-04-15 16:07:50', '2114100419', '2114100419', '李营养师', '男', '13392554623', 'upload/1744704464255.jpg');

-- ----------------------------
-- Table structure for yinshidingzhi
-- ----------------------------
DROP TABLE IF EXISTS `yinshidingzhi`;
CREATE TABLE `yinshidingzhi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `shiwumingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '食物名称',
  `shiwufenlei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '食物分类',
  `shiwutupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '食物图片',
  `shiwureliang` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '食物热量',
  `danbaizhi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '蛋白质',
  `shiwuzhifang` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '食物脂肪',
  `tanshuihuahewu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '碳水化合物',
  `yinshiliang` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '饮食量',
  `dingzhishijian` date DEFAULT NULL COMMENT '定制时间',
  `dingzhixiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '定制详情',
  `yingyangshizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营养师账号',
  `yingyangshixingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营养师姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '饮食定制' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yinshidingzhi
-- ----------------------------
INSERT INTO `yinshidingzhi` VALUES (10, '2025-04-15 16:32:32', 'lzx', 'lzx', '鸡胸肉', '畜禽肉类', '', '118 千卡 / 100 克', '24 克 / 100 克', '5 克 / 100 克', '0 克 / 100 克', '200 克 / 日', '2025-04-15', '<p>每日食用 200 克鸡胸肉，可煎或煮，搭配蔬菜。建议：鸡胸糙米饭，搭配时蔬，营养又健康。</p>', '2114100419', '李营养师');
INSERT INTO `yinshidingzhi` VALUES (11, '2025-04-16 15:13:22', 'lzx', 'lzx', '高血压饮食', '低盐饮食', 'upload/1744787577868.jpg', '1', '1', '1', '1', '1', '2025-04-16', '<p>早餐</p><p>燕麦水果杯：即食燕麦 30 克泡软垫底，加 100 克无糖酸奶，放 20 颗蓝莓。</p><p>水煮蛋：1 个鸡蛋煮熟。</p><p>午餐</p><p>香煎鸡胸肉糙米饭：100 克鸡胸肉用少量油煎熟，搭配 50 克煮熟的糙米。</p><p>清炒时蔬：100 克西兰花、50 克胡萝卜、50 克芹菜，少量橄榄油炒熟。</p><p>晚餐</p><p>清蒸鲈鱼：1 条约 100 克的鲈鱼，加葱姜蒸熟。</p><p>凉拌黄瓜：1 根黄瓜拍碎，加醋、蒜末拌匀。</p><p>红薯粥：100 克红薯切块，与 20 克大米煮粥。</p>', '2114100419', '李营养师');
INSERT INTO `yinshidingzhi` VALUES (12, '2025-04-16 15:13:22', 'lzx', 'lzx', '高血压饮食', '低盐饮食', 'upload/1744787577868.jpg', '1', '1', '1', '1', '1', '2025-04-16', '<p>早餐</p><p>燕麦水果杯：即食燕麦 30 克泡软垫底，加 100 克无糖酸奶，放 20 颗蓝莓。</p><p>水煮蛋：1 个鸡蛋煮熟。</p><p>午餐</p><p>香煎鸡胸肉糙米饭：100 克鸡胸肉用少量油煎熟，搭配 50 克煮熟的糙米。</p><p>清炒时蔬：100 克西兰花、50 克胡萝卜、50 克芹菜，少量橄榄油炒熟。</p><p>晚餐</p><p>清蒸鲈鱼：1 条约 100 克的鲈鱼，加葱姜蒸熟。</p><p>凉拌黄瓜：1 根黄瓜拍碎，加醋、蒜末拌匀。</p><p>红薯粥：100 克红薯切块，与 20 克大米煮粥。</p>', '2114100419', '李营养师');
INSERT INTO `yinshidingzhi` VALUES (13, '2025-04-17 12:38:44', 'lzx', 'lzx', '低钠饮食', '低盐饮食', 'upload/1744864660753.jpg', '1200', '60', '20', '150', '', '2025-04-17', '<p>早餐：</p><p>燕麦水果杯：即食燕麦 30 克泡软垫底，加 100 克无糖低脂酸奶，放 20 颗蓝莓。</p><p>水煮蛋：1 个鸡蛋煮熟（去蛋黄，仅食蛋白，减少胆固醇摄入）。</p><p>午餐：</p><p>香煎鸡胸肉糙米饭：100 克鸡胸肉用少量橄榄油煎熟，搭配 50 克煮熟的糙米（提供优质碳水）。</p><p>清炒时蔬：100 克西兰花、50 克胡萝卜、50 克芹菜，用 5 克橄榄油快炒，少盐调味。</p><p>晚餐：</p><p>清蒸鲈鱼：1 条约 100 克的鲈鱼，加葱姜蒸制（补充优质蛋白，低脂低盐）。</p><p>凉拌黄瓜：1 根黄瓜拍碎，加醋、少量蒜末拌匀，不额外加盐。</p><p>红薯粥：100 克红薯切块，与 20 克大米煮粥（增加膳食纤维，增强饱腹感）。</p><p>食物分类：低盐饮食</p><p>食物热量：约 1200 - 1400 千卡（控制总热量摄入，制造热量缺口助减肥）</p><p>蛋白质：约 60 - 70 克（保证肌肉修复与代谢需求）</p><p>食物脂肪：约 20 - 30 克（选用优质油脂，控制总量）</p><p>碳水化合物：约 150 - 180 克（以粗粮、薯类为主，稳定血糖）</p><p>饮食量：少量多餐，每餐七八分饱，避免过饱升高血压。</p>', '2114100419', '李营养师');

-- ----------------------------
-- Table structure for yinshijianyi
-- ----------------------------
DROP TABLE IF EXISTS `yinshijianyi`;
CREATE TABLE `yinshijianyi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `jianyileixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '建议类型',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `yingyangfenxi` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '营养分析',
  `neirong` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `zhuyishixiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '注意事项',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  `beizhu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `yingyangshizhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营养师账号',
  `yingyangshixingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营养师姓名',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT '赞',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  `discussnum` int(11) DEFAULT 0 COMMENT '评论数',
  `storeupnum` int(11) DEFAULT 0 COMMENT '收藏数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '饮食建议' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yinshijianyi
-- ----------------------------
INSERT INTO `yinshijianyi` VALUES (11, '2025-04-16 15:10:43', '高血压应该怎么吃', '高血压保护型', 'upload/1744787432261.jpg', '1', '1', '1', '2025-04-16', '1', '2114100419', '李营养师', 0, 0, 0, 0);
INSERT INTO `yinshijianyi` VALUES (12, '2025-04-17 12:36:47', '低钠饮食', '高血压保护型', 'upload/1744864581240.jpg', '无', '低钠饮食有利于血压保护', '无', '2025-04-17', '无', '2114100419', '李营养师', 0, 0, 1, 0);

-- ----------------------------
-- Table structure for yinshijilu
-- ----------------------------
DROP TABLE IF EXISTS `yinshijilu`;
CREATE TABLE `yinshijilu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `biaoti` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `riqi` date DEFAULT NULL COMMENT '日期',
  `tupian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `zaocansheru` int(11) DEFAULT NULL COMMENT '早餐摄入',
  `zhongcansheru` int(11) DEFAULT NULL COMMENT '中餐摄入',
  `wancansheru` int(11) DEFAULT NULL COMMENT '晚餐摄入',
  `jiacansheru` int(11) DEFAULT NULL COMMENT '加餐摄入',
  `sheruzongreliang` int(11) DEFAULT NULL COMMENT '摄入总热量',
  `dengjishijian` date DEFAULT NULL COMMENT '登记时间',
  `beizhu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT '赞',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '饮食记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yinshijilu
-- ----------------------------
INSERT INTO `yinshijilu` VALUES (13, '2025-04-16 16:37:22', 'lzx', 'lzx', 'test11', '2025-04-16', 'upload/1744792641419.jpg', 600, 700, 400, 0, 1700, '2025-04-16', '', 0, 0, 1744704586982);
INSERT INTO `yinshijilu` VALUES (14, '2025-04-17 12:41:14', 'lzx', 'lzx', '低钠饮食', '2025-04-17', 'upload/1744864863231.jpg', 400, 400, 400, 0, 1200, '2025-04-17', '无', 0, 0, 1744704586982);

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `shoujihao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `touxiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yonghuzhanghao`(`yonghuzhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1744704586983 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (11, '2025-04-14 18:26:46', '用户账号1', '123456', '用户姓名1', '男', '13823888881', 'upload/yonghu_touxiang1.jpg');
INSERT INTO `yonghu` VALUES (12, '2025-04-14 18:26:46', '用户账号2', '123456', '用户姓名2', '男', '13823888882', 'upload/yonghu_touxiang2.jpg');
INSERT INTO `yonghu` VALUES (13, '2025-04-14 18:26:46', '用户账号3', '123456', '用户姓名3', '男', '13823888883', 'upload/yonghu_touxiang3.jpg');
INSERT INTO `yonghu` VALUES (14, '2025-04-14 18:26:46', '用户账号4', '123456', '用户姓名4', '男', '13823888884', 'upload/yonghu_touxiang4.jpg');
INSERT INTO `yonghu` VALUES (15, '2025-04-14 18:26:46', '用户账号5', '123456', '用户姓名5', '男', '13823888885', 'upload/yonghu_touxiang5.jpg');
INSERT INTO `yonghu` VALUES (16, '2025-04-14 18:26:46', '用户账号6', '123456', '用户姓名6', '男', '13823888886', 'upload/yonghu_touxiang6.jpg');
INSERT INTO `yonghu` VALUES (17, '2025-04-14 18:26:46', '用户账号7', '123456', '用户姓名7', '男', '13823888887', 'upload/yonghu_touxiang7.jpg');
INSERT INTO `yonghu` VALUES (18, '2025-04-14 18:26:46', '用户账号8', '123456', '用户姓名8', '男', '13823888888', 'upload/yonghu_touxiang8.jpg');
INSERT INTO `yonghu` VALUES (1744704586982, '2025-04-15 16:09:46', 'lzx', '123', 'lzx', '男', '15360179123', 'upload/1744704585205.jpg');

-- ----------------------------
-- Table structure for yundongleixing
-- ----------------------------
DROP TABLE IF EXISTS `yundongleixing`;
CREATE TABLE `yundongleixing`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yundongleixing` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '运动类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '运动类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yundongleixing
-- ----------------------------
INSERT INTO `yundongleixing` VALUES (6, '2025-04-14 18:26:46', '耐力训练');
INSERT INTO `yundongleixing` VALUES (7, '2025-04-14 18:26:46', '爆发力训练');
INSERT INTO `yundongleixing` VALUES (8, '2025-04-14 18:26:46', '力量训练');

SET FOREIGN_KEY_CHECKS = 1;
