package com.yavuzahmet.controller;

import com.yavuzahmet.dto.PostDto;
import com.yavuzahmet.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostDto> loadPosts() {
        return service.getAllPosts();
    }
}