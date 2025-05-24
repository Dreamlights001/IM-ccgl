package com.manufacturing.storagecenter.service.impl;

import com.manufacturing.storagecenter.entity.Item;
import com.manufacturing.storagecenter.mapper.ItemMapper;
import com.manufacturing.storagecenter.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 物品服务实现类
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public boolean addItem(Item item) {
        // 根据物品类型判断存储区域
        if (item.getStorageArea() == null) {
            item.setStorageArea(determineStorageArea(item));
        }
        
        // 设置入库时间和创建时间
        if (item.getInboundTime() == null) {
            item.setInboundTime(new Date());
        }
        
        return itemMapper.insert(item) > 0;
    }

    @Override
    public boolean deleteItem(Long id) {
        return itemMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateItem(Item item) {
        // 如果物品类型改变，重新判断存储区域
        Item oldItem = itemMapper.selectById(item.getId());
        if (oldItem != null && item.getType() != null && !item.getType().equals(oldItem.getType())) {
            item.setStorageArea(determineStorageArea(item));
        }
        
        return itemMapper.update(item) > 0;
    }

    @Override
    public Item getItemById(Long id) {
        return itemMapper.selectById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemMapper.selectAll();
    }

    @Override
    public List<Item> getItemsByType(Integer type) {
        return itemMapper.selectByType(type);
    }

    @Override
    public List<Item> getItemsByStorageArea(Integer storageArea) {
        return itemMapper.selectByStorageArea(storageArea);
    }

    @Override
    public List<Item> getItemsByNameLike(String name) {
        return itemMapper.selectByNameLike(name);
    }

    @Override
    public Integer determineStorageArea(Item item) {
        // 根据物品类型判断存储区域
        // 1-原料，2-半成品，3-成品
        if (item.getType() == null) {
            // 默认为原料区
            return 1;
        }
        
        switch (item.getType()) {
            case 1:
                // 原料存放在原料区
                return 1;
            case 2:
                // 半成品存放在半成品区
                return 2;
            case 3:
                // 成品存放在成品区
                return 3;
            default:
                // 默认为原料区
                return 1;
        }
    }
}