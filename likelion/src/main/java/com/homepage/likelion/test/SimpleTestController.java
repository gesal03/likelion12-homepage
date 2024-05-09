package com.homepage.likelion.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simpleText")
public class SimpleTestController {
    /*
    GET http:/localhost:8080/api/simpleText/success
    • HttpStatus : 200(OK)
    • ResponseBody(plaintext):안녕
     */
    @GetMapping("/success")
    public String simpleTextSuccess() {
        return "안녕";
    }
    /*
    GET http:/localhost:8080/api/simpleText/fail
    • HttpStatus : 404
    • ResponseBody(plaintext): 실패
     */
    @GetMapping("/fail")
    public ResponseEntity<String> simpleTextFail() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("실패");
    }
}
