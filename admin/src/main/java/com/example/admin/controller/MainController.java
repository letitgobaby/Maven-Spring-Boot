package com.example.admin.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class MainController {
  
  @GetMapping(value = {"/", "/login"})
  public String index() {
    System.out.println("~ index ~");
    return "index";
  }

}
