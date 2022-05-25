/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : 192.168.1.54:3306
 Source Schema         : sweet

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 21/05/2022 09:41:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sweet_admin
-- ----------------------------
DROP TABLE IF EXISTS `sweet_admin`;
CREATE TABLE `sweet_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员名称',
  `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `admin_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员手机号',
  `admin_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员邮箱',
  `admin_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员等级',
  `admin_pid` int(11) NULL DEFAULT NULL COMMENT '管理员上级',
  `admin_create_time` datetime(0) NULL DEFAULT NULL COMMENT '管理员生成时间',
  `admin_is_del` tinyint(1) NULL DEFAULT 0 COMMENT '管理员是否删除',
  `admin_is_enable` tinyint(1) NULL DEFAULT 1 COMMENT '管理员是否禁用',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_admin
-- ----------------------------
INSERT INTO `sweet_admin` VALUES (10000, 'Sweet', '268adf5f34c031af0e11e4ab10f0523fbfe8661190a7e551395e7ba688526139a3482b735d21fb202aeee4bf952b40f667fd70eb62988456097b059e6347b805', '14752169639', 'Sweet@qq.com', '0', 0, '2021-04-26 03:13:46', 0, 1);

-- ----------------------------
-- Table structure for sweet_admin_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sweet_admin_privilege`;
CREATE TABLE `sweet_admin_privilege`  (
  `user_privilege_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理权限Id',
  `user_privilege_aid` int(255) NULL DEFAULT NULL COMMENT '管理权限管理员Id',
  `user_privilege_pid` int(11) NULL DEFAULT NULL COMMENT '管理权限权限Id',
  PRIMARY KEY (`user_privilege_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员权限中间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_bank_card
-- ----------------------------
DROP TABLE IF EXISTS `sweet_bank_card`;
CREATE TABLE `sweet_bank_card`  (
  `bank_card_id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '银行卡Id',
  `bank_card_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `bank_card_owner_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡持有者名称',
  `bank_card_valid_from` date NULL DEFAULT NULL COMMENT '银行卡开始时间',
  `bank_card_valid_thru` date NULL DEFAULT NULL COMMENT '银行卡有效时间',
  `bank_card_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡类型',
  `bank_card_manage_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡办理地址',
  `bank_card_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡手机号',
  `bank_card_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡密码',
  `bank_card_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡key',
  `bank_card_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡密钥',
  `bank_card_create_time` datetime(0) NULL DEFAULT NULL COMMENT '银行卡创建时间',
  `bank_card_uid` bigint(20) NULL DEFAULT NULL COMMENT '银行卡用户Id',
  `bank_card_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '银行卡是否删除',
  PRIMARY KEY (`bank_card_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '银行卡' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_bank_card
-- ----------------------------
INSERT INTO `sweet_bank_card` VALUES (1, '3217993000300799056', '姚继龙', '2021-02-03', '2029-10-10', '0', '江苏省徐州市邳州是支行', '14752169639', '******', '******', '********？****？？？', '2021-04-26 03:16:57', 10000, 0);

-- ----------------------------
-- Table structure for sweet_bank_card_type
-- ----------------------------
DROP TABLE IF EXISTS `sweet_bank_card_type`;
CREATE TABLE `sweet_bank_card_type`  (
  `card_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '银行卡类型id',
  `card_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡类型名称',
  `card_type_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '银行卡类型是否显示',
  `card_type_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '银行卡类型是否删除',
  `card_type_create_time` datetime(0) NULL DEFAULT NULL COMMENT '银行卡类型创建时间',
  PRIMARY KEY (`card_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '银行卡类型' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_bank_card_type
-- ----------------------------
INSERT INTO `sweet_bank_card_type` VALUES (0, '借记卡', 1, 0, '2021-04-26 03:20:26');
INSERT INTO `sweet_bank_card_type` VALUES (1, '信用卡', 1, 0, '2021-04-26 03:20:44');

-- ----------------------------
-- Table structure for sweet_bill
-- ----------------------------
DROP TABLE IF EXISTS `sweet_bill`;
CREATE TABLE `sweet_bill`  (
  `bill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账单id',
  `bill_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账单名称',
  `bill_pay_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账单支付类型',
  `bill_pay_time` datetime(0) NULL DEFAULT NULL COMMENT '账单支付时间',
  `bill_create_time` datetime(0) NULL DEFAULT NULL COMMENT '账单创建时间',
  `bill_type` int(255) NULL DEFAULT NULL COMMENT '账单收支类型',
  `bill_money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账单金额',
  `bill_uid` int(11) NULL DEFAULT NULL COMMENT '账单用户',
  `bill_details` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '账单详细',
  `bill_remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '账单备注',
  `bill_order` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账单订单',
  `bill_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '账单是否删除',
  PRIMARY KEY (`bill_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '账单' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_config
-- ----------------------------
DROP TABLE IF EXISTS `sweet_config`;
CREATE TABLE `sweet_config`  (
  `config_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置的id',
  `config_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置名称',
  `config_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置类型',
  `config_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置分组',
  `config_value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '配置数值',
  `config_details` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '配置内容',
  `config_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '配置' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_config
-- ----------------------------
INSERT INTO `sweet_config` VALUES (1, 'aliPayServerUrl', 'serverUrl', 'AliPay', 'https://openapi.alipay.com/gateway.do', NULL, '网页支付宝服务地址');
INSERT INTO `sweet_config` VALUES (2, 'aliPayAppId', 'appId', 'AliPay', '2021001193632900', NULL, '网页支付宝appId');
INSERT INTO `sweet_config` VALUES (3, 'aliPayPrivateKey', 'privateKey', 'AliPay', 'MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYvOEBoil9+kPKTF83xZFHj2jur3pYZA6FlvzAD8/DqKch96i+T7XFJAbTPtp05q/aFJIblFVCKu18Q6ZLWS2Nck4bxvqEgiMhEXorMaLiOhvH0PpUMc4lo+nEmPJAzUgN0/JRcz1KaE9m5ORlQhK7QVoJ/hjGashpy3dEb9IYZZEQTE2cqbhmhng3BW8otBnYxOJN/sr09JeaAENa++H9lwCHaWNOe0I3ynpXANbczU1U9lxFq6gHIDMm4166c1Skc7GcFdGvgkd8HchFNi5zFt+Lqgjh9TujgEjFcnaybnaKZVsVOuo0SJMd4+/Z7FdbzeS3IAYfx02yaqaK8ZwtAgMBAAECggEAY5K3SZ5TWHqgWTEi3jQhuzpGGV0y8I8CXJsLWZa1RwQbOWzAiJlkkgojnPIb7xw5Rn4kpnA0iPd9bYaY0gRoSw9a1ocI6PwCNNu0/pXUb5GcbM7Tc7Ioh6dtjip7vD1YHROwpOLw8SJBqX3NXCoQFh3Lujn6ItiYoUfxEB+qIxaCdYPdoFGBgMC0n4AwAZKM8e2RX9NgWxmr+H99DKVEU/amSbtZrQK8qom9TgA77L4tgQ57/CtAyZBt/kAVAoZvshSotE5YONOk5Z2BReB9zVRosuZ9WrS+ej/YSSSq5J1jhEB3Q+SGdpxyOdnXgN+pibLmPBRpYNKa7gsWSUMiAQKBgQD7uKmSANEZZdGMu3DHJyuCAEXxMsTSvnXocI5Gi1xEZk1b8MyeYtJr6AClgugp04Wm+jjMJbq4XqNtNLniGjU2TFyt5ZSB1IVDHSL8sjXDWpGEyuQGIw+30SOxJY/ZixXNclUUR820DyEupDISx6ZMBEe5Hvzg2neQoJBnkY4bgQKBgQCbVYAqTmtTWslLtb6KvlHzZEOB3C6gQZp/bh1YDzmCZIyWf9JbhcEeLogMWaN6Apkw3BRocvfc6rgz36KLM0wDIE9eZi28KxZvnGAU1vroZcWj8/2F9xG0EuQ7S/6C8yfvMb6ccnv0iLVT0P0wwTKM7LAC8KNu9mxmG1NSC0QGrQKBgQC8j78OrOf184y+tGat+MyhrJy4KsS/7YaboT0i4SAz6MKIXeCZwQNJa9iYI3DQbDARPh2v549wrwwTMU0Rb3pu+1LtvS2697z/4mKkEsctWLnrVKTtZ/RNSTBIcg/I8WRaqwvKjmMsP60mqD8OTFppVUd5CBp8QYsRXwXtX16pgQKBgC8wrH0t0cFDBYBwuHBiHXd58GBVSfz5sTwhcdy801Xfwi4+quOPIPpQXJiT6uw4Od30HmcU9mQxEsD/odv0O5V/jV06YY6W8Hv739y06wkLUh3bFBxM0R4J1ziEf8+8m1c5n5Tb2viRR7Us+p6DMx5JEbfy71PYnVnv10JHleUJAoGAJqdWRR6LzqeqhWPDf6jtVkKA93srexPivhchHfso4zwf3r8+KNMbOxT2kgG/Un5GhefnyodwghCnUKvkHzIn3EJWI6TN4htx4Y4ojCbWogbgiwsEuvO8TaVuOu/VdhbhU3SHNd7LqFEfRI+IyiELLOxGb1tUZ/Y+0zoYBVckjvQ=', NULL, '网页支付宝支付私钥');
INSERT INTO `sweet_config` VALUES (4, 'aliPayPublicKey', 'publicKey', 'AliPay', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmLzhAaIpffpDykxfN8WRR49o7q96WGQOhZb8wA/Pw6inIfeovk+1xSQG0z7adOav2hSSG5RVQirtfEOmS1ktjXJOG8b6hIIjIRF6KzGi4jobx9D6VDHOJaPpxJjyQM1IDdPyUXM9SmhPZuTkZUISu0FaCf4YxmrIact3RG/SGGWREExNnKm4ZoZ4NwVvKLQZ2MTiTf7K9PSXmgBDWvvh/ZcAh2ljTntCN8p6VwDW3M1NVPZcRauoByAzJuNeunNUpHOxnBXRr4JHfB3IRTYucxbfi6oI4fU7o4BIxXJ2sm52imVbFTrqNEiTHePv2exXW83ktyAGH8dNsmqmivGcLQIDAQAB', NULL, '网页支付宝支付公钥');
INSERT INTO `sweet_config` VALUES (5, 'aliPaySignType', 'signType', 'AliPay', 'RSA2', NULL, '网页支付宝加密类型');
INSERT INTO `sweet_config` VALUES (6, 'aliPayFormat', 'format', 'AliPay', 'json', NULL, '网页传输方式');
INSERT INTO `sweet_config` VALUES (7, 'aliPayNotifyUrl', 'notifyUrl', 'AliPay', 'afdsfsd', NULL, '网页回调通知地址');
INSERT INTO `sweet_config` VALUES (8, 'aliPayCharset', 'charset', 'AliPay', 'UTF-8', NULL, '网页支付宝加密字符');
INSERT INTO `sweet_config` VALUES (9, 'aliPayReturnUrl', 'returnUrl', 'AliPay', 'afdsfsd', NULL, '网页返回地址');
INSERT INTO `sweet_config` VALUES (19, 'Key', 'jwtKey', 'JwtConfig', '123123123213', NULL, 'Jwt密钥');
INSERT INTO `sweet_config` VALUES (20, 'Expiration', 'jwtExpiration', 'JwtConfig', '2', NULL, 'Jwt时长');
INSERT INTO `sweet_config` VALUES (21, 'Database', 'redisDatabase', 'RedisConfig', '1', NULL, 'Redis数据库');
INSERT INTO `sweet_config` VALUES (22, 'TimeOut', 'redisTimeOut', 'RedisConfig', '5000', NULL, 'Redis超时');
INSERT INTO `sweet_config` VALUES (23, 'Host', 'redisHost', 'RedisConfig', '127.0.0.1', NULL, 'RedisIp');
INSERT INTO `sweet_config` VALUES (24, 'Password', 'redisPassword', 'RedisConfig', '', NULL, 'Redis密码');
INSERT INTO `sweet_config` VALUES (25, 'Port', 'redisPort', 'RedisConfig', '6379', NULL, 'Redis端口');
INSERT INTO `sweet_config` VALUES (27, 'SmsRegionId', 'regionId', 'AliSmsChinaCode', 'cn-hangzhou', NULL, '阿里云短信区域ID');
INSERT INTO `sweet_config` VALUES (28, 'SmsAccessKeyId', 'accessKeyId', 'AliSmsChinaCode', '', NULL, '阿里云短信通道KeyId');
INSERT INTO `sweet_config` VALUES (29, 'SmsSecret', 'secret', 'AliSmsChinaCode', '', NULL, '阿里云短信密钥');
INSERT INTO `sweet_config` VALUES (30, 'SmsDomain', 'domain', 'AliSmsChinaCode', 'dysmsapi.aliyuncs.com', NULL, '阿里云短信域名');
INSERT INTO `sweet_config` VALUES (31, 'SmsTemplateName', 'templateName', 'AliSmsChinaCode', '上海欧助文化交流有限公司', NULL, '阿里云短信模板名称');
INSERT INTO `sweet_config` VALUES (32, 'SmsTimeOut', 'timeOut', 'AliSmsChinaCode', '5', NULL, '阿里云短信超时');
INSERT INTO `sweet_config` VALUES (33, 'SmsTemplate', 'template', 'AliSmsChinaCode', 'SMS_184816553', NULL, '阿里云短信模板号');
INSERT INTO `sweet_config` VALUES (34, 'MailHost', 'host', 'MailConfig', 'smtp.qq.com', NULL, '邮箱地址');
INSERT INTO `sweet_config` VALUES (35, 'MailUserName', 'userName', 'MailConfig', '565352671@qq.com', NULL, '邮箱账号');
INSERT INTO `sweet_config` VALUES (36, 'MailPassword', 'password', 'MailConfig', 'wjxtpdivcwbnbdae', NULL, '邮箱密码');
INSERT INTO `sweet_config` VALUES (37, 'MailProtocol', 'protocol', 'MailConfig', 'smtp', NULL, '邮箱协议');
INSERT INTO `sweet_config` VALUES (38, 'FilePath', 'path', 'FileConfig', '/home/upload/', NULL, '文件路径');
INSERT INTO `sweet_config` VALUES (39, 'urlPath', 'url', 'FileConfig', 'http://127.0.0.1:8055/file', NULL, '访问文件网址');
INSERT INTO `sweet_config` VALUES (40, 'WechatPayAppId', 'appId', 'WechatPayConfig', NULL, NULL, '微信支付AppId');
INSERT INTO `sweet_config` VALUES (41, 'WechatPayMchId', 'mchId', 'WechatPayConfig', NULL, NULL, '微信支付mchId');
INSERT INTO `sweet_config` VALUES (42, 'WechatPayAppSecret', 'appSecret', 'WechatPayConfig', NULL, NULL, '微信支付App密钥');
INSERT INTO `sweet_config` VALUES (43, 'WechatPayAppKey', 'appKey', 'WechatPayConfig', NULL, NULL, '微信支付AppKey');
INSERT INTO `sweet_config` VALUES (44, 'WechatPayPartnerId', '\r\npartnerId', 'WechatPayConfig', NULL, NULL, '微信支付商户ID');
INSERT INTO `sweet_config` VALUES (45, 'WechatPayGateUrl', 'gateUrl', 'WechatPayConfig', NULL, NULL, '微信支付预支付地址');
INSERT INTO `sweet_config` VALUES (46, 'WechatPayNotifyUrl', 'notifyUrl', 'WechatPayConfig', NULL, NULL, '微信支付回调地址');
INSERT INTO `sweet_config` VALUES (47, 'WechatPayReturnUrl', 'returnUrl', 'WechatPayConfig', NULL, NULL, '微信支付返回地址');
INSERT INTO `sweet_config` VALUES (48, 'WechatPayJspApiId', 'jsApiId', 'WechatPayConfig', NULL, NULL, '微信Js支付ID');
INSERT INTO `sweet_config` VALUES (49, 'WechatPayJsApiSecret', 'jsApiSecret', 'WechatPayConfig', NULL, NULL, '微信Js支付密钥');
INSERT INTO `sweet_config` VALUES (50, 'WechatPayJsApiKey', 'jsApiKey', 'WechatPayConfig', NULL, NULL, '微信Js支付Key');

-- ----------------------------
-- Table structure for sweet_file
-- ----------------------------
DROP TABLE IF EXISTS `sweet_file`;
CREATE TABLE `sweet_file`  (
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件md5',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `file_create_time` datetime(0) NULL DEFAULT NULL COMMENT '文件创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_goods_attrbute
-- ----------------------------
DROP TABLE IF EXISTS `sweet_goods_attrbute`;
CREATE TABLE `sweet_goods_attrbute`  (
  `attrbute_spu_id` int(11) NOT NULL COMMENT '商品属性',
  `attrbute_key_id` int(11) NULL DEFAULT NULL COMMENT '商品属性KeyId',
  `attrbute_value_id` int(11) NULL DEFAULT NULL COMMENT '商品属性ValueId',
  PRIMARY KEY (`attrbute_spu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_goods_attrbute_key
-- ----------------------------
DROP TABLE IF EXISTS `sweet_goods_attrbute_key`;
CREATE TABLE `sweet_goods_attrbute_key`  (
  `attribute_key_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品属性KeyId',
  `attribute_key_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品属性Key名称',
  PRIMARY KEY (`attribute_key_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性Key' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_goods_attrbute_value
-- ----------------------------
DROP TABLE IF EXISTS `sweet_goods_attrbute_value`;
CREATE TABLE `sweet_goods_attrbute_value`  (
  `attrbute_value_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '商品属性值Id',
  `attrbute_value_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品属性值名称',
  PRIMARY KEY (`attrbute_value_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性Value' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_goods_brand
-- ----------------------------
DROP TABLE IF EXISTS `sweet_goods_brand`;
CREATE TABLE `sweet_goods_brand`  (
  `brand_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌Id',
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `brand_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌图片',
  `brand_originator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌创始人',
  `brand_corporation` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌公司',
  `brand_presentation` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '品牌介绍',
  `brand_create_time` datetime(0) NULL DEFAULT NULL COMMENT '品牌创建时间',
  `brand_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '品牌是否显示',
  `brand_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '品牌是否删除',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '品牌' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_goods_brand
-- ----------------------------
INSERT INTO `sweet_goods_brand` VALUES (1, '小米', 'http://s02.mifile.cn/assets/static/image/logo-mi2.png', '雷军', NULL, NULL, '2021-04-26 02:57:23', 1, 0);
INSERT INTO `sweet_goods_brand` VALUES (2, '华为', 'http://www-file.huawei.com/-/media/corporate/images/home/logo/huawei_logo.png', '任正非', NULL, NULL, '2021-04-26 02:57:25', 1, 0);
INSERT INTO `sweet_goods_brand` VALUES (3, '中兴', NULL, NULL, NULL, NULL, '2021-04-26 02:57:28', 1, 0);
INSERT INTO `sweet_goods_brand` VALUES (4, 'OPPO', NULL, NULL, NULL, NULL, '2021-04-26 02:57:31', 1, 0);

-- ----------------------------
-- Table structure for sweet_goods_category
-- ----------------------------
DROP TABLE IF EXISTS `sweet_goods_category`;
CREATE TABLE `sweet_goods_category`  (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `category_sid` bigint(20) NULL DEFAULT NULL COMMENT '分类父分类',
  `category_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '分类是否显示',
  `category_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '分类是否删除',
  `category_create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分类' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_goods_category
-- ----------------------------
INSERT INTO `sweet_goods_category` VALUES (1, '家用电器', 0, 1, 0, '2021-04-26 03:05:31');
INSERT INTO `sweet_goods_category` VALUES (2, '电脑', 0, 1, 0, '2021-04-26 03:05:35');

-- ----------------------------
-- Table structure for sweet_goods_shop
-- ----------------------------
DROP TABLE IF EXISTS `sweet_goods_shop`;
CREATE TABLE `sweet_goods_shop`  (
  `shop_id` bigint(20) NOT NULL COMMENT '店铺id',
  `shop_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺名称',
  `shop_uid` bigint(20) NULL DEFAULT NULL COMMENT '店铺用户id',
  `shop_category` bigint(20) NULL DEFAULT NULL COMMENT '店铺分类',
  `shop_boss` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺法人',
  `shop_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺地区',
  `shop_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺地址',
  `shop_license` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺营业执照',
  `shop_atth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺属性',
  `shop_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺联系电话',
  `shop_create_time` datetime(0) NULL DEFAULT NULL COMMENT '店铺创建时间',
  `shop_audit_time` datetime(0) NULL DEFAULT NULL COMMENT '店铺审核使劲按',
  `shop_status` tinyint(1) NULL DEFAULT NULL COMMENT '店铺状态',
  `shop_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '店铺是否显示',
  `shop_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '店铺是否删除',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_goods_shop
-- ----------------------------
INSERT INTO `sweet_goods_shop` VALUES (0, '龙叔智芯', 10000, 1, '姚继龙', '江苏省徐州市睢宁县', '姚集镇姚集村二组8号', 'https://www.qcc.com/firm/84dae7a8c53f7cf73fd6dbe4fe3cb6cd.html', '姚继龙', '14752169639', '2021-04-26 03:30:54', '2021-04-26 03:30:56', 1, 1, 0);

-- ----------------------------
-- Table structure for sweet_goods_spu
-- ----------------------------
DROP TABLE IF EXISTS `sweet_goods_spu`;
CREATE TABLE `sweet_goods_spu`  (
  `spu_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '商品的id',
  `spu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `spu_sid` bigint(50) NULL DEFAULT NULL COMMENT '商品商户',
  `spu_one_cid` int(11) NULL DEFAULT NULL COMMENT '商品一级分类',
  `spu_two_cid` int(11) NULL DEFAULT NULL COMMENT '商品二级分类',
  `spu_three_cid` int(11) NULL DEFAULT NULL COMMENT '商品三级分类',
  `spu_details` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品详情',
  `spu_bid` bigint(20) NULL DEFAULT NULL COMMENT '商品品牌id',
  `spu_cid` int(11) NULL DEFAULT NULL COMMENT '商品分类id',
  `spu_create_time` datetime(0) NULL DEFAULT NULL COMMENT '商品创建时间',
  `spu_status` tinyint(2) NULL DEFAULT NULL COMMENT '商品状态',
  PRIMARY KEY (`spu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_label
-- ----------------------------
DROP TABLE IF EXISTS `sweet_label`;
CREATE TABLE `sweet_label`  (
  `label_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `label_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `label_create_time` datetime(0) NULL DEFAULT NULL COMMENT '标签创建时间',
  `label_synopsis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签简介',
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频标签' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_pay_order
-- ----------------------------
DROP TABLE IF EXISTS `sweet_pay_order`;
CREATE TABLE `sweet_pay_order`  (
  `order_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `order_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单类型',
  `order_total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `order_pay_time` datetime(0) NULL DEFAULT NULL COMMENT '订单交易时间',
  `order_status` int(2) NULL DEFAULT NULL COMMENT '订单状态',
  `order_uid` int(11) NULL DEFAULT NULL COMMENT '订单用户id',
  `order_remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '订单备注',
  `order_pay_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单支付方式',
  `order_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '订单是否删除',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1497030939681738754 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付订单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_pay_order
-- ----------------------------
INSERT INTO `sweet_pay_order` VALUES (1496848640352702465, NULL, '3', NULL, '2022-02-24 14:05:00', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497016038296899585, NULL, '3', NULL, '2022-02-25 01:10:11', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497021994028224513, NULL, '3', NULL, '2022-02-25 01:33:51', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497021994045001730, NULL, '3', NULL, '2022-02-25 01:33:51', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497023852868259842, NULL, '3', NULL, '2022-02-25 01:41:15', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497026170581929985, NULL, '3', NULL, '2022-02-25 01:50:27', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497028285547139074, NULL, '3', NULL, '2022-02-25 01:58:51', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497029166032211969, NULL, '3', NULL, '2022-02-25 02:02:20', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497029169366683649, NULL, '3', NULL, '2022-02-25 02:02:22', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497029169366683650, NULL, '3', NULL, '2022-02-25 02:02:22', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497029169370877954, NULL, '3', NULL, '2022-02-25 02:02:22', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497029859090616322, NULL, '3', NULL, '2022-02-25 02:05:07', NULL, 0, NULL, NULL, '1', NULL);
INSERT INTO `sweet_pay_order` VALUES (1497030939681738753, NULL, '3', NULL, '2022-02-25 02:09:24', NULL, 0, NULL, NULL, '1', NULL);

-- ----------------------------
-- Table structure for sweet_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sweet_privilege`;
CREATE TABLE `sweet_privilege`  (
  `privilege_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `privilege_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`privilege_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_user
-- ----------------------------
DROP TABLE IF EXISTS `sweet_user`;
CREATE TABLE `sweet_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户微信OpenId',
  `user_alipay_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的支付宝账号',
  `user_qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户qq',
  `user_birthday` date NULL DEFAULT NULL COMMENT '用户生日',
  `user_identity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户证件名称',
  `user_identity_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户证件号',
  `user_create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户创建时间',
  `user_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '用户钱包',
  `user_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户地区',
  `user_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `user_sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户个性签名',
  `user_invite_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邀请码',
  `user_status` int(5) NULL DEFAULT NULL COMMENT '用户状态',
  `user_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '用户是否删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_user
-- ----------------------------
INSERT INTO `sweet_user` VALUES (10000, 'DragonUncle', '14752169639', '47a74a91dc0a5bca45931d557d004e67514319eb3655a5d2d7d4850bb4eb1c4a', 'DragonUncle@qq.com', NULL, NULL, '565352671', NULL, '姚继龙', '320324199708091933', '2021-04-26 03:08:44', NULL, 0.00, '江苏省徐州市睢宁县', '姚集镇姚集村二组8号', '1', '困难的人生无所畏惧', '', 1, 0);

-- ----------------------------
-- Table structure for sweet_user_attention
-- ----------------------------
DROP TABLE IF EXISTS `sweet_user_attention`;
CREATE TABLE `sweet_user_attention`  (
  `user_attention_uid` bigint(50) NOT NULL DEFAULT 0 COMMENT '关注的用户',
  `user_attention_aid` bigint(20) NULL DEFAULT NULL COMMENT '被关注的用户',
  `user_attention_create_time` datetime(0) NULL DEFAULT NULL COMMENT '关注时间',
  `user_attention_cancel_time` datetime(0) NULL DEFAULT NULL COMMENT '关注取消时间',
  PRIMARY KEY (`user_attention_uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户关注' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_user_location
-- ----------------------------
DROP TABLE IF EXISTS `sweet_user_location`;
CREATE TABLE `sweet_user_location`  (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '位置Id',
  `location_uid` bigint(20) NULL DEFAULT NULL COMMENT '位置用户Id',
  `location_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '位置名称',
  `location_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '位置区域',
  `location_address` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '位置地址',
  `location_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '位置联系方式',
  `location_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '位置标签',
  `location_create_time` datetime(0) NULL DEFAULT NULL COMMENT '位置创建时间',
  `location_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '位置是否删除',
  PRIMARY KEY (`location_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户收货地址' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sweet_user_location
-- ----------------------------
INSERT INTO `sweet_user_location` VALUES (1, 10000, '家', '江苏省徐州市睢宁县', '姚集镇姚集村二组8号', '14752169639', '1', '2021-04-26 03:25:14', 0);

-- ----------------------------
-- Table structure for sweet_user_record
-- ----------------------------
DROP TABLE IF EXISTS `sweet_user_record`;
CREATE TABLE `sweet_user_record`  (
  `user_record_tid` int(11) NULL DEFAULT NULL COMMENT '用户操作类型id',
  `user_record_uid` bigint(50) NULL DEFAULT NULL COMMENT '用户操作用户id',
  `user_record_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作内容或结果',
  `user_record_create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户操作时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户操作' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_user_record_type
-- ----------------------------
DROP TABLE IF EXISTS `sweet_user_record_type`;
CREATE TABLE `sweet_user_record_type`  (
  `user_record_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户操作记录类型id',
  `user_record_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作记录类型名称',
  PRIMARY KEY (`user_record_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户操作类型' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_user_vip
-- ----------------------------
DROP TABLE IF EXISTS `sweet_user_vip`;
CREATE TABLE `sweet_user_vip`  (
  `user_vip_vid` int(11) NOT NULL COMMENT '用户会员的会员id',
  `user_vip_uid` bigint(20) NULL DEFAULT NULL COMMENT '用户会员的用户id',
  `user_vip_way` tinyint(1) NULL DEFAULT NULL COMMENT '用户会员的开通方式',
  `user_vip_pay_time` datetime(0) NULL DEFAULT NULL COMMENT '用户会员的支付时间',
  `user_vip_create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户会员的创建时间',
  `user_vip_finish_time` datetime(0) NULL DEFAULT NULL COMMENT '用户会员的结束时间',
  PRIMARY KEY (`user_vip_vid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户会员' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_video
-- ----------------------------
DROP TABLE IF EXISTS `sweet_video`;
CREATE TABLE `sweet_video`  (
  `video_id` int(50) NOT NULL AUTO_INCREMENT COMMENT '视频Id',
  `video_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频名称',
  `video_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频地址',
  `video_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '视频价格',
  `video_original_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '视频原价',
  `video_author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频作者',
  `video_collect_number` bigint(50) NULL DEFAULT NULL COMMENT '视频收藏数量',
  `video_like_number` bigint(50) NULL DEFAULT NULL COMMENT '视频喜欢数量',
  `video_watch_number` bigint(50) NULL DEFAULT NULL COMMENT '视频观看数量',
  `video_appreciate_number` bigint(50) NULL DEFAULT NULL COMMENT '视频打赏数量',
  `video_evaluate_number` bigint(50) NULL DEFAULT NULL COMMENT '视频评价数量',
  `video_score_number` bigint(50) NULL DEFAULT NULL COMMENT '视频评分数量',
  `video_dislike_number` bigint(50) NULL DEFAULT NULL COMMENT '视频不喜欢数量',
  `video_is_vip` tinyint(1) NULL DEFAULT NULL COMMENT '视频是否所需VIP',
  `video_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '视频是否显示',
  `video_is_del` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频是否删除',
  `video_create_time` datetime(0) NULL DEFAULT NULL COMMENT '视频创建时间',
  PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频列表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_video_action
-- ----------------------------
DROP TABLE IF EXISTS `sweet_video_action`;
CREATE TABLE `sweet_video_action`  (
  `video_action_uid` bigint(20) NOT NULL COMMENT '视频操作用户id',
  `video_action_vid` bigint(20) NULL DEFAULT NULL COMMENT '视频操作视频id',
  `video_action_tid` int(11) NULL DEFAULT NULL COMMENT '视频操作类型id',
  `video_action_create_time` datetime(0) NULL DEFAULT NULL COMMENT '视频操作时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频操作记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_video_action_type
-- ----------------------------
DROP TABLE IF EXISTS `sweet_video_action_type`;
CREATE TABLE `sweet_video_action_type`  (
  `video_action_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '视频动作类型id',
  `video_action_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频动作类型名称',
  PRIMARY KEY (`video_action_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频动作类型' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_video_category
-- ----------------------------
DROP TABLE IF EXISTS `sweet_video_category`;
CREATE TABLE `sweet_video_category`  (
  `video_category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '视频分类id',
  `video_category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频分类名称',
  `video_category_ico` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频分类图片',
  `video_category_pid` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '视频分类父id',
  `video_category_create_time` datetime(0) NULL DEFAULT NULL COMMENT '视频分类创建时间',
  `video_category_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '视频分类是否显示',
  `video_category_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '视频分类是否删除',
  PRIMARY KEY (`video_category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频分类' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_video_comment
-- ----------------------------
DROP TABLE IF EXISTS `sweet_video_comment`;
CREATE TABLE `sweet_video_comment`  (
  `video_comment_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '视频评论id',
  `video_comment_uid` bigint(50) NULL DEFAULT NULL COMMENT '视频评论用户',
  `video_comment_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频评论内容',
  `video_comment_pid` bigint(50) NULL DEFAULT NULL COMMENT '视频评论回复评论Id',
  `video_comment_like_number` bigint(50) NULL DEFAULT NULL COMMENT '视频评论喜欢数量',
  `video_comment_vid` bigint(50) NULL DEFAULT NULL COMMENT '视频评论视频Id',
  `video_comment_create_time` datetime(0) NULL DEFAULT NULL COMMENT '视频评论创建时间',
  `video_comment_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '视频评论是否可见',
  `video_comment_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '视频评论是否删除',
  PRIMARY KEY (`video_comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频评论' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_video_label
-- ----------------------------
DROP TABLE IF EXISTS `sweet_video_label`;
CREATE TABLE `sweet_video_label`  (
  `video_label_vid` bigint(50) NOT NULL,
  `video_label_lid` bigint(50) NULL DEFAULT NULL,
  PRIMARY KEY (`video_label_vid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sweet_vip
-- ----------------------------
DROP TABLE IF EXISTS `sweet_vip`;
CREATE TABLE `sweet_vip`  (
  `vip_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `vip_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员等级',
  `vip_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '会员价格',
  `vip_original_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '会员原价',
  `vip_synopsis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员简介',
  `vip_duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员时长',
  `vip_is_show` tinyint(1) NULL DEFAULT NULL COMMENT '会员是否展示',
  `vip_is_del` tinyint(1) NULL DEFAULT NULL COMMENT '会员是否删除',
  `vip_create_time` datetime(0) NULL DEFAULT NULL COMMENT '会员创建时间',
  `vip_discounts` float NULL DEFAULT NULL COMMENT '会员折扣',
  `vip_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员名称',
  PRIMARY KEY (`vip_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员列表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
