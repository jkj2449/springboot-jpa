package com.springboot.dto;

import com.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<CommentListResponseDto> comments;

    @Builder
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.comments = entity.getComments()
                .stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());
    }
}
