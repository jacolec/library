package com.kodilla.library.copy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {



}
