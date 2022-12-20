package com.kodilla.library.reader;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getSignUpDate());
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getSignUpDate());
    }

    public List<ReaderDto> mapToReaderListDto(final List<Reader> readerList) {
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
