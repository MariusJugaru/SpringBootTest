package com.example.dbPostgresJdbc;

import com.example.dbPostgresJdbc.domain.Author;
import com.example.dbPostgresJdbc.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .age(39)
                .name("Rose Chrystal")
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .age(29)
                .name("Mary Chrystal")
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("123-232")
                .title("Marry Road")
                .author_id(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("123-abc")
                .title("Christmas Day")
                .author_id(2L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("123-abc-456")
                .title("A new day")
                .author_id(3L)
                .build();
    }
}
