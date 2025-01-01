package com.practice.user.Dtos;

import com.practice.user.Models.Role;
import com.practice.user.Models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;



public class UserDto {
    private String email;
    private Set<Role> role = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRoles());

        return userDto;
    }
}
