package com.protocase.protocaselibrary.interactive;

import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.fundamental.Library;
import com.protocase.protocaselibrary.fundamental.User;

import java.util.List;

public class Librarian {

    public Librarian() {

    }

    public List<Book> searchBooks(BookFilter bookFilter) {
        return Library.getInstance().getInventory().getBooks().stream()
                .filter(bookFilter::matches)
                .toList();
    }

    public void addNewBook(Book book) {
        // TODO: implement
    }

    public void editBook(Book book) {
        // TODO: implement
    }

    public void deleteBook(Book book) {
        // TODO: implement
    }

    public void addNewUser(User user) {
        // TODO: implement
    }

    public void editUser(User user) {
        // TODO: implement
    }

    public void deleteUser(User user) {
        // TODO: implement
    }

}
