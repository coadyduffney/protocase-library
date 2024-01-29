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

    public boolean addBook(BookCopy book) {
        if (!bookList.contains(book)) {
            return bookList.add(book);
        }

        return false;
    }

    public boolean removeBook(BookCopy book) {
        return this.bookList.remove(book);
    }

    public ObservableList<BookCopy> getBooks() {
        return bookList;
    }

}
