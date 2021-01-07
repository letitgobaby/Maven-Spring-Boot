package com.example.client.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.example.core.model.Post;
import com.example.core.service.PostService;


@Controller
@RequestMapping("/")
public class MainController {

  @GetMapping
  public String index(Model model) {

    // Title, SubTitle
    model.addAttribute("title", "jinwooJeong");
    model.addAttribute("subtitle", "hello jinwoo !!");

    return "index";
  }


}
