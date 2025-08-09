package com.colors.colors.Impl;

import com.colors.colors.BluePrinter;
import com.colors.colors.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "red";
    }
}
