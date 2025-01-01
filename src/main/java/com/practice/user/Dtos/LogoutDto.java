package com.practice.user.Dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutDto {

    private int userId;
    private int token;
}
