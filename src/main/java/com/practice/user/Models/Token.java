package com.practice.user.Models;


import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "tokens")
public class Token extends BaseModel{
    private String value;
    private Date expiringAt;
    @ManyToOne
    private User user;
//    @Enumerated(EnumType.ORDINAL)
//    private SessionStatus sessionStatus;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getExpiringAt() {
        return expiringAt;
    }

    public void setExpiringAt(Date expiringAt) {
        this.expiringAt = expiringAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public SessionStatus getSessionStatus() {
//        return sessionStatus;
//    }
//
//    public void setSessionStatus(SessionStatus sessionStatus) {
//        this.sessionStatus = sessionStatus;
//    }
}
