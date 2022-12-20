package com.kodilla.library.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/readers")
@CrossOrigin(origins = "*")
public class ReaderController {

    private final ReaderService service;
    private final ReaderMapper mapper;

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getReaders() {
        List<Reader> readers = service.getReaders();
        return ResponseEntity.ok(mapper.mapToReaderListDto(readers));
    }

    @GetMapping(value = "{readerId}")
    public ResponseEntity<ReaderDto> getReader(@PathVariable Long readerId) {
        return ResponseEntity.ok(mapper.mapToReaderDto(service.getReader(readerId)));
    }

    @DeleteMapping("{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long readerId) {
        service.deleteReader(service.getReader(readerId).getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = mapper.mapToReader(readerDto);
        service.saveReader(reader);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReaderDto> updateReader(@RequestBody ReaderDto readerDto) {
        Reader reader = mapper.mapToReader(readerDto);
        Reader savedReader = service.saveReader(reader);
        return ResponseEntity.ok(mapper.mapToReaderDto(savedReader));
    }
}
