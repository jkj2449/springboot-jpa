package com.springboot.domain.comment;

import com.springboot.domain.BaseTimeEntity;
import com.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String comment;

    private String author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @Builder
    public Comment(String comment, String author) {
        this.comment = comment;
        this.author = author;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
        posts.addComment(this);
    }
}
