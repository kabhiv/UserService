package com.practice.user.Service;

import com.practice.user.Exceptions.UserDoesNotExistException;
import com.practice.user.Models.Token;
import com.practice.user.Models.User;

public interface UserService {

    Token login(String username, String password) throws UserDoesNotExistException;

    User signUp(String name ,String email , String password);

    User validateToken(String token);

    void logout(String token);
}
