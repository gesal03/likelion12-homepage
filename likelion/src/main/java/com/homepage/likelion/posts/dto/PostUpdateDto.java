package com.homepage.likelion.posts.dto;


import com.homepage.likelion.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

public class PostUpdateDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Req {
        private String postedUserName;
        private String password;
        private String title;
        private String content;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdatePost {
        private LocalDateTime updatedAt;
    }

}
