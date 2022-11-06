package com.example.ason_deadline2.model.inUser;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class InUser {
    private String nameUser;
    private Boolean status;
    private String passWord;

    public InUser( String nameUser, Boolean status, String passWord) {
        this.nameUser = nameUser;
        this.status = status;
        this.passWord = passWord;
    }

    public InUser( String nameUser) {
        this.nameUser = nameUser;
    }
}
