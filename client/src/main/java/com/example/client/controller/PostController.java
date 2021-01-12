package com.example.client.controller;

import com.example.core.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
  public String postIndex(Model model, @RequestParam("page") @Nullable Long id) {

    Long pageId = 1L;
    if ( id != null ) pageId = id;

    model.addAttribute("item", postService.getOne(pageId) );
    return "post";
  }
  

}
