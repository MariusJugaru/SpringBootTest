package com.library.small_library.Impl;

import com.library.small_library.LibraryInterface;
import org.springframework.stereotype.Component;

@Component
public class Library implements LibraryInterface {

    EnglishBook englishBook;
    FrenchBook frenchBook;
    ItalianBook italianBook;

    public Library(EnglishBook englishBook, FrenchBook frenchBook, ItalianBook italianBook) {
        this.englishBook = englishBook;
        this.frenchBook = frenchBook;
        this.italianBook = italianBook;
    }
    @Override
    public String printBook() {
        return String.join("\n" ,englishBook.printBook(), frenchBook.printBook(), italianBook.printBook());
    }
}
