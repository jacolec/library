package com.kodilla.library.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BorrowDto {

    private Long id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
