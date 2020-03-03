package com.springboot.service.comment;

import com.springboot.domain.comment.Comment;
import com.springboot.domain.comment.CommentRepository;
import com.springboot.domain.posts.Posts;
import com.springboot.domain.posts.PostsRepository;
import com.springboot.dto.CommentResponseDto;
import com.springboot.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostsRepository postsRepository;

    public CommentResponseDto findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return CommentResponseDto.builder()
                .entity(comment)
                .build();
    }

    public Long save(CommentSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(requestDto.getPostsId()).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + requestDto.getPostsId()));
        Comment comment = requestDto.toEntity();
        comment.setPosts(posts);

        return commentRepository.save(comment).getId();
    }
}
