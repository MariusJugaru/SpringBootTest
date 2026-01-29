package com.example.dbPostgresJdbc.services;

import com.example.dbPostgresJdbc.domain.entities.AuthorEntity;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);
}
