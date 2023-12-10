package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    // http://localhost:8080/api/echo/hello
    @GetMapping(path = "/hello") // 특정 주소에 api/hello라는 요청이 들어오게 되면 이 메서드로 맵핑이 된 형태
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";

        return html;
    }

    // http://localhost:8080/api/echo/hello/age/23/is-man/false
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        // String 타입의 변수 외에 다른 타입
        System.out.println("echo message: " + msg);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);

        // 대문자로 변환해서 RETURN => toUpperCase
        return msg.toUpperCase(); // hello 출력
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
           BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    // TODO: 2023-12-10 Parameter 2개를 int 형태로 받아서 두 수의 덧셈, 곱셈
    // TODO String 타입, boolean 타입도 받아보기

    @DeleteMapping(path = {"/user/{userName}/delete",
                           "/user/{userName}/del"})
    public void delete(
            @PathVariable String userName
    ){
        System.out.println(userName);
    }


}
