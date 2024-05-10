package com.homepage.likelion.posts.service;

import com.homepage.likelion.domain.Post;
import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.dto.PostUpdateDto;
import com.homepage.likelion.posts.repository.PostRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<CustomApiResponse<?>> updatePost(PostUpdateDto.Req req, Long postId) {
        // Post 객체 가져오기
        Optional<Post> postOptional = postRepository.findById(postId);
        // post 객체 수정
        Post post = postOptional.get();
        post.changeContent(req.getContent());
        post.changeTitle(req.getTitle());
        post.changeUserName(req.getPostedUserName());
        postRepository.flush(); // 변경 사항 즉시 저장

        // data 생성
        PostUpdateDto.UpdatePost data = new PostUpdateDto.UpdatePost(post.getUpdatedAt().atStartOfDay());
        // ResponseBody 생성
        CustomApiResponse<PostUpdateDto.UpdatePost> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), data, "게시글이 수정되었습니다");
        // ResponseEntity 반환
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }

    @Override
    public ResponseEntity<CustomApiResponse<?>> getAllPost() {
        List<Post> data = postRepository.findAll();
        CustomApiResponse<List<Post>> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), data, "게시글 전체 조회 완료되었습니다");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }
}
