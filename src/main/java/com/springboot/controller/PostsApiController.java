package com.springboot.controller;

import com.springboot.dto.PostsListResponseDto;
import com.springboot.dto.PostsResponseDto;
import com.springboot.dto.PostsSaveRequestDto;
import com.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @GetMapping("/posts-all")
    public List<PostsListResponseDto> findAll(final Pageable pageable) {
        return postsService.findAll(pageable);
    }

    @GetMapping("/posts-title/{title}")
    public List<PostsListResponseDto> findAllByTitle(@PathVariable String title, final Pageable pageable) {
        return postsService.findAllByTitle(title, pageable);
    }

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
