package com.practice.user.Dtos;

import com.practice.user.Models.Token;

public class LoginResponseDto {
    private String tokenValue;

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}
