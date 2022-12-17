package com.kodilla.library.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    void delete(Book entity);

    @Override
    <S extends Book> S save(S entity);
}
