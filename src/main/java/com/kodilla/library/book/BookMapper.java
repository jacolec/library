package com.kodilla.library.book;


import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        return new Book(bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getReleaseDate());
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getReleaseDate());
    }
}
