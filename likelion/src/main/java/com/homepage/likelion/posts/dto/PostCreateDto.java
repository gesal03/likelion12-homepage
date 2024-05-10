package com.homepage.likelion.posts.dto;

import com.homepage.likelion.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class PostCreateDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Req {
        @NotBlank(message = "작성자 이름은 비어 있을 수 없습니다.")
        private String postedUserName;
        @NotBlank(message = "비밀번호는 비어 있을 수 없습니다.")
        private String password;
        @NotBlank(message = "게시글 제목은 비어 있을 수 없습니다.")
        private String title;
        @NotBlank(message = "게시글 내용은 비어 있을 수 없습니다.")
        private String content;

        public Post toEntity() {
            return Post.builder()
                    .postedUserName(postedUserName)
                    .password(password)
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreatePost {
        private Long postId;
        private LocalDateTime updatedAt;
    }
}
