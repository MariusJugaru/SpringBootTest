package com.example.dbPostgresJdbc.services.impl;

import com.example.dbPostgresJdbc.domain.entities.AuthorEntity;
import com.example.dbPostgresJdbc.repositories.AuthorRepository;
import com.example.dbPostgresJdbc.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
