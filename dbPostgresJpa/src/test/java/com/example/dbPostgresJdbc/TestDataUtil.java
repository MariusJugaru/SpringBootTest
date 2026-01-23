package com.example.dbPostgresJdbc;

import com.example.dbPostgresJdbc.domain.Author;
import com.example.dbPostgresJdbc.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static Author createTestAuthorA() {
        return Author.builder()
                .age(39)
                .name("Rose Chrystal")
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .age(29)
                .name("Mary Chrystal")
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .age(32)
                .name("Mark Chrystal")
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("123-232")
                .title("Marry Road")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("123-abc")
                .title("Christmas Day")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("123-abc-456")
                .title("A new day")
                .author(author)
                .build();
    }
}
