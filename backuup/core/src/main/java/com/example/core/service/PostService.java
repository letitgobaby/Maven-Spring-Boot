package com.example.core.service;

import java.util.List;
import java.util.Optional;

import com.example.core.model.Post;
import com.example.core.repository.PostRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {
  
  @Autowired
  private PostRepo postRepo;

  public List<Post> findAll() {
    return postRepo.findAll();
  }

  public Post findOne(Long id) {
    return postRepo.findById(id).get();
  }

}
