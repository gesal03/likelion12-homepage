package com.homepage.likelion.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simpleText")
public class SimpleTestController {
    /*
    GET http:/localhost:8080/api/simpleText/succes
    • HttpStatus : 200(OK)
    • ResponseBody(plaintext):안녕
     */
    @GetMapping("/succes")
    public String simpleTextSuccess() {
        return "안녕";
    }
    /*
    GET http:/localhost:8080/api/simpleText/succes
    • HttpStatus : 200(OK)
    • ResponseBody(plaintext): 실패
     */
    @GetMapping("/fail")
    public String simpleTextFail() {
        return "실패";
    }
}