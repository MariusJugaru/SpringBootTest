package com.example.dbPostgresJdbc.dao.impl;

import com.example.dbPostgresJdbc.TestDataUtil;
import com.example.dbPostgresJdbc.dao.AuthorDao;
import com.example.dbPostgresJdbc.dao.imp.AuthorDaoImpl;
import com.example.dbPostgresJdbc.dao.imp.BookDaoImpl;
import com.example.dbPostgresJdbc.domain.Author;
import com.example.dbPostgresJdbc.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {

    private AuthorDao authorDao;
    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao) {
        this.authorDao = authorDao;
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthor();
        Book book = TestDataUtil.createTestBook();
        book.setAuthor_id(author.getId());
        authorDao.create(author);

        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
}
