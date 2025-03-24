package com.practice.user.Dtos;

import com.practice.user.Models.SessionStatus;
import lombok.Getter;
import lombok.Setter;



public class ValidateTokenResponseDto {
    private UserDto userDto;
    private SessionStatus sessionStatus;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }
}
