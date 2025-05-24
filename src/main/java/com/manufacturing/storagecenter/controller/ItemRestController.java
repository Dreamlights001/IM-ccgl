package com.manufacturing.storagecenter.controller;

import com.manufacturing.storagecenter.entity.Item;
import com.manufacturing.storagecenter.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物品REST控制器
 */
@RestController
@RequestMapping("/api/items")
public class ItemRestController {

    @Autowired
    private ItemService itemService;

    /**
     * 获取所有物品
     */
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    /**
     * 根据ID获取物品
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 添加物品
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> addItem(@RequestBody Item item) {
        boolean success = itemService.addItem(item);
        Map<String, Object> result = new HashMap<>();
        if (success) {
            result.put("success", true);
            result.put("message", "添加成功");
            result.put("item", item);
            return ResponseEntity.ok(result);
        } else {
            result.put("success", false);
            result.put("message", "添加失败");
            return ResponseEntity.badRequest().body(result);
        }
    }

    /**
     * 更新物品
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateItem(@PathVariable("id") Long id, @RequestBody Item item) {
        item.setId(id);
        boolean success = itemService.updateItem(item);
        Map<String, Object> result = new HashMap<>();
        if (success) {
            result.put("success", true);
            result.put("message", "更新成功");
            return ResponseEntity.ok(result);
        } else {
            result.put("success", false);
            result.put("message", "更新失败");
            return ResponseEntity.badRequest().body(result);
        }
    }

    /**
     * 删除物品
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteItem(@PathVariable("id") Long id) {
        boolean success = itemService.deleteItem(id);
        Map<String, Object> result = new HashMap<>();
        if (success) {
            result.put("success", true);
            result.put("message", "删除成功");
            return ResponseEntity.ok(result);
        } else {
            result.put("success", false);
            result.put("message", "删除失败");
            return ResponseEntity.badRequest().body(result);
        }
    }

    /**
     * 根据物品类型查询
     */
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Item>> getItemsByType(@PathVariable("type") Integer type) {
        List<Item> items = itemService.getItemsByType(type);
        return ResponseEntity.ok(items);
    }

    /**
     * 根据存储区域查询
     */
    @GetMapping("/area/{area}")
    public ResponseEntity<List<Item>> getItemsByArea(@PathVariable("area") Integer area) {
        List<Item> items = itemService.getItemsByStorageArea(area);
        return ResponseEntity.ok(items);
    }

    /**
     * 根据名称模糊查询
     */
    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItems(@RequestParam("name") String name) {
        List<Item> items = itemService.getItemsByNameLike(name);
        return ResponseEntity.ok(items);
    }

    /**
     * 判断物品存储区域
     */
    @PostMapping("/determine-area")
    public ResponseEntity<Map<String, Object>> determineStorageArea(@RequestBody Item item) {
        Integer area = itemService.determineStorageArea(item);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("storageArea", area);
        String areaName = "未知区域";
        switch (area) {
            case 1:
                areaName = "原料区";
                break;
            case 2:
                areaName = "半成品区";
                break;
            case 3:
                areaName = "成品区";
                break;
        }
        result.put("areaName", areaName);
        return ResponseEntity.ok(result);
    }
}