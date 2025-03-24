package com.practice.user.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    @ManyToMany
    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}


