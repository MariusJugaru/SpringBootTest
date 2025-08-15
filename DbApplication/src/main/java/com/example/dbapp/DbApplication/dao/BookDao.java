package com.example.dbapp.DbApplication.dao;

import com.example.dbapp.DbApplication.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();

    void update(Book book, String isbn);

    void delete(String isbn);
}
