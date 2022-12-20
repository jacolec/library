package com.kodilla.library.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> getReaders() {
        return (List<Reader>) readerRepository.findAll();
    }

    public Reader getReader(Long readerId) {
        return readerRepository.findById(readerId).get();
    }

    public void deleteReader(Long readerId) {
        readerRepository.deleteById(readerId);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }
}
