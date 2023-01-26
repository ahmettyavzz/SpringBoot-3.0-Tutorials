package com.yavuzahmet.service;

import com.yavuzahmet.converter.PostConverter;
import com.yavuzahmet.dto.PostDto;
import com.yavuzahmet.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository repository;
    private final PostConverter converter;

    public PostService(PostRepository repository, PostConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<PostDto> getAllPosts() {
        return repository.findAll().stream().map(converter::toDto).collect(Collectors.toList());
    }
}