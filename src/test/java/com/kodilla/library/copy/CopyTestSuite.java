package com.kodilla.library.copy;

import com.kodilla.library.book.Book;
import com.kodilla.library.book.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class CopyTestSuite {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindCopyById() {
        //Given
        Book dumaKey = new Book("Duma key", "Stephen King", LocalDate.of(2008, 1, 22));
        bookRepository.save(dumaKey);

        Copy dumaKey1 = new Copy("borrowed", dumaKey);
        Copy dumaKey2 = new Copy("free", dumaKey);

        copyRepository.save(dumaKey1);
        copyRepository.save(dumaKey2);

        //When
        Optional<Copy> testCopy1 = copyRepository.findById(dumaKey1.getId());
        Optional<Copy> testCopy2 = copyRepository.findById(dumaKey2.getId());

        //Then
        assertEquals(dumaKey1.getId(), testCopy1.get().getId());
        assertEquals(dumaKey2.getId(), testCopy2.get().getId());

        //CleanUp
        copyRepository.deleteAll();
    }

    @Test
    void testFindAllCopies() {
        //Given
        Book trhlina = new Book("Trhlina", "Josef Karika", LocalDate.of(2017, 1, 01));
        bookRepository.save(trhlina);

        Copy trhlina1 = new Copy("borrowed", trhlina);
        Copy trhlina2 = new Copy("free", trhlina);

        copyRepository.save(trhlina1);
        copyRepository.save(trhlina2);

        //When
        List<Copy> copies = (List<Copy>) copyRepository.findAll();

        //Then
        assertEquals(2, copies.size());

        //CleanUp
        copyRepository.deleteAll();
    }

    @Test
    void testDeleteCopyById() {
        //Given
        Book secretLifeOfTrees = new Book("Das geheime Leben der Baume", "Peter Wohlleben", LocalDate.of(2016, 9, 14));
        bookRepository.save(secretLifeOfTrees);

        Copy secretLifeOfTrees1 = new Copy("borrowed", secretLifeOfTrees);
        Copy secretLifeOfTrees2 = new Copy("free", secretLifeOfTrees);

        copyRepository.save(secretLifeOfTrees1);
        copyRepository.save(secretLifeOfTrees2);

        //When
        copyRepository.deleteById(secretLifeOfTrees1.getId());
        List<Copy> copies = (List<Copy>) copyRepository.findAll();

        //Then
        assertEquals(1, copies.size());
        assertEquals(secretLifeOfTrees2.getId(), copies.get(0).getId());

        //CleanUp
        copyRepository.deleteAll();
    }
}