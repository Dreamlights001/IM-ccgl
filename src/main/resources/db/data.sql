-- 使用数据库
USE storage_center;

-- 插入测试数据
-- 原料
INSERT INTO item (name, code, type, specification, quantity, unit, storage_area, storage_location, inbound_time, create_time, update_time, remark)
VALUES
('钢材A', 'RM001', 1, '规格：10mm*100mm*1000mm', 100, '件', 1, 'A区-01-01', NOW(), NOW(), NOW(), '优质钢材'),
('铝材B', 'RM002', 1, '规格：5mm*50mm*500mm', 200, '件', 1, 'A区-01-02', NOW(), NOW(), NOW(), '轻质铝材'),
('铜材C', 'RM003', 1, '规格：2mm*20mm*200mm', 150, '件', 1, 'A区-01-03', NOW(), NOW(), NOW(), '导电铜材'),
('塑料颗粒D', 'RM004', 1, '规格：直径3mm', 500, '千克', 1, 'A区-02-01', NOW(), NOW(), NOW(), '高强度塑料'),
('橡胶E', 'RM005', 1, '规格：厚度5mm', 300, '平方米', 1, 'A区-02-02', NOW(), NOW(), NOW(), '耐磨橡胶');

-- 半成品
INSERT INTO item (name, code, type, specification, quantity, unit, storage_area, storage_location, inbound_time, create_time, update_time, remark)
VALUES
('钢制框架', 'SP001', 2, '规格：500mm*500mm*50mm', 50, '件', 2, 'B区-01-01', NOW(), NOW(), NOW(), '机器外壳框架'),
('铝制散热片', 'SP002', 2, '规格：100mm*100mm*10mm', 100, '件', 2, 'B区-01-02', NOW(), NOW(), NOW(), '电子设备散热片'),
('铜质接头', 'SP003', 2, '规格：直径10mm', 200, '件', 2, 'B区-01-03', NOW(), NOW(), NOW(), '电路连接接头'),
('塑料外壳', 'SP004', 2, '规格：200mm*150mm*30mm', 80, '件', 2, 'B区-02-01', NOW(), NOW(), NOW(), '设备保护外壳'),
('橡胶密封圈', 'SP005', 2, '规格：直径50mm', 300, '件', 2, 'B区-02-02', NOW(), NOW(), NOW(), '防水密封圈');

-- 成品
INSERT INTO item (name, code, type, specification, quantity, unit, storage_area, storage_location, inbound_time, create_time, update_time, remark)
VALUES
('智能控制器', 'FP001', 3, '型号：SC-100', 30, '台', 3, 'C区-01-01', NOW(), NOW(), NOW(), '工业自动化控制器'),
('传感器模块', 'FP002', 3, '型号：SM-200', 50, '个', 3, 'C区-01-02', NOW(), NOW(), NOW(), '温湿度传感器'),
('电机驱动器', 'FP003', 3, '型号：MD-300', 40, '台', 3, 'C区-01-03', NOW(), NOW(), NOW(), '高精度电机驱动'),
('工业显示屏', 'FP004', 3, '型号：ID-400', 20, '台', 3, 'C区-02-01', NOW(), NOW(), NOW(), '触摸式显示屏'),
('通信网关', 'FP005', 3, '型号：CG-500', 25, '台', 3, 'C区-02-02', NOW(), NOW(), NOW(), '工业物联网网关');