package com.example.dbPostgresJdbc.dao;

import com.example.dbPostgresJdbc.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String s);
}
