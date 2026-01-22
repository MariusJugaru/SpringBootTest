package com.example.dbPostgresJdbc.dao.impl;

import com.example.dbPostgresJdbc.TestDataUtil;
import com.example.dbPostgresJdbc.dao.imp.AuthorDaoImpl;
import com.example.dbPostgresJdbc.domain.Author;
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
public class AuthorDaoImplIntegatrionTest {

    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegatrionTest(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author authorA = TestDataUtil.createTestAuthorA();
        Author authorB = TestDataUtil.createTestAuthorB();

        underTest.create(authorA);
        underTest.create(authorB);

        List<Author> result = underTest.find();
        assertThat(result).isNotNull();
        assertThat(result).containsExactly(authorA, authorB);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.create(authorA);

        authorA.setName("John Doe");
        underTest.update(authorA.getId(), authorA);

        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);
    }

    @Test public void testThatAuthorCanBeDeleted() {
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.create(authorA);
        underTest.delete(authorA.getId());

        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isEmpty();
    }
}
