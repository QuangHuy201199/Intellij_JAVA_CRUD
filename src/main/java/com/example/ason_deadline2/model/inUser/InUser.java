package com.example.ason_deadline2.model.inUser;

import lombok.*;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class InUser {
    private String nameUser;
    private Boolean status;
    private String passWord;
    private String dateOfBirth;


    public InUser( String nameUser, Boolean status, String passWord) {
        this.nameUser = nameUser;
        this.status = status;
        this.passWord = passWord;
    }

    public InUser(Boolean status) {
        this.status = status;
    }

    public InUser(String nameUser, String dateOfBirth) {
        this.nameUser = nameUser;
        this.dateOfBirth = dateOfBirth;
    }
}
