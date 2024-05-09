package com.homepage.likelion.test;

import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserTestController {
    //POST http://localhost:8080/api/user/signup
    @PostMapping("/signup")
    public ResponseEntity<CustomApiResponse<?>> signUp(@Valid @RequestBody SignUpDto signUpDto) {
        // 1. 회원가입 로직
        System.out.println("signUpDto.getUserId() = " + signUpDto.getUserId());
        // 2. 응답
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원 가입에 성공하였습니다.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);

    }
}
