package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.example.core.model.Post;
import com.example.core.service.PostService;
import com.example.core.service.TestService;


@Controller
public class MainController {

  @Autowired
  private TestService service;

  @Autowired
  private PostService postService;

  @GetMapping(value = "/")
  public String abc() {
    System.out.println( service.helloWorld() );

    // List<Post> lists = postService.test();
    System.out.println( postService );
    // System.out.println( postService.findAll() );

    return "index.html";
  }

}
