package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class MainController {
  
  @GetMapping(value = {"/", "/login"})
  public String index() {
    System.out.println("~ index ~");
    return "index";
  }

}
