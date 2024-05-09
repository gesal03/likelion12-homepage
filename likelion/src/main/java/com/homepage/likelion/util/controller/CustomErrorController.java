package com.homepage.likelion.util.controller;

import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<CustomApiResponse<?>> errorHandler(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            // Bad Request (400)
            if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                CustomApiResponse<Object> failWithout = CustomApiResponse.createFailWithoutData(statusCode, "잘못된 요청입니다.");
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(failWithout);
            }
            // Forbidden (403)
            else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                CustomApiResponse<Object> failWithout = CustomApiResponse.createFailWithoutData(statusCode, "접근이 금지되었습니다.");
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body(failWithout);
            }
            // Not Found (404)
            else if (statusCode == HttpStatus.NOT_FOUND.value()) {
                CustomApiResponse<Object> failWithout = CustomApiResponse.createFailWithoutData(HttpStatus.NOT_FOUND.value(), "요청 경로를 찾을 수 없습니다");
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(failWithout);
            }
            // Method not Allowed (405)
            else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                CustomApiResponse<Object> failWithout = CustomApiResponse.createFailWithoutData(HttpStatus.METHOD_NOT_ALLOWED.value(), "허용되지 않는 메소드입니다.");
                return ResponseEntity
                        .status(HttpStatus.METHOD_NOT_ALLOWED)
                        .body(failWithout);
            }
            // Internal Server Error (500)
            else {
                CustomApiResponse<Object> failWithout = CustomApiResponse.createFailWithoutData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "내부 서버 오류가 발생했습니다");
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(failWithout);
            }
        }
        CustomApiResponse<Object> failWithout = CustomApiResponse.createFailWithoutData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "내부 서버 오류가 발생했습니다");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(failWithout);
    }
}
