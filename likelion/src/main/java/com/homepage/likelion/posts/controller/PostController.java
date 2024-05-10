package com.homepage.likelion.posts.controller;

import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.dto.PostUpdateDto;
import com.homepage.likelion.posts.service.PostService;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;
    @PostMapping
    public ResponseEntity<CustomApiResponse<?>> createPost(@Valid @RequestBody PostCreateDto.Req req) {
        return postService.createPost(req);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<CustomApiResponse<?>> updatePost(
            @RequestBody PostUpdateDto.Req req,
            @PathVariable("postId") Long postId) {
        return postService.updatePost(req, postId);
    }

    @GetMapping("/all")
    public ResponseEntity<CustomApiResponse<?>> getAllPost() {
        return postService.getAllPost();
    }
    @GetMapping("/{postId}")
    public ResponseEntity<CustomApiResponse<?>> getOnePost(
            @PathVariable("postId") Long postId) {
        return postService.getOnePost(postId);
    }
}
