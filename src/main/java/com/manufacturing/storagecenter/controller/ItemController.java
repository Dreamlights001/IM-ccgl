package com.manufacturing.storagecenter.controller;

import com.manufacturing.storagecenter.entity.Item;
import com.manufacturing.storagecenter.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;

import java.util.List;

/**
 * 物品控制器
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 物品列表页面
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "item/list";
    }

    /**
     * 添加物品页面
     */
    @GetMapping("/add")
    public String add() {
        return "item/add";
    }

    /**
     * 添加物品
     */
    @PostMapping("/add")
    public String add(Item item) {
        itemService.addItem(item);
        return "redirect:/items/list";
    }

    /**
     * 编辑物品页面
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item/edit";
    }

    /**
     * 更新物品
     */
    @PostMapping("/edit")
    public String edit(Item item) {
        itemService.updateItem(item);
        return "redirect:/items/list";
    }

    /**
     * 删除物品
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return "redirect:/items/list";
    }

    /**
     * 根据物品类型查询
     */
    @GetMapping("/type/{type}")
    public String listByType(@PathVariable("type") Integer type, Model model) {
        List<Item> items = itemService.getItemsByType(type);
        model.addAttribute("items", items);
        return "item/list";
    }

    /**
     * 根据存储区域查询
     */
    @GetMapping("/area/{area}")
    public String listByArea(@PathVariable("area") Integer area, Model model) {
        List<Item> items = itemService.getItemsByStorageArea(area);
        model.addAttribute("items", items);
        return "item/list";
    }

    /**
     * 根据名称模糊查询
     */
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Item> items = itemService.getItemsByNameLike(name);
        model.addAttribute("items", items);
        return "item/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
    }
}