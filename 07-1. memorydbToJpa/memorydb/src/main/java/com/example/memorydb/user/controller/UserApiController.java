package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Http 리퀘스트가 들어오는 내용을 처리하고 리스폰스를 처리하는 영역
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    // delete
    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        //userService.delete(id);
    }

    // find by id
    @GetMapping("id/{id}")
    public UserEntity findOne(
            @PathVariable Long id
    ){
       var response = userService.findById(id);
       return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(
            @RequestParam int score // 쿼리 파라미터 : 전체 데이터 중에 특정한 데이터를 찾아올 때
    ){
        return userService.filterScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> filterScore(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.filterScore(min, max);
    }
}
