package com.example.admin.api;

import java.util.List;

import com.example.core.model.Post;
import com.example.core.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {
  
  @Autowired
  private PostService postService;

  @GetMapping(value = "/api/counts")
  public @ResponseBody Long getCountAll() {
    return postService.getCountAll();
  }
  
  @GetMapping(value = "/api/posts")
	public @ResponseBody JSONObject postPaging(@PageableDefault Pageable pageable) {
    JSONObject result = new JSONObject();
    List<Post> postlist = postService.getPostList(pageable);

    result.put("data", postlist);
    result.put("page", pageable.getPageNumber());
    result.put("size", pageable.getPageSize());
    
    return result;
  }

  @GetMapping(value = "/api/posts/{id}")
  public @ResponseBody Post getOne(@PathVariable("id") Long id) {
    return postService.getOne(id);
  }

  @PostMapping(value = "/api/posts")
  public @ResponseBody void addPost(@RequestBody JSONObject jobj) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      String postJson = mapper.writeValueAsString(jobj);
      Post post = mapper.readValue(postJson, Post.class);
      
      System.out.println("addPost");
      postService.addPost(post);
    } catch(Exception e) {
      System.out.println("ERROR - " + e);
    }
  }

  @PutMapping(value = "/api/posts")
  public @ResponseBody void updatePost(@RequestBody JSONObject jobj) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      String postJson = mapper.writeValueAsString(jobj);
      Post post = mapper.readValue(postJson, Post.class);
      
      System.out.println("updatePost");
      postService.updatePost(post);
    } catch(Exception e) {
      System.out.println("ERROR - " + e);
    }
  }

  @DeleteMapping(value = "/api/posts/{id}")
  public @ResponseBody void deletePost(@PathVariable("id") Long id) {
    System.out.println("deletePost");
    postService.deletePost(id);
  }



}
