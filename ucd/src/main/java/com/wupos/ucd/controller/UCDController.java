package com.wupos.ucd.controller;

import com.wupos.ucd.entity.User;
import com.wupos.ucd.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UCDController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String helloWorld() {
       return "Hello, World!";
    }

    @PutMapping("/addOrUpdateUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            long pcp = userService.addOrUpdateUser(user);
            System.out.println(pcp);
            if (pcp == 0) {
                return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomResponse.UserResponse(pcp, "Successfully created"),
                    HttpStatus.CREATED);
            }
            
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>("Failure: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
