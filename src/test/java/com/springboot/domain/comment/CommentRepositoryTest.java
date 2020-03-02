package com.springboot.domain.comment;

import com.springboot.config.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import(JpaConfig.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void 댓글_저장_불러오기() {
        String expectedContent = "content";

        commentRepository.save(Comment.builder()
                .comment(expectedContent)
                .author("test@test.com")
                .build());

        List<Comment> postsList = commentRepository.findAll();
        Comment comment = postsList.get(0);
        assertThat(comment.getComment()).isEqualTo(expectedContent);
    }
}