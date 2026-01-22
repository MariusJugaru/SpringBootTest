package com.example.dbPostgresJdbc.repositories;

import com.example.dbPostgresJdbc.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
