package com.practice.user.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@Entity
public class Session extends BaseModel{
    private String token;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
