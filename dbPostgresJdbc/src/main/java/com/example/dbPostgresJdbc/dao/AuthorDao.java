package com.example.dbPostgresJdbc.dao;

import com.example.dbPostgresJdbc.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}
