package com.kodilla.library.book;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService service;
    private final BookMapper mapper;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = service.getAllBooks();
        return ResponseEntity.ok(mapper.mapToBookListDto(books));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(mapper.mapToBookDto(service.getBook(bookId)));
    }

    @DeleteMapping(value = "{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        service.deleteBook(service.getBook(bookId).getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDto bookDto) {
        Book book = mapper.mapToBook(bookDto);
        service.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        Book book = mapper.mapToBook(bookDto);
        Book savedBook = service.saveBook(book);
        return ResponseEntity.ok(mapper.mapToBookDto(savedBook));

    }
}
