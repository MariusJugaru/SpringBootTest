package com.example.dbPostgresJdbc;

import com.example.dbPostgresJdbc.domain.entities.AuthorEntity;
import com.example.dbPostgresJdbc.domain.entities.BookEntity;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .age(39)
                .name("Rose Chrystal")
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .age(29)
                .name("Mary Chrystal")
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .age(32)
                .name("Mark Chrystal")
                .build();
    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("123-232")
                .title("Marry Road")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("123-abc")
                .title("Christmas Day")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("123-abc-456")
                .title("A new day")
                .authorEntity(authorEntity)
                .build();
    }
}
