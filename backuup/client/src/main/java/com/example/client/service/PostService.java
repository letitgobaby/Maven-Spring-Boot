package com.example.client.service;

import com.example.core.model.Post;
import com.example.core.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);
    }

    public void addPost(Post post) {
        postRepo.save(post);
    }
}
