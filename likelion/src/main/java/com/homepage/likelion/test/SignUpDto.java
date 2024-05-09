package com.homepage.likelion.test;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    @NotEmpty(message = "userId는 필수 값입니다.")
    private String userId;
    @Email(message = "email 형식을 맞춰주세요.")
    private String email;
    private String password;
}
