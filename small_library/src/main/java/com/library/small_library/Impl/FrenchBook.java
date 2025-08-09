package com.library.small_library.Impl;

import com.library.small_library.BookInterface;
import org.springframework.stereotype.Component;

@Component
public class FrenchBook implements BookInterface {
    @Override
    public String printBook() {
        return "Livre français : 130 pages";
    }
}
