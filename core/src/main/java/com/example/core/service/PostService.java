package com.example.core.service;

import java.util.List;

import com.example.core.model.Post;
import com.example.core.repository.PostRepo;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class PostService {
  
  private final PostRepo postRepo;

  public PostService(PostRepo repo) {
    this.postRepo = repo;
  }

  public List<Post> getAll() {
    return postRepo.findAll();
  }

  public Long getCountAll() {
    return postRepo.count();
  }

  public List<Post> getPostList(Pageable pageable) {
    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
    pageable = PageRequest.of(page, pageable.getPageSize());
    return postRepo.findAll(pageable).getContent();
  }

  public Post getOne(Long id) {
    return postRepo.findById(id).get();
  }

  public void addPost(JSONObject jobj) {
    try {
      Post post = new Post();
      post.setTitle( jobj.get("title").toString() );
      post.setSubtitle( jobj.get("subtitle").toString() );
      post.setContent( jobj.get("content").toString() );
      post.setBanner( jobj.get("banner").toString() );
      // post.setHref( jobj.get("href").toString() );
  
      postRepo.save(post);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void updatePost(JSONObject jobj) {
    try {
      Post post = postRepo.getOne( Long.parseLong(jobj.get("id").toString()) );
      post.setTitle( jobj.get("title").toString() );
      post.setSubtitle( jobj.get("subtitle").toString() );
      post.setContent( jobj.get("content").toString() );
      post.setBanner( jobj.get("banner").toString() );
  
      postRepo.save(post);
    } catch (Exception e) {
      System.out.println(e);
    }
  } 

  public void deletePost(Long id) {
    Post post = postRepo.findById(id).get();
    System.out.println( post );
    postRepo.delete(post);
  }


}
