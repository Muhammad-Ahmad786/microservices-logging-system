package com.example.UserService.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.UserService.Service.UserServiceLogic;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceLogic userService;

    public UserController(UserServiceLogic userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(){
        return userService.createUser();
    }

    

}
