package com.example.dbPostgresJdbc.dao;

import com.example.dbPostgresJdbc.dao.imp.AuthorDaoImpl;
import com.example.dbPostgresJdbc.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreatesAuthorGeneratesCorrectSql() {
        Author author = Author.builder()
                .id(1L)
                .age(39)
                .name("Rose Chrystal")
                .build();

        underTest.create(author);
        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Rose Chrystal"), eq(39)
        );
    }
}
