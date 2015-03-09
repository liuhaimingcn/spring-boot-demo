CREATE TABLE `account` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别（0：无，1：男，2：女）',
  `openid` varchar(255) DEFAULT NULL COMMENT '第三方用户id',
  `account_from` int(1) DEFAULT NULL COMMENT '账户的来源',
  `created_on` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '记标数据是否被删除（1 正常， 0 删除， 默认为1）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `collect` (
  `id` varchar(32) NOT NULL,
  `account_id` varchar(32) DEFAULT NULL,
  `detail_id` varchar(32) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `detail` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'uuid主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  `picture` varchar(255) DEFAULT NULL COMMENT '主照片',
  `photos` text COMMENT '内容',
  `type` int(1) DEFAULT NULL COMMENT '类型（0：专题，1：风格）',
  `style_type` int(11) DEFAULT NULL COMMENT '风格类型',
  `special_id` varchar(32) DEFAULT NULL COMMENT '主题主键',
  `special_url` varchar(255) DEFAULT NULL COMMENT '专题链接',
  `created_on` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '记标数据是否被删除（1 正常， 0 删除， 默认为1）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `special` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'uuid主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  `picture` varchar(255) DEFAULT NULL COMMENT '主照片',
  `created_on` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '记标数据是否被删除（1 正常， 0 删除， 默认为1）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;