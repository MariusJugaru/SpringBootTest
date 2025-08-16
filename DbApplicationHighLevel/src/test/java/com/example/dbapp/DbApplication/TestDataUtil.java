package com.example.dbapp.DbApplication;

import com.example.dbapp.DbApplication.domain.Author;
import com.example.dbapp.DbApplication.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){};

    public static Author createTestAuthorA() {
        return Author.builder()
                .name("John Doe")
                .age(30)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .name("Jane Doe")
                .age(29)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .name("Janny Doe")
                .age(28)
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("2314")
                .title("The book")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("2315")
                .title("The other book")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("2310")
                .title("The not book book")
                .author(author)
                .build();
    }
}
