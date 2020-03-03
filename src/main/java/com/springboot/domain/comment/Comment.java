package com.springboot.domain.comment;

import com.springboot.domain.BaseTimeEntity;
import com.springboot.domain.posts.Posts;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;

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

    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_no")
    private Posts posts;

    @Builder
    public Comment(String comment, String author, Posts posts) {
        this.comment = comment;
        this.author = author;
        this.posts = posts;
        if(!posts.getComments().contains(this)) {
            posts.getComments().add(this);
        }
    }
}
