package com.kodilla.library.reader;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "READERS")
public class Reader {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "READER_ID")
    private int id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "SIGN_UP_DATE")
    private LocalDate signUpDate;

    public Reader(String firstname, String lastname, LocalDate signUpDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.signUpDate = signUpDate;
    }
}
