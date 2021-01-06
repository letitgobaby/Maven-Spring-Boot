package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
  public String index(@PageableDefault Pageable pageable, Model model) {

    model.addAttribute("title", "jinwooJeong");
    model.addAttribute("subtitle", "hello jinwoo !!");

    Page<Post> postlist = postService.getPostList(pageable);
    model.addAttribute("itemList", postlist);

    model.addAttribute("page", pageable.getPageNumber());
    model.addAttribute("size", pageable.getPageSize());

    // webMVC의 디스패치 컨트롤러 흐름 찾아보기
    return "index";
  }

}
