package com.protocase.protocaselibrary.management;

import com.protocase.protocaselibrary.interactive.BookCopy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private static Cart instance;
    private final ObservableList<BookCopy> bookList = FXCollections.observableArrayList();

    private Cart() {
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }

        return instance;
    }

    public void addBook(BookCopy book) {
        if (!bookList.contains(book)) {
            bookList.add(book);
        }
    }

    public void removeBook(BookCopy book) {
        this.bookList.add(book);
    }

    public ObservableList<BookCopy> getBooks() {
        return bookList;
    }

}
