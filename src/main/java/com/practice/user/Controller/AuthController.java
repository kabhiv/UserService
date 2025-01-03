package com.practice.user.Controller;

import com.practice.user.Dtos.*;
import com.practice.user.Exceptions.UserAlreadyExistsException;
import com.practice.user.Exceptions.UserDoesNotExistException;
import com.practice.user.Models.SessionStatus;
import com.practice.user.Service.AuthService;
import com.practice.user.Service.AuthServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthServiceImp authServiceImp) {
        this.authService = authServiceImp;
    }

//    public AuthController(AuthServiceImp authServiceImp) {
//        this.authService = authService;
//    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login (@RequestBody LoginDtos request) throws UserDoesNotExistException {
        ResponseEntity<UserDto> response = authService.login( request.getEmail(),request.getPassword());

        return response;
    }
//    @PostMapping("/logout")
//    public ResponseEntity<void> logout(@RequestBody LogoutDto request){
//        return authService.logout( request.getToken(),request.getUserId(),);
//    }

    @PostMapping("/validate")
    public ResponseEntity<SessionStatus> validate(@RequestBody ValidateTokenRequestDto request){
       SessionStatus sessionStatus = authService.validate(request.getToken(), request.getUserId());
       ResponseEntity response = new ResponseEntity<>(sessionStatus, HttpStatus.OK);
        return response;
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupRequestDto request) throws UserAlreadyExistsException {
        UserDto userdto= authService.signup(request.getEmail(),request.getPassword());
        return new ResponseEntity<>(userdto, HttpStatus.OK);
    }
}
