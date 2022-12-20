package com.kodilla.library.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class BookTestSuite {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testfindBookById() {
        //Given
        Book dumaKey = new Book("Duma key", "Stephen King", LocalDate.of(2008, 1, 22));
        Book trhlina = new Book("Trhlina", "Josef Karika", LocalDate.of(2017, 1, 01));
        Book secretLifeOfTrees = new Book("Das geheime Leben der Baume", "Peter Wohlleben", LocalDate.of(2016, 9, 14));

        bookRepository.save(dumaKey);
        bookRepository.save(trhlina);
        bookRepository.save(secretLifeOfTrees);

        //When
        Long dumaKeyId = dumaKey.getId();
        Long trhlinaId = trhlina.getId();
        Long secretLifeOfTreesId = secretLifeOfTrees.getId();

        Optional<Book> testBook1 = bookRepository.findById(dumaKeyId);
        Optional<Book> testBook2 = bookRepository.findById(trhlinaId);
        Optional<Book> testBook3 = bookRepository.findById(secretLifeOfTreesId);

        //Then
        assertEquals(dumaKeyId, testBook1.get().getId());
        assertEquals(trhlinaId, testBook2.get().getId());
        assertEquals(secretLifeOfTreesId, testBook3.get().getId());

        //CleanUp
        bookRepository.deleteAll();
    }

    @Test
    void testFindAllBooks() {
        //Given
        Book dumaKey = new Book("Duma key", "Stephen King", LocalDate.of(2008, 1, 22));
        Book trhlina = new Book("Trhlina", "Josef Karika", LocalDate.of(2017, 1, 01));
        Book secretLifeOfTrees = new Book("Das geheime Leben der Baume", "Peter Wohlleben", LocalDate.of(2016, 9, 14));

        bookRepository.save(dumaKey);
        bookRepository.save(trhlina);
        bookRepository.save(secretLifeOfTrees);

        //When
        List<Book> books = (List<Book>) bookRepository.findAll();

        //Then
        assertEquals(3, books.size());

        //CleanUp
        bookRepository.deleteAll();
    }

    @Test
    void testDeleteBookById() {
        //Given
        Book dumaKey = new Book("Duma key", "Stephen King", LocalDate.of(2008, 1, 22));
        Book trhlina = new Book("Trhlina", "Josef Karika", LocalDate.of(2017, 1, 01));
        Book secretLifeOfTrees = new Book("Das geheime Leben der Baume", "Peter Wohlleben", LocalDate.of(2016, 9, 14));

        bookRepository.save(dumaKey);
        bookRepository.save(trhlina);
        bookRepository.save(secretLifeOfTrees);

        Long dumaKeyId = dumaKey.getId();
        Long trhlinaId = trhlina.getId();
        Long secretLifeOfTreesId = secretLifeOfTrees.getId();

        //When
        bookRepository.deleteById(trhlinaId);
        bookRepository.deleteById(secretLifeOfTreesId);

        List<Book> books = (List<Book>) bookRepository.findAll();

        //Then
        assertEquals(1, books.size());
        assertEquals(dumaKeyId, books.get(0).getId());

        //CleanUp
        bookRepository.deleteAll();
    }

    @Test
    void testDeleteAllBooks() {
        //Given
        Book dumaKey = new Book("Duma key", "Stephen King", LocalDate.of(2008, 1, 22));
        Book trhlina = new Book("Trhlina", "Josef Karika", LocalDate.of(2017, 1, 01));
        Book secretLifeOfTrees = new Book("Das geheime Leben der Baume", "Peter Wohlleben", LocalDate.of(2016, 9, 14));

        bookRepository.save(dumaKey);
        bookRepository.save(trhlina);
        bookRepository.save(secretLifeOfTrees);

        //When
        bookRepository.deleteAll();
        List<Book> books = (List<Book>) bookRepository.findAll();

        //Then
        assertEquals(0, books.size());
    }
}