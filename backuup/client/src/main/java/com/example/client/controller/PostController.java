package com.example.client.controller;

import java.util.HashMap;

import com.example.core.model.Post;
import com.example.core.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post")
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping
  public String postIndex(Model model, @RequestParam("page") Long id) {

    // HashMap item = new HashMap<String, String>();

    // item.put("title", "joins.net.blog");
    // item.put("subtitle", "hello ~~!!!~~!");
    // item.put("updated", "2020/01.01");

    // String content = "<h1>POST HTML TEST</h1>";
    // content += "<img class=\"img-fluid\" src=\"img/post-sample-image.jpg\" alt=\"\">";
    // item.put("content", content);
    // item.put("banner", "images/post-bg.jpg");

    // model.addAttribute("item", item);

    

    model.addAttribute("item", postService.findOne(id) );
    return "post";
  }
  
}
