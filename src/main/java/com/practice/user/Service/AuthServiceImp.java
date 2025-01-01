package com.practice.user.Service;
import com.practice.user.Dtos.UserDto;
import com.practice.user.Exceptions.UserAlreadyExistsException;
import com.practice.user.Exceptions.UserDoesNotExistException;
import com.practice.user.Models.Session;
import com.practice.user.Models.SessionStatus;
import com.practice.user.Models.User;
import com.practice.user.Repository.SessionRepository;
import com.practice.user.Repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthServiceImp implements AuthService {

    private final SessionRepository sessionRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;

    public AuthServiceImp(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.sessionRepository = sessionRepository;
    }

    @Override
    public UserDto signup(String email, String password) throws UserAlreadyExistsException {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(!userOptional.isEmpty()) {
            throw new UserAlreadyExistsException("User with email"+email+"already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        User savedUser = userRepository.save(user);

        return UserDto.from(savedUser);
    }

    @Override
    public ResponseEntity<UserDto> login(String email, String password) throws UserDoesNotExistException {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            throw new UserDoesNotExistException("User with email"+email+"Does not exist");
        }
        User user = userOptional.get();

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String token = randomStringUtils.randomAscii(20);
        MultiValueMapAdapter<String,String> header = new MultiValueMapAdapter<>(new HashMap<>());
        header.add("AUTH_TOKEN", token);

        Session session = new Session();
        session.setSessionStatus(SessionStatus.ACTIVE);
        session.setToken(token);
        session.setUser(user);
        sessionRepository.save(session);


        UserDto userDto = UserDto.from(user);
        ResponseEntity<UserDto> response = new ResponseEntity<>(userDto,header, HttpStatus.OK);

        return response;



    }

//    @Override
//    public void logout(LogoutDto logoutDto) {
//
//    }

//    @Override
//    public Optional<UserDto> validate(String username, String password) {
//
//        return Optional.of(UserDto);
//    }


}
