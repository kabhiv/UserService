package com.practice.user.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role extends  BaseModel{
    private String name;
}
