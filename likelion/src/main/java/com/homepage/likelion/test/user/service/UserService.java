package com.homepage.likelion.test.user.service;

import com.homepage.likelion.test.domain.User;
import com.homepage.likelion.test.user.dto.UserSignUpDto;
import com.homepage.likelion.test.user.repository.UserRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<CustomApiResponse<?>> signUp(UserSignUpDto dto) {
        // 1. 같은 userId의 회원이 있는지
        Optional<User> findUser = userRepository.findByUserId(dto.getUserId());
        // -> 이미 유저가 있다면 회원 가입 불가
        if (findUser.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), "중복된 아이디가 존재합니다."));
        }
        // 2. 동일한 userId가 없다 -> 회원 가입 진행
        else {
            User user = User.builder()
                    .email(dto.getEmail())
                    .userId(dto.getUserId())
                    .password(dto.getPassword())
                    .build();
            userRepository.save(user);

        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원가입이 완료되었습니다."));
    }
}
