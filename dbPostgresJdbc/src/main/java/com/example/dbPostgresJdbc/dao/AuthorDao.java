package com.example.dbPostgresJdbc.dao;

import com.example.dbPostgresJdbc.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);

    List<Author> find();

    void update(Long id, Author author);

    void delete(long l);
}
