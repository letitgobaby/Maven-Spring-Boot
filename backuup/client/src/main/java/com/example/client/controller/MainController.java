package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.core.model.Post;
import com.example.core.service.PostService;


@Controller
@RequestMapping("/")
public class MainController {

  @Autowired
  private PostService postService;

  @GetMapping
  public String index(Model model) {

    model.addAttribute("title", "jinwooJeong");
    model.addAttribute("subtitle", "hello jinwoo !!");


    // ArrayList<HashMap> itemList = new ArrayList<>();
    // HashMap item = new HashMap<String, String>();

    // item.put("title", "joins.net.blog");
    // item.put("subtitle", "hello ~~!!!~~!");
    // item.put("href", "post");
    // item.put("updated", "2020/01.01");

    // itemList.add(item);
    // itemList.add(item);
    // itemList.add(item);

    // System.out.println( item );

    // model.addAttribute("itemList", itemList);


    model.addAttribute("itemList", postService.findAll());

    // webMVC의 디스패치 컨트롤러 흐름 찾아보기
    return "index";
  }



}
