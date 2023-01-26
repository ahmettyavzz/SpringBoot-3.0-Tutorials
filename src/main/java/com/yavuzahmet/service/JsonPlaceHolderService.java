package com.yavuzahmet.service;

import com.yavuzahmet.model.Post;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

/**
 * HTTP INTERFACES
 */
@HttpExchange("/posts")
public interface JsonPlaceHolderService {
    @GetExchange
    List<Post> loadPosts();
}