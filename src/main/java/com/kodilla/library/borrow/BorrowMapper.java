package com.kodilla.library.borrow;

import com.kodilla.library.copy.CopyService;
import com.kodilla.library.reader.ReaderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowMapper {

    private ReaderService readerService;
    private CopyService copyService;

    public Borrow mapToBorrow(BorrowDto borrowDto) {
        return new Borrow(borrowDto.getBorrowDate(),
                borrowDto.getReturnDate(),
                readerService.getReader(borrowDto.getReaderId()),
                copyService.getCopy(borrowDto.getCopyId()));
    }

    public BorrowDto mapToBorrowDto(Borrow borrow) {
        return new BorrowDto(borrow.getId(),
                borrow.getBorrowDate(),
                borrow.getReturnDate(),
                borrow.getReader().getId(),
                borrow.getCopy().getId());
    }

    public List<BorrowDto> mapToBorrowListDto(final List<Borrow> borrowList) {
        return borrowList.stream()
                .map(this::mapToBorrowDto)
                .collect(Collectors.toList());
    }
}
