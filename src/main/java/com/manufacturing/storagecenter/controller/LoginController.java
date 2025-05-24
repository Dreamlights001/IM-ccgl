package com.manufacturing.storagecenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "123";

    @GetMapping("")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, 
                              @RequestParam String password, 
                              HttpSession session,
                              Model model) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            // 登录成功，存储用户信息到会话
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username);
            // 重定向到物品列表页
            return "redirect:/items/list";
        } else {
            // 登录失败，返回登录页面并显示错误信息
            model.addAttribute("error", "用户名或密码不正确");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
} 