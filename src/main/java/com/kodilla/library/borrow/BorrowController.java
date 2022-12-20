package com.kodilla.library.borrow;

import com.kodilla.library.copy.CopyService;
import com.kodilla.library.reader.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/borrows")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BorrowController {

    private final BorrowService service;
    private final BorrowMapper mapper;
    private final CopyService copyService;
    private final ReaderService readerService;

    @GetMapping
    public ResponseEntity<List<BorrowDto>> getBorrows() {
        List<Borrow> borrows = service.getBorrows();
        return ResponseEntity.ok(mapper.mapToBorrowListDto(borrows));
    }

    @GetMapping(value = "{borrowId}")
    public ResponseEntity<BorrowDto> getBorrow(@PathVariable Long borrowId) {
        return ResponseEntity.ok(mapper.mapToBorrowDto(service.getBorrow(borrowId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> borrowBook(@RequestBody BorrowDto borrowDto) {
        Borrow borrow = mapper.mapToBorrow(borrowDto);
        borrow.getCopy().setStatus("borrowed");
        service.saveBorrow(borrow);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{borrowId}")
    public ResponseEntity<Void> returnBook(@PathVariable Long borrowId) {
        service.getBorrow(borrowId).getCopy().setStatus("free");
        service.deleteBorrow(service.getBorrow(borrowId).getId());
        return ResponseEntity.ok().build();
    }


}
