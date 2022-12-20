package com.kodilla.library.copy;

import com.kodilla.library.book.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    private BookService bookService;

    public Copy mapToCopy(CopyDto copyDto) {
        return new Copy(copyDto.getStatus(), bookService.getBook(copyDto.getBookId()));
    }

    public CopyDto mapToCopyDto(Copy copy) {
        return new CopyDto(copy.getId(), copy.getStatus(), copy.getBook().getId());
    }

    public List<CopyDto> mapToCopyListDto(final List<Copy> copies) {
        return copies.stream()
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }


}
