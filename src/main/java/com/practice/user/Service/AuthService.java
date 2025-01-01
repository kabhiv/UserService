package com.practice.user.Service;

import com.practice.user.Dtos.UserDto;
import com.practice.user.Exceptions.UserAlreadyExistsException;
import com.practice.user.Exceptions.UserDoesNotExistException;
import org.springframework.http.ResponseEntity;

public interface AuthService {


    ResponseEntity<UserDto> login(String email, String password) throws UserDoesNotExistException;
//    void logout(LogoutDto logoutDto);
//    Optional<UserDto> validate(String username, String password);
    UserDto signup(String email, String password) throws UserAlreadyExistsException;
}
