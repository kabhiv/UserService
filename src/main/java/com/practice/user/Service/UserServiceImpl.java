package com.practice.user.Service;

import com.practice.user.Exceptions.UserDoesNotExistException;
import com.practice.user.Models.Token;
import com.practice.user.Models.User;
import com.practice.user.Repository.TokenRepository;
import com.practice.user.Repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;


    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder ,
                           UserRepository userRepository,
                           TokenRepository tokenRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }



    @Override
    public Token login(String email, String password) throws UserDoesNotExistException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()) {
            throw new UserDoesNotExistException("User Doesn't Exists");
        }
        User user = optionalUser.get();
        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
//            password mismatch
            return null;
        }
//        login successfull -> generate token
        Token token = new Token();
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        token.setUser(user);

        LocalDate localDate = LocalDate.now().plusDays(30);
        Date expiryDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        token.setExpiringAt(expiryDate);

        return tokenRepository.save(token);
    }

    @Override
    public User signUp(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    @Override
    public User validateToken(String tokenValue) {
//        token value should be present in db , deleted should be false
//        and expirytime > current time

        Optional<Token> Optionaltoken = tokenRepository.findByValueAndDeletedAndExpiringAtGreaterThan(tokenValue,
                false,new Date());

        if(Optionaltoken.isEmpty()) {
            return null;
        }
        return Optionaltoken.get().getUser();
    }

    @Override
    public void logout(String token) {


    }
}
