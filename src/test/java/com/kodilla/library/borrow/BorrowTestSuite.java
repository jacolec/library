package com.kodilla.library.borrow;

import com.kodilla.library.book.Book;
import com.kodilla.library.book.BookRepository;
import com.kodilla.library.copy.Copy;
import com.kodilla.library.copy.CopyRepository;
import com.kodilla.library.reader.Reader;
import com.kodilla.library.reader.ReaderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class BorrowTestSuite {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Test
    void testFindBorrowById() {
        //Given
        Reader johnSmith = new Reader("John", "Smith", LocalDate.of(2020, 11, 6));
        Reader mikeRoads = new Reader("Mike", "Roads", LocalDate.of(2010, 4, 14));
        readerRepository.save(johnSmith);
        readerRepository.save(mikeRoads);
        Book dumaKey = new Book("Duma key", "Stephen King", LocalDate.of(2008, 1, 22));
        bookRepository.save(dumaKey);
        Copy dumaKey1 = new Copy("free", dumaKey);
        Copy dumaKey2 = new Copy("free", dumaKey);
        copyRepository.save(dumaKey1);
        copyRepository.save(dumaKey2);
        Borrow borrow1 = new Borrow(LocalDate.now(), LocalDate.now().plusDays(30), johnSmith, dumaKey1);
        Borrow borrow2 = new Borrow(LocalDate.now(), LocalDate.now().plusDays(30), mikeRoads, dumaKey2);
        dumaKey1.setStatus("borrowed");
        dumaKey2.setStatus("borrowed");
        borrowRepository.save(borrow1);
        borrowRepository.save(borrow2);
        //When
        Optional<Borrow> testBorrow1 = borrowRepository.findById(borrow1.getId());
        Optional<Borrow> testBorrow2 = borrowRepository.findById(borrow2.getId());
        //Then
        assertEquals(borrow1.getId(), testBorrow1.get().getId());
        assertEquals(borrow2.getId(), testBorrow2.get().getId());
        //CleanUp
        borrowRepository.deleteAll();
    }

    @Test
    void testDeleteBorrowById() {
        //Given
        Reader johnSmith = new Reader("John", "Smith", LocalDate.of(2020, 11, 6));
        Reader mikeRoads = new Reader("Mike", "Roads", LocalDate.of(2010, 4, 14));
        readerRepository.save(johnSmith);
        readerRepository.save(mikeRoads);
        Book dumaKey = new Book("Duma key", "Stephen King", LocalDate.of(2008, 1, 22));
        bookRepository.save(dumaKey);
        Copy dumaKey1 = new Copy("free", dumaKey);
        Copy dumaKey2 = new Copy("free", dumaKey);
        copyRepository.save(dumaKey1);
        copyRepository.save(dumaKey2);
        Borrow borrow1 = new Borrow(LocalDate.now(), LocalDate.now().plusDays(30), johnSmith, dumaKey1);
        Borrow borrow2 = new Borrow(LocalDate.now(), LocalDate.now().plusDays(30), mikeRoads, dumaKey2);
        dumaKey1.setStatus("borrowed");
        dumaKey2.setStatus("borrowed");
        borrowRepository.save(borrow1);
        borrowRepository.save(borrow2);
        //When
        borrowRepository.deleteById(borrow2.getId());
        List<Borrow> borrows = (List<Borrow>) borrowRepository.findAll();
        //Then
        assertEquals(1, borrows.size());
        assertEquals(borrow1.getId(), borrows.get(0).getId());
        //CleanUp
        borrowRepository.deleteAll();

    }

}