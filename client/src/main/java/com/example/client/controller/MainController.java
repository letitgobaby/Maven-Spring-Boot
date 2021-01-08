package com.example.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MainController {

  // @ModelAttribute("info")
  // public Map<String, String> defaultInfo() {

  //   Map<String, String> info = new HashMap<>();
  //   info.put("title", "jinwooJeong");
  //   info.put("subtitle", "hello jinwoo !!");
  //   return info;
  // }

  @GetMapping
  public String index(Model model) {

    // Title, SubTitle
    model.addAttribute("title", "jinwooJeong");
    model.addAttribute("subtitle", "hello jinwoo !!");

    return "index";
  }


}
