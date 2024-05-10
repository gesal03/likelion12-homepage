package com.homepage.likelion.posts.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class PostListDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PostResponse {
        private Long id;
        private String postedUserName;
        private String title;
        private String Content;
        private LocalDateTime updatedAt;
    }
}
