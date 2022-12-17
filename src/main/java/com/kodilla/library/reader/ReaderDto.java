package com.kodilla.library.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ReaderDto {

    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate signUpDate;
}
