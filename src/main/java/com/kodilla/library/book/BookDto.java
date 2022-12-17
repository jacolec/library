package com.kodilla.library.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private LocalDate releaseDate;
}
