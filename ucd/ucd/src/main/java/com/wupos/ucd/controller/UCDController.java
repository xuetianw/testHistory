package com.wupos.ucd.controller;

import com.wupos.ucd.entity.User;
import com.wupos.ucd.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UCDController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String helloWorld() {
       return "Hello, World!";
    }

    @PostMapping("/addUser")
    public ResponseEntity<CustomResponse.UserResponse> addUser(@RequestBody User user) {
        try {
            String response = userService.addUser(user);
            return new ResponseEntity<>(new CustomResponse.UserResponse(response, "Success"),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>(new CustomResponse.UserResponse("Failure"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
