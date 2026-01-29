package com.jackson.jackson_demo;

import com.jackson.jackson_demo.domain.Book;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JacksonTest {

    @Test
    public void testThatJsonObjectMapperCanCreateJsonFromJavaObject() {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = Book.builder()
                .isbn("123-abc")
                .title("A book")
                .author("John Doe")
                .yearPublished(1992)
                .build();

        String result = objectMapper.writeValueAsString(book);
        assertThat(result).isEqualTo("{\"isbn\":\"123-abc\",\"title\":\"A book\",\"author\":\"John Doe\",\"year\":1992}");
    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJson() {
        Book book = Book.builder()
                .isbn("123-abc")
                .title("A book")
                .author("John Doe")
                .yearPublished(1992)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"foo\":\"bar\",\"isbn\":\"123-abc\",\"title\":\"A book\",\"author\":\"John Doe\",\"year\":1992}";

        Book result = objectMapper.readValue(json, Book.class);

        assertThat(result).isEqualTo(book);
    }
}
