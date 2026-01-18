package com.example.dbPostgresJdbc.dao;

import com.example.dbPostgresJdbc.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String s);

    List<Book> find();

    void update(String s, Book book);
}
