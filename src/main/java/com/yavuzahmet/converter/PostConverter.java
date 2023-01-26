package com.yavuzahmet.converter;

import com.yavuzahmet.model.Post;
import com.yavuzahmet.dto.PostDto;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public Post toEntity(PostDto dto){
        return new Post(dto.id(), dto.userId(), dto.title(), dto.body());
    }
    public PostDto toDto(Post post){
        return new PostDto(post.getId(), post.getUserId(), post.getTitle(), post.getBody());
    }
}