package com.springboot.domain.posts;

import com.springboot.domain.BaseTimeEntity;
import com.springboot.domain.comment.Comment;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    private String author;

    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void addComment(Comment comment) {
        if(!comments.contains(comment)) {
            comments.add(comment);
        }
    }
}
