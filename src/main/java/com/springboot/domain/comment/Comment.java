package com.springboot.domain.comment;

import com.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String comment;

    private String author;

    @Builder
    public Comment(String comment, String author) {
        this.comment = comment;
        this.author = author;
    }
}
