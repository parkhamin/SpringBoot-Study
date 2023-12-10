package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@RestController // -> 응답값이 json으로 내려가겠다라는 선언
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {
    @GetMapping("")
    public UserRequest user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(23);
        user.setEmail("hong@gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity // 특별한 상태값을 내려주고 싶을 때 사용
                .status(HttpStatus.BAD_REQUEST)
                .header("x-custom", "hi")
                .body(user);

        return user;
    }
}
