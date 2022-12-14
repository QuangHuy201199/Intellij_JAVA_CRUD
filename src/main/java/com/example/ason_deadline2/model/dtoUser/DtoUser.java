package com.example.ason_deadline2.model.dtoUser;

import lombok.*;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoUser {
    private Integer id;
    private String nameUser;
    private LocalDate dateCreate;
    private Boolean status;
    private String passWord;
    private String dateOfBirth;

}

