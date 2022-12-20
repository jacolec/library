package com.kodilla.library.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    public List<Borrow> getBorrows() {
        return (List<Borrow>) borrowRepository.findAll();
    }

    public Borrow getBorrow(Long borrowId) {
        return borrowRepository.findById(borrowId).get();
    }

    public void deleteBorrow(Long borrowId) {
        borrowRepository.deleteById(borrowId);
    }

    public Borrow saveBorrow(final Borrow borrow) {
        return borrowRepository.save(borrow);
    }


}
