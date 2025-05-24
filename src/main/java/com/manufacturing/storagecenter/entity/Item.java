package com.manufacturing.storagecenter.entity;

import java.util.Date;

/**
 * 物品实体类
 */
public class Item {
    
    /**
     * 物品ID
     */
    private Long id;
    
    /**
     * 物品名称
     */
    private String name;
    
    /**
     * 物品编码
     */
    private String code;
    
    /**
     * 物品类型：1-原料，2-半成品，3-成品
     */
    private Integer type;
    
    /**
     * 物品规格
     */
    private String specification;
    
    /**
     * 物品数量
     */
    private Integer quantity;
    
    /**
     * 物品单位
     */
    private String unit;
    
    /**
     * 存储区域：1-原料区，2-半成品区，3-成品区
     */
    private Integer storageArea;
    
    /**
     * 存储位置
     */
    private String storageLocation;
    
    /**
     * 入库时间
     */
    private Date inboundTime;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 备注
     */
    private String remark;

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStorageArea() {
        return storageArea;
    }

    public void setStorageArea(Integer storageArea) {
        this.storageArea = storageArea;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public Date getInboundTime() {
        return inboundTime;
    }

    public void setInboundTime(Date inboundTime) {
        this.inboundTime = inboundTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}