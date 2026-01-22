package com.example.dbPostgresJdbc.repositories;

import com.example.dbPostgresJdbc.TestDataUtil;
import com.example.dbPostgresJdbc.domain.Author;
import com.example.dbPostgresJdbc.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTest {

    private BookRepository underTest;

    @Autowired
    public BookRepositoryIntegrationTest(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author);

        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get().getIsbn()).isEqualTo(book.getIsbn());
        assertThat(result.get().getTitle()).isEqualTo(book.getTitle());
        assertThat(result.get().getAuthor().getName())
                .isEqualTo(book.getAuthor().getName());
    }

//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
//        Author authorA = TestDataUtil.createTestAuthorA();
//        authorDao.create(authorA);
//        Author authorB = TestDataUtil.createTestAuthorB();
//        authorDao.create(authorB);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        Book bookB = TestDataUtil.createTestBookB();
//        Book bookC = TestDataUtil.createTestBookC();
//
//        bookA.setAuthor_id(authorA.getId());
//        bookB.setAuthor_id(authorB.getId());
//        bookC.setAuthor_id(authorB.getId());
//
//        underTest.create(bookA);
//        underTest.create(bookB);
//        underTest.create(bookC);
//
//        List<Book> result = underTest.find();
//        assertThat(result)
//                .isNotNull()
//                .containsExactly(bookA, bookB, bookC);
//
//    }
//
//    @Test
//    public void testThatBookCanBeUpdated() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthor_id(author.getId());
//        underTest.create(bookA);
//
//        bookA.setTitle("New Title");
//        underTest.update(bookA.getIsbn(), bookA);
//
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(bookA);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthor_id(author.getId());
//        underTest.create(bookA);
//        underTest.delete(bookA.getIsbn());
//
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isEmpty();
//    }
}
