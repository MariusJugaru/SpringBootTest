package com.library.small_library.Impl;

import com.library.small_library.BookInterface;
import org.springframework.stereotype.Component;

@Component
public class EnglishBook implements BookInterface {

    public String printBook() {
        return "English book: 100 pages.";
    }
}
