package com.kodilla.library.book;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BookDto> mapToBookListDto(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
