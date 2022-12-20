package com.kodilla.library.copy;

import com.kodilla.library.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/copies")
@CrossOrigin(origins = "*")
public class CopyController {

    private final CopyService service;
    private final CopyMapper mapper;
    private final BookService bookService;

    @GetMapping(value = "{bookId}")
    public ResponseEntity<List<CopyDto>> getCopiesByBookId(@PathVariable Long bookId) {
        List<Copy> copies = service.getCopies().stream()
                .filter(e -> e.getBook().equals(bookService.getBook(bookId)))
                .collect(Collectors.toList());
        return ResponseEntity.ok(mapper.mapToCopyListDto(copies));
    }

    @DeleteMapping(value = "{copyId}")
    public ResponseEntity<Void> deleteCopy(@PathVariable Long copyId) {
        service.deleteCopy(service.getCopy(copyId).getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCopy(@RequestBody CopyDto copyDto) {
        Copy copy = mapper.mapToCopy(copyDto);
        service.saveCopy(copy);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CopyDto> updateCopy(@RequestBody CopyDto copyDto) {
        Copy copy = mapper.mapToCopy(copyDto);
        Copy savedCopy = service.saveCopy(copy);
        return ResponseEntity.ok(mapper.mapToCopyDto(savedCopy));
    }
}
