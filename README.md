# 智能制造存储中心系统

## 项目简介

本项目是一个基于Spring Boot的智能制造存储中心管理系统，用于管理智能制造系统中的原料、半成品和成品的存储。系统实现了基本的增删查改功能，以及根据物品属性自动判断存储区域的功能。

## 技术栈

- 后端：Spring Boot 2.7.5
- 数据库：MySQL
- ORM框架：MyBatis
- 前端模板引擎：Thymeleaf
- 前端框架：Bootstrap 5
- 前端JS库：jQuery
- 图标库：Font Awesome
- 动画效果：Animate.css
- 自定义样式：CSS3
- 交互脚本：原生JavaScript
- 响应式设计：媒体查询

## 功能特性

1. 物品管理：增加、删除、修改、查询物品信息
2. 存储区域管理：根据物品类型自动判断存储区域（原料区、半成品区、成品区）
3. 多维度查询：支持按物品类型、存储区域、物品名称等多维度查询
4. 前后端分离：提供Web页面和RESTful API两种接口
5. 现代化交互界面：
   - 响应式设计：适配不同尺寸的设备屏幕
   - 中心化布局：表格、搜索栏等内容居中显示
   - 动态通知系统：操作反馈及时，增强用户体验
   - 交互式确认对话框：关键操作二次确认，避免误操作
   - 数据排序功能：支持按数量、时间等多维度排序
   - 美化操作按钮：视觉标识清晰，提高操作效率
   - 弹窗式详情查看：提供清晰的信息展示方式
   - 优化的筛选体验：筛选按钮样式优化，交互友好

## 系统架构

系统采用经典的三层架构：

1. 表示层（Controller）：处理用户请求，返回响应
2. 业务逻辑层（Service）：实现业务逻辑，如物品存储区域判断
3. 数据访问层（Mapper）：与数据库交互，实现数据的增删查改

## 前端设计与优化

### 视觉设计

- 现代化UI：采用简洁、扁平化的设计风格
- 一致的色彩方案：使用协调的配色，增强视觉识别性
- 自定义徽章样式：区分不同的物品类型和存储区域
- 表格样式优化：行间隔色、悬停效果，提升可读性
- 自定义滚动条：美化滚动条样式，改善浏览体验

### 交互优化

- 搜索功能强化：放大搜索栏，增强可见性和易用性
- 操作按钮美化：添加物品按钮优化为天蓝色，增强视觉引导
- 表格操作优化：移除不必要的ID列，简化表格内容
- 详情查看改进：从展开行式改为弹窗式
- 筛选按钮优化：修复点击后文字可见性问题，改为加粗样式

### 性能优化

- 动画效果：添加适当的过渡动画，增强用户体验
- 延迟加载：优化资源加载顺序，提高页面加载速度
- 响应式布局：针对不同设备进行布局优化

## 数据库设计

系统使用MySQL数据库，主要包含以下表：

- item：物品表，存储物品的基本信息和存储位置

## 快速开始

### 环境要求

- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- 现代浏览器（Chrome、Firefox、Edge等）

### 安装步骤

1. 克隆项目到本地

2. 创建MySQL数据库

```sql
CREATE DATABASE storage_center DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. 修改配置文件

编辑 `src/main/resources/application.properties` 文件，修改数据库连接信息：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/storage_center?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. 初始化数据库

执行 `src/main/resources/db/schema.sql` 创建表结构
执行 `src/main/resources/db/data.sql` 导入测试数据

5. 构建并运行项目

```bash
mvn clean package
java -jar target/storage-center-0.0.1-SNAPSHOT.jar
```

6. 访问系统

打开浏览器，访问 http://localhost:8080/items/list

## API文档

系统提供了RESTful API，可以通过以下接口进行访问：

### 物品管理API

- 获取所有物品：GET /api/items
- 根据ID获取物品：GET /api/items/{id}
- 添加物品：POST /api/items
- 更新物品：PUT /api/items/{id}
- 删除物品：DELETE /api/items/{id}
- 根据物品类型查询：GET /api/items/type/{type}
- 根据存储区域查询：GET /api/items/area/{area}
- 根据名称模糊查询：GET /api/items/search?name={name}
- 判断物品存储区域：POST /api/items/determine-area

## 扩展与优化方向

1. 用户认证与权限管理：添加用户登录和权限控制功能
2. 库存预警：实现库存不足自动预警功能
3. 数据统计与分析：添加数据可视化和分析功能
4. 条码/二维码支持：集成条码或二维码扫描功能
5. 移动端适配：开发移动端应用或优化移动端访问体验
6. 批量操作：支持物品的批量导入、导出和操作
7. 工作流集成：与生产工作流系统集成，实现自动化管理
8. 深色模式：增加深色模式支持，减轻夜间使用时的视觉疲劳
9. 更多主题选择：允许用户根据偏好选择不同界面主题

## 许可证

本项目采用MIT许可证。详情请参阅LICENSE文件。

---

© 2023-2024 智能制造存储中心系统团队。保留所有权利。