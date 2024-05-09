package com.homepage.likelion.test;

import com.homepage.likelion.util.response.CustomApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customResponse")
public class CustomTestController {
    //요구 사항 1
    //POST http://localhost:8080/api/customResponse/simple
    @PostMapping("/simple")
    public ResponseEntity<CustomApiResponse<?>> success() {
        // 1. Response Body 구성
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(200, null, "회원 가입에 성공하였습니다");
        // 2. Response Body 넣기
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    // 요구 사항 2
    //GET http://localhost:8080/api/customResponse/jsonData
    @GetMapping("/jsonData")
    public ResponseEntity<CustomApiResponse<?>> search() {
        // 1. DTO 불러오기
        // 1-1. DTO 생성(new 사용)
//        SimpleDto dto = new SimpleDto("example", "example@naver.com");
        // 1-2. DTO 생성(Builder)
        SimpleDto dto = SimpleDto.builder()
                .userId("example")
                .email("example@naver.com")
                .build();

        // 2. Response Body 구성
        CustomApiResponse<SimpleDto> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), dto, "회원 조회에 성공하셨습니다.");

        // 3. Response Body 넣기
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
