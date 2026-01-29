package com.example.dbPostgresJdbc.repositories;

import com.example.dbPostgresJdbc.TestDataUtil;
import com.example.dbPostgresJdbc.domain.entities.AuthorEntity;
import com.example.dbPostgresJdbc.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTest {

    private BookRepository underTest;

    @Autowired
    public BookEntityRepositoryIntegrationTest(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);

        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get().getIsbn()).isEqualTo(bookEntity.getIsbn());
        assertThat(result.get().getTitle()).isEqualTo(bookEntity.getTitle());
        assertThat(result.get().getAuthorEntity().getName())
                .isEqualTo(bookEntity.getAuthorEntity().getName());
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();

        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntityA);
        BookEntity bookEntityB = TestDataUtil.createTestBookB(authorEntityB);
        BookEntity bookEntityC = TestDataUtil.createTestBookC(authorEntityB);


        bookEntityA = underTest.save(bookEntityA);
        bookEntityB = underTest.save(bookEntityB);
        bookEntityC = underTest.save(bookEntityC);

        Iterable<BookEntity> result = underTest.findAll();
        assertThat(result)
                .isNotEmpty()
                .containsExactly(bookEntityA, bookEntityB, bookEntityC);

    }

    @Test
    public void testThatBookCanBeUpdated() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();

        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntity);
        underTest.save(bookEntityA);

        bookEntityA.setTitle("New Title");
        bookEntityA = underTest.save(bookEntityA);

        Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntityA);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();

        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntity);
        bookEntityA = underTest.save(bookEntityA);
        underTest.delete(bookEntityA);

        Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
        assertThat(result).isEmpty();
    }
}
