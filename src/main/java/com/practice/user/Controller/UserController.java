package com.practice.user.Controller;

import com.practice.user.Dtos.*;
import com.practice.user.Exceptions.UserDoesNotExistException;
import com.practice.user.Models.Token;
import com.practice.user.Models.User;
import com.practice.user.Service.UserService;
import com.practice.user.Service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponseDto login (@RequestBody LoginRequestDto requestDto) throws UserDoesNotExistException {

        Token token = userService.login(requestDto.getEmail(), requestDto.getPassword());

        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setTokenValue(token.getValue());

//        ResponseEntity<UserDto> response = authService.login( request.getEmail(),request.getPassword());
        return responseDto;
    }



    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto requestDto) {
        User user =userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());

        return UserDto.from(user);
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto requestDto){
        return null;
    }


    @GetMapping("/validate/{token}")
    public ResponseEntity<UserDto> validateToken(@PathVariable("token") String tokenValue){

        User user = userService.validateToken(tokenValue);
        ResponseEntity<UserDto> responseEntity = null;
        if(user == null){
            responseEntity = new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        else{
            responseEntity = new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
        }

        return responseEntity;

//        Optional<UserDto> optionalUserDto = authService.validate(request.getToken(), request.getUserId());
//
//        if(optionalUserDto.isEmpty()){
//            ValidateTokenResponseDto response = new ValidateTokenResponseDto();
//            response.setSessionStatus(SessionStatus.INVALID);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }
//        ValidateTokenResponseDto response = new ValidateTokenResponseDto();
//        response.setSessionStatus(SessionStatus.ACTIVE);
//        response.setUserDto(optionalUserDto.get());
    }
}
