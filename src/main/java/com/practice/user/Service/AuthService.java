package com.practice.user.Service;

import com.practice.user.Dtos.UserDto;
import com.practice.user.Exceptions.UserAlreadyExistsException;
import com.practice.user.Exceptions.UserDoesNotExistException;
import com.practice.user.Models.SessionStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AuthService {


    ResponseEntity<UserDto> login(String email, String password) throws UserDoesNotExistException;
//    void logout(LogoutDto logoutDto);
    SessionStatus validate(String token, Long userId);
    UserDto signup(String email, String password) throws UserAlreadyExistsException;

//    Optional<UserDto> validate(String username, String password);
}
