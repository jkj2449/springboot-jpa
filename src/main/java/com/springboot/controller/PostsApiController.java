package com.springboot.controller;

import com.springboot.dto.PostsListResponseDto;
import com.springboot.dto.PostsResponseDto;
import com.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @GetMapping("/posts")
    public List<PostsListResponseDto> findAllDesc() {
        return postsService.findAllDesc();
    }
}
