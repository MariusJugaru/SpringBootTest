package com.example.dbPostgresJdbc.dao.impl;

import com.example.dbPostgresJdbc.TestDataUtil;
import com.example.dbPostgresJdbc.dao.imp.BookDaoImpl;
import com.example.dbPostgresJdbc.domain.Book;
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
                eq("123-232"), eq("Marry Road"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql() {
        underTest.findOne("123_abc_456");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("123_abc_456")
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql() {
        underTest.find();

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdatesGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.update("123-456", book);

        verify(jdbcTemplate).update(
                eq("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?"),
                eq(book.getIsbn()), eq(book.getTitle()), eq(book.getAuthor_id()), eq("123-456")
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql() {
        underTest.delete("123-abc");
        verify(jdbcTemplate).update(
                eq("DELETE FROM books where isbn = ?"),
                eq("123-abc")
        );
    }
}
