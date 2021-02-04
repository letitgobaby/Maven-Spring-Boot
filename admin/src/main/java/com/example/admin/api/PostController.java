package com.example.admin.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import com.example.core.model.Post;
import com.example.core.service.PostService;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PostController {
  
  private PostService postService;

  public PostController(PostService service) {
    this.postService = service;
  }

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
    postService.addPost(jobj);
  }

  @PutMapping(value = "/api/posts")
  public @ResponseBody void updatePost(@RequestBody JSONObject jobj) {
    postService.updatePost(jobj);
  }

  @DeleteMapping(value = "/api/posts/{id}")
  public @ResponseBody void deletePost(@PathVariable("id") Long id) {
    postService.deletePost(id);
  }

  @PostMapping(value = "/api/posts/image")
  public @ResponseBody void uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
    String originalfileName = file.getOriginalFilename();
		File dest = new File("C:/Users/jinwoo/_images/" + originalfileName);
    file.transferTo(dest);
  }

  @GetMapping(value = "/api/posts/images/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
  public @ResponseBody byte[] getImage(@PathVariable("name") String name) throws IOException {
    String resourceFile ="C:/Users/jinwoo/_images/" + name;
    InputStream resourceStream = new BufferedInputStream( new FileInputStream(resourceFile));

    return IOUtils.toByteArray(resourceStream);
  }


}
