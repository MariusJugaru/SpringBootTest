package com.colors.colors.Impl;

import com.colors.colors.BluePrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishBluePrinter implements BluePrinter {
    public String print() {
        return "blue";
    }
}
