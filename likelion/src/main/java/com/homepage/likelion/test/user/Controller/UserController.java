package com.homepage.likelion.test.user.Controller;

import com.homepage.likelion.test.user.dto.UserSignUpDto;
import com.homepage.likelion.test.user.service.UserService;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/signUp")
    public ResponseEntity<CustomApiResponse<?>> signUp(@RequestBody UserSignUpDto dto) {
        return userService.signUp(dto);
    }
}
