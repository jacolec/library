package com.kodilla.library.borrow;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {

    @Override
    <S extends Borrow> S save(S entity);

    @Override
    Optional<Borrow> findById(Long aLong);

    @Override
    void deleteAll();

    @Override
    void deleteById(Long aLong);
}
