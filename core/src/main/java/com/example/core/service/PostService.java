package com.example.core.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.core.model.Post;
import com.example.core.repository.PostRepo;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class PostService {
  
  @Autowired
  private PostRepo postRepo;

  public List<Post> getAll() {
    return postRepo.findAll();
  }

  public List<Post> getPostList(Pageable pageable) {
    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
    pageable = PageRequest.of(page, pageable.getPageSize());
    return postRepo.findAll(pageable).getContent();
  }

  public Post getOne(Long id) {
    return postRepo.findById(id).get();
  }

  public void addPost(Post post) {
    postRepo.save(post);
  }

  public void updatePost(Post post) {
    
    post.setTitle("title");
    post.setSubtitle("subtitle");
    post.setHref("href");
    post.setContent("content");
    post.setBanner("banner");

    LocalDateTime currentDateTime = LocalDateTime.now();
    post.setUpdated(currentDateTime);

    postRepo.save(post);
  } 

  public void deletePost(Long id) {
    Post post = postRepo.findById(id).get();
    System.out.println( post );
    postRepo.delete(post);
  }


}
