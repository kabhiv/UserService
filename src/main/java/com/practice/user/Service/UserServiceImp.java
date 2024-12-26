package com.practice.user.Service;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Override
    public String login(String username, String password) {
        return "returning string";
    }

    @Override
    public String validate(String username, String password) {
        return "returning validated string";
    }
}
