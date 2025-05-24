package com.manufacturing.storagecenter.mapper;

import com.manufacturing.storagecenter.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物品Mapper接口
 */
@Mapper
public interface ItemMapper {
    
    /**
     * 添加物品
     * 
     * @param item 物品信息
     * @return 影响行数
     */
    int insert(Item item);
    
    /**
     * 根据ID删除物品
     * 
     * @param id 物品ID
     * @return 影响行数
     */
    int deleteById(Long id);
    
    /**
     * 更新物品信息
     * 
     * @param item 物品信息
     * @return 影响行数
     */
    int update(Item item);
    
    /**
     * 根据ID查询物品
     * 
     * @param id 物品ID
     * @return 物品信息
     */
    Item selectById(Long id);
    
    /**
     * 查询所有物品
     * 
     * @return 物品列表
     */
    List<Item> selectAll();
    
    /**
     * 根据物品类型查询物品
     * 
     * @param type 物品类型
     * @return 物品列表
     */
    List<Item> selectByType(Integer type);
    
    /**
     * 根据存储区域查询物品
     * 
     * @param storageArea 存储区域
     * @return 物品列表
     */
    List<Item> selectByStorageArea(Integer storageArea);
    
    /**
     * 根据物品名称模糊查询
     * 
     * @param name 物品名称
     * @return 物品列表
     */
    List<Item> selectByNameLike(@Param("name") String name);
}