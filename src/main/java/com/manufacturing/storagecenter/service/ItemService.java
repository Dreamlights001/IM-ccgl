package com.manufacturing.storagecenter.service;

import com.manufacturing.storagecenter.entity.Item;

import java.util.List;

/**
 * 物品服务接口
 */
public interface ItemService {
    
    /**
     * 添加物品
     * 
     * @param item 物品信息
     * @return 是否成功
     */
    boolean addItem(Item item);
    
    /**
     * 删除物品
     * 
     * @param id 物品ID
     * @return 是否成功
     */
    boolean deleteItem(Long id);
    
    /**
     * 更新物品
     * 
     * @param item 物品信息
     * @return 是否成功
     */
    boolean updateItem(Item item);
    
    /**
     * 根据ID查询物品
     * 
     * @param id 物品ID
     * @return 物品信息
     */
    Item getItemById(Long id);
    
    /**
     * 查询所有物品
     * 
     * @return 物品列表
     */
    List<Item> getAllItems();
    
    /**
     * 根据物品类型查询物品
     * 
     * @param type 物品类型
     * @return 物品列表
     */
    List<Item> getItemsByType(Integer type);
    
    /**
     * 根据存储区域查询物品
     * 
     * @param storageArea 存储区域
     * @return 物品列表
     */
    List<Item> getItemsByStorageArea(Integer storageArea);
    
    /**
     * 根据物品名称模糊查询
     * 
     * @param name 物品名称
     * @return 物品列表
     */
    List<Item> getItemsByNameLike(String name);
    
    /**
     * 根据物品属性判断存储区域
     * 
     * @param item 物品信息
     * @return 存储区域：1-原料区，2-半成品区，3-成品区
     */
    Integer determineStorageArea(Item item);
}