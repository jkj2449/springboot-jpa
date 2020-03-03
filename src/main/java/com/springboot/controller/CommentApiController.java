package com.springboot.controller;

import com.springboot.dto.CommentResponseDto;
import com.springboot.dto.CommentSaveRequestDto;
import com.springboot.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentApiController {
    private final CommentService commentService;

    @GetMapping("/comment/{id}")
    public CommentResponseDto findById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @PostMapping("/comment")
    public Long save(@RequestBody  CommentSaveRequestDto requestDto) {
        return commentService.save(requestDto);
    }
}
