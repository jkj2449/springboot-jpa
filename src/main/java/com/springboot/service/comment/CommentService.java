package com.springboot.service.comment;

import com.springboot.domain.comment.Comment;
import com.springboot.domain.comment.CommentRepository;
import com.springboot.dto.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponseDto findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return CommentResponseDto.builder()
                .entity(comment)
                .build();
    }
}
