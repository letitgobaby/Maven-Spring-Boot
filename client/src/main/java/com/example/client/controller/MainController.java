package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.core.service.TestService;


@Controller
public class MainController {

  @Autowired
  private TestService service;

  @GetMapping(value = "/")
  public String abc() {
    System.out.println( service.helloWorld() );
    return "index.html";
  }

}
