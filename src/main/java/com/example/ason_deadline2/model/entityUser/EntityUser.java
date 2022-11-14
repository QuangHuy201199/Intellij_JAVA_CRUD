package com.example.ason_deadline2.model.entityUser;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityUser {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameUser;
    private LocalDate dateCreate;
    private Boolean status;
    private String passWord;
    private String dateOfBirth;
}
