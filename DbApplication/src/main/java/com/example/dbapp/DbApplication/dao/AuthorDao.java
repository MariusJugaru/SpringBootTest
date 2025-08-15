package com.example.dbapp.DbApplication.dao;

import com.example.dbapp.DbApplication.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);

    List<Author> find();

    void update(Author author, Long id);

    void delete(long l);
}
