package com.library.small_library.Impl;

import com.library.small_library.BookInterface;
import org.springframework.stereotype.Component;

@Component
public class ItalianBook implements BookInterface {
    @Override
    public String printBook() {
        return "Libro italiano: 200 pagine";
    }
}
