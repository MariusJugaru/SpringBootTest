package com.example.dbapp.DbApplication.dao;

import com.example.dbapp.DbApplication.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}
