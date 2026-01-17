package com.example.dbPostgresJdbc;

import com.example.dbPostgresJdbc.domain.Author;
import com.example.dbPostgresJdbc.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .age(39)
                .name("Rose Chrystal")
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("123-232")
                .title("Marry Road")
                .author_id(1L)
                .build();
    }
}
