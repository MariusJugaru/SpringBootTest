package com.example.dbapp.DbApplication.repositories;

import com.example.dbapp.DbApplication.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
