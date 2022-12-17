package com.kodilla.library.reader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ReaderTestSuite {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    void testFindReaderById() {
        //Given
        Reader johnSmith = new Reader("John", "Smith", LocalDate.of(2020, 11, 6));
        Reader mikeRoads = new Reader("Mike", "Roads", LocalDate.of(2010, 4, 14));
        Reader kateLopez = new Reader("Kate", "Lopez", LocalDate.of(1998, 5, 24));

        readerRepository.save(johnSmith);
        readerRepository.save(mikeRoads);
        readerRepository.save(kateLopez);

        //When
        Long johnSmithId = johnSmith.getId();
        Long mikeRoadsId = mikeRoads.getId();
        Long kateLopezId = kateLopez.getId();

        Optional<Reader> testReader1 = readerRepository.findById(johnSmithId);
        Optional<Reader> testReader2 = readerRepository.findById(mikeRoadsId);
        Optional<Reader> testReader3 = readerRepository.findById(kateLopezId);

        //Then
        assertEquals(johnSmithId, testReader1.get().getId());
        assertEquals(mikeRoadsId, testReader2.get().getId());
        assertEquals(kateLopezId, testReader3.get().getId());

        //CleanUp
        readerRepository.deleteAll();
    }

    @Test
    void testFinAllReaders() {
        //Given
        Reader johnSmith = new Reader("John", "Smith", LocalDate.of(2020, 11, 6));
        Reader mikeRoads = new Reader("Mike", "Roads", LocalDate.of(2010, 4, 14));
        Reader kateLopez = new Reader("Kate", "Lopez", LocalDate.of(1998, 5, 24));

        readerRepository.save(johnSmith);
        readerRepository.save(mikeRoads);
        readerRepository.save(kateLopez);

        //When
        List<Reader> readers = (List<Reader>) readerRepository.findAll();

        //Then
        assertEquals(3, readers.size());

        //CleanUp
        readerRepository.deleteAll();
    }

    @Test
    void testDeleteReaderById() {
        //Given
        Reader johnSmith = new Reader("John", "Smith", LocalDate.of(2020, 11, 6));
        Reader mikeRoads = new Reader("Mike", "Roads", LocalDate.of(2010, 4, 14));
        Reader kateLopez = new Reader("Kate", "Lopez", LocalDate.of(1998, 5, 24));

        readerRepository.save(johnSmith);
        readerRepository.save(mikeRoads);
        readerRepository.save(kateLopez);

        //When
        Long johnSmithId = johnSmith.getId();
        Long mikeRoadsId = mikeRoads.getId();
        Long kateLopezId = kateLopez.getId();

        readerRepository.deleteById(kateLopezId);
        readerRepository.deleteById(mikeRoadsId);

        List<Reader> readers = (List<Reader>) readerRepository.findAll();

        //Then
        assertEquals(1, readers.size());
        assertEquals(johnSmithId, readers.get(0).getId());

        //CleanUp
        readerRepository.deleteAll();
    }

    @Test
    void testDeleteAllReaders() {
        //Given
        Reader johnSmith = new Reader("John", "Smith", LocalDate.of(2020, 11, 6));
        Reader mikeRoads = new Reader("Mike", "Roads", LocalDate.of(2010, 4, 14));
        Reader kateLopez = new Reader("Kate", "Lopez", LocalDate.of(1998, 5, 24));

        readerRepository.save(johnSmith);
        readerRepository.save(mikeRoads);
        readerRepository.save(kateLopez);

        //When
        readerRepository.deleteAll();
        List<Reader> readers = (List<Reader>) readerRepository.findAll();

        //Then
        assertEquals(0, readers.size());
    }
}