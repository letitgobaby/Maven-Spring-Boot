package com.example.web.service;


import com.example.domain.entity.Post;
import com.example.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BlogService {

    final PostRepository postRepository;

    public void addPost(Post post) {
        postRepository.save(post);
    }


    // 등등
}
