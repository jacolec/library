package com.kodilla.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }
}
