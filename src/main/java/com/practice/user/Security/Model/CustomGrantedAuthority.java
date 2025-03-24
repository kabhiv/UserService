//package com.practice.user.Security.Model;
//
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.practice.user.Models.Role;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//
//@NoArgsConstructor
//@JsonDeserialize
//public class CustomGrantedAuthority implements GrantedAuthority {
//
//    private String authority;
////    private Role role;
//    public CustomGrantedAuthority(Role role) {
//        this.authority = role.getValue();
//    }
//    @Override
//    public String getAuthority() {
//        return this.authority;
//    }
//}
