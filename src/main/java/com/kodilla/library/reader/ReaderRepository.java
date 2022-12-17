package com.kodilla.library.reader;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    Optional<Reader> findById(Long readerId);

    @Override
    <S extends Reader> S save(S entity);

    @Override
    Iterable<Reader> findAllById(Iterable<Long> longs);

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}
