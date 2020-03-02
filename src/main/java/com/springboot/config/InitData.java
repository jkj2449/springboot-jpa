package com.springboot.config;

import com.springboot.domain.comment.CommentRepository;
import com.springboot.domain.posts.Posts;
import com.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class InitData {
    private final PostsRepository postsRepository;
    private final CommentRepository commentRepository;

    @PostConstruct
    public void initData() {
        List<Posts> postsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            postsList.add(Posts.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .author("author" + i)
                    .build());
        }

        for (Posts posts : postsList) {
            postsRepository.save(posts);
        }
    }
}
