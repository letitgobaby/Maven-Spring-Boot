package com.example.site.controller;

import lombok.val;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(Model model, String msg) {
        model.addAttribute("title", "jinwooJeong");
        model.addAttribute("subtitle", "hello jinwoo !!");


        var itemList = new ArrayList<>();
        val item = new HashMap<String, String>();

        item.put("title", "joins.net.blog");
        item.put("subtitle", "hello ~~!!!~~!");
        item.put("href", "post");
        item.put("updated", "2020/01.01");

        itemList.add(item);
        itemList.add(item);
        itemList.add(item);

        model.addAttribute("itemList", itemList);

        // webMVC의 디스패치 컨트롤러 흐름 찾아보기
        return "index";
    }


    @GetMapping("/post")
    public String post(Model model) {
        val item = new HashMap<String, String>();

        item.put("title", "joins.net.blog");
        item.put("subtitle", "hello ~~!!!~~!");
        item.put("updated", "2020/01.01");

        String content = "<h1>POST HTML TEST</h1>";
        content += "<img class=\"img-fluid\" src=\"img/post-sample-image.jpg\" alt=\"\">";
        item.put("content", content);

        item.put("banner", "images/post-bg.jpg");

        model.addAttribute("item", item);
        return "post";
    }



}
