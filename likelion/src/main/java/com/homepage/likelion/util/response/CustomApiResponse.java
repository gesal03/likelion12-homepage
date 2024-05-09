package com.homepage.likelion.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomApiResponse<T> {
    // status, data, message
    int status;
    T data;
    String message;

    public static <T> CustomApiResponse<T> createSuccess(int status, T data, String message) {
        return new CustomApiResponse<>(status, data, message);
    }

    public static <T> CustomApiResponse<T> createFailWithout(int status, T data, String message) {
        return new CustomApiResponse<>(status, data, message);
    }
 }
