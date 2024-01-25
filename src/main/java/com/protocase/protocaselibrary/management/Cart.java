package com.protocase.protocaselibrary.management;

import com.protocase.protocaselibrary.fundamental.Book;

import java.util.List;

public class Cart {

    private Cart instance;
    private List<Book> books;

    private Cart() {

    }

    public Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }

        return instance;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void checkout() {

    }

}
