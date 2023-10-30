package com.javamigos.userservice.controller;

import com.javamigos.userservice.dto.UserDto;
import com.javamigos.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    List<UserDto> dtos =new LinkedList<>();

    @PostMapping("/saveUser")
    ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){

        UserDto savedUserInDB= userService.saveUserInDB(userDto);
        return new ResponseEntity<>(savedUserInDB, HttpStatus.CREATED);
    }

    @GetMapping("fetchUserById/{userId}")
    ResponseEntity<UserDto> fetchUserById(@PathVariable Integer userId){
        UserDto fetchedUser= userService.fetchUserById(userId);
        return new ResponseEntity<>(fetchedUser,HttpStatus.OK);
    }
}
