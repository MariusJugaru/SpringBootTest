package com.example.dbapp.DbApplication;

import com.example.dbapp.DbApplication.domain.Author;
import com.example.dbapp.DbApplication.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){};

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("John Doe")
                .age(30)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Jane Doe")
                .age(29)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Janny Doe")
                .age(28)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("2314")
                .title("The book")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("2315")
                .title("The other book")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("2310")
                .title("The not book book")
                .authorId(2L)
                .build();
    }
}
