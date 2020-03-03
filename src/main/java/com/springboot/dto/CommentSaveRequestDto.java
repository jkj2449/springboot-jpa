package com.springboot.dto;

import com.springboot.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    private Long postsId;
    private String comment;
    private String author;

    @Builder
    public CommentSaveRequestDto(String comment, String author) {
        this.comment = comment;
        this.author = author;
    }

    public Comment toEntity() {
        return Comment.builder()
                .comment(comment)
                .author(author)
                .build();
    }
}
