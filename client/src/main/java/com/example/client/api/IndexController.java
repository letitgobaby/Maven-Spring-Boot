package com.example.client.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


import com.example.core.model.Post;
import com.example.core.service.PostService;

@Controller
@RequestMapping("/api/v1")
public class IndexController {

  @Autowired
  private PostService postService;
  
  @GetMapping(value = "/postPaging")
	public @ResponseBody JSONObject postPaging(@PageableDefault Pageable pageable) {
    JSONObject result = new JSONObject();

    List<Post> postlist = postService.getPostList(pageable);

    result.put("data", postlist);
    result.put("page", pageable.getPageNumber());
    result.put("size", pageable.getPageSize());
    
    return result;
	}

}
