package com.practice.user.Controller;

import com.practice.user.Dtos.LoginDtos;
import com.practice.user.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDtos loginDto){
        String result = userService.login(loginDto.getEmail(), loginDto.getPassword());
        return result;
    }

    @PostMapping("/validate")
    public String validate(@RequestBody LoginDtos loginDto){
        String result= userService.validate(loginDto.getEmail(), loginDto.getPassword());
        return  result;
    }
}
