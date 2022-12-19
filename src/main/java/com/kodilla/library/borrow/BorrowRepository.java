package com.kodilla.library.borrow;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {

}
