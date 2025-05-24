-- 创建数据库
CREATE DATABASE IF NOT EXISTS storage_center DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE storage_center;

-- 创建物品表
CREATE TABLE IF NOT EXISTS item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '物品ID',
    name VARCHAR(100) NOT NULL COMMENT '物品名称',
    code VARCHAR(50) NOT NULL COMMENT '物品编码',
    type INT NOT NULL COMMENT '物品类型：1-原料，2-半成品，3-成品',
    specification VARCHAR(200) COMMENT '物品规格',
    quantity INT NOT NULL DEFAULT 0 COMMENT '物品数量',
    unit VARCHAR(20) NOT NULL COMMENT '物品单位',
    storage_area INT NOT NULL COMMENT '存储区域：1-原料区，2-半成品区，3-成品区',
    storage_location VARCHAR(100) COMMENT '存储位置',
    inbound_time DATETIME NOT NULL COMMENT '入库时间',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    remark TEXT COMMENT '备注',
    INDEX idx_type (type),
    INDEX idx_storage_area (storage_area),
    INDEX idx_name (name),
    INDEX idx_code (code),
    INDEX idx_inbound_time (inbound_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物品表';