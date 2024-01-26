package com.protocase.protocaselibrary.management;

import com.protocase.protocaselibrary.interactive.BookCopy;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private List<BookCopy> books;

    private Cart() {
        this.books = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }

        return instance;
    }

    public void addBook(BookCopy book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(BookCopy book) {
        this.books.remove(book);
    }

    public List<BookCopy> getBooks() {
        return books;
    }

}
