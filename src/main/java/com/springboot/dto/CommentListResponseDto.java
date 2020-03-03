package com.springboot.dto;

import com.springboot.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class CommentListResponseDto {
    private Long id;
    private String comment;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public CommentListResponseDto(Comment entity) {
        this.id = entity.getId();
        this.comment = entity.getComment();
        this.author = entity.getAuthor();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
