//package com.practice.user.Security.Services;
//
//import com.practice.user.Models.User;
//import com.practice.user.Repository.UserRepository;
//import com.practice.user.Security.Model.CustomUserDetails;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//    private UserRepository userRepository;
//
//    public CustomUserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(username);
//
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException(username);
//        }
//
//        return new CustomUserDetails(user.get());
//
//    }
//}
