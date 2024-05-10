package com.homepage.likelion.posts.service;

import com.homepage.likelion.domain.Post;
import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.repository.PostRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req) {
        // 방법 1: PostCreateDto.Req의 toEntity() method 활용
        Post post = req.toEntity();
        // 방법 2: Post Entity 자체 Builder
//        Post post = Post.builder()
//                .title(req.getTitle())
//                .content(req.getContent())
//                .password(req.getPassword())
//                .postedUserName(req.getPostedUserName())
//                .build();
        // 저장
        Post savedPost = postRepository.save(post);
        // data 생성
        PostCreateDto.CreatePost createdPost = new PostCreateDto.CreatePost(savedPost.getId(), savedPost.getUpdatedAt().atStartOfDay());
        // responseBody 생성
        CustomApiResponse<PostCreateDto.CreatePost> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), createdPost, "게시글이 작성되었습니다.");
        // ResponseEntity 리턴
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);



    }
}
