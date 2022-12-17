package com.kodilla.library.copy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    <S extends Copy> S save(S entity);

    @Override
    @Transactional
    Optional<Copy> findById(Long aLong);

    @Override
    @Transactional
    Iterable<Copy> findAll();

    @Override
    @Transactional
    void deleteById(Long aLong);

}
