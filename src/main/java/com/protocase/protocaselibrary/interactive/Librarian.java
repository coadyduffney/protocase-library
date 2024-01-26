package com.protocase.protocaselibrary.interactive;

import com.protocase.protocaselibrary.App;
import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.fundamental.Library;
import com.protocase.protocaselibrary.fundamental.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Librarian {

    public Librarian() {

    }

    public List<Book> searchBooks(BookFilter bookFilter) {
        return App.library.getInventory().stream()
                .filter(bookFilter::matches)
                .collect(Collectors.toList());
    }

    public void addNewBook(Book book) {

    }

    public void editBook(Book book) {

    }

    public void deleteBook(Book book) {

    }

    public void addNewUser(User user) {

    }

    public void editUser(User user) {

    }

    public void deleteUser(User user) {

    }

}
