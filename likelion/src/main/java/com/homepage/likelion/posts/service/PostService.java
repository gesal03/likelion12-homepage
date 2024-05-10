package com.homepage.likelion.posts.service;

import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req);
}
