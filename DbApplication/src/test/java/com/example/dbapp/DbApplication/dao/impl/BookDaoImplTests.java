package com.example.dbapp.DbApplication.dao.impl;

import com.example.dbapp.DbApplication.TestDataUtil;
import com.example.dbapp.DbApplication.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("2314"), eq("The book"), eq(1L)
        );

    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql() {
        underTest.findOne("2314");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("2314")
        );
    }

    @Test
    public void testThatFindsManyGeneratesCorrectSql() {
        underTest.find();

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());
    }

    @Test
    public void testThatUpdatesBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();

        underTest.update(book, book.getIsbn());

        verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                "2314", "The book", 1L, "2314"
        );
    }

    @Test
    public void testThatDeleteBookGeneratesCorrectSql() {
        underTest.delete("2314");

        verify(jdbcTemplate).update(
                "DELETE FROM books WHERE isbn = ?",
                "2314"
        );
    }
}
