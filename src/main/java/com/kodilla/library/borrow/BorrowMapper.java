package com.kodilla.library.borrow;

import org.springframework.stereotype.Service;

@Service
public class BorrowMapper {

    public Borrow mapToBorrow(BorrowDto borrowDto) {
        return new Borrow(borrowDto.getBorrowDate(),
                borrowDto.getReturnDate());
    }

    public BorrowDto mapToBorrowDto(Borrow borrow) {
        return new BorrowDto(borrow.getId(),
                borrow.getBorrowDate(),
                borrow.getReturnDate());
    }
}
