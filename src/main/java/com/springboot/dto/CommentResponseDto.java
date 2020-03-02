package com.springboot.dto;

import com.springboot.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentResponseDto {
    private Long id;

    private String comment;

    private String author;

    @Builder
    public CommentResponseDto(Comment entity) {
        this.id = entity.getId();
        this.comment = entity.getComment();
        this.author = entity.getAuthor();
    }
}
