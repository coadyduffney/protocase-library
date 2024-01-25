package com.protocase.protocaselibrary.management;

import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.interactive.BookCopy;

import java.util.List;
import java.util.Optional;

public class BookLog {
    private List<BookCopy> bookHistory;

    public BookLog() {

    }

    public void addEntry(BookCopy book) {
        if (!bookHistory.contains(book)) {
            bookHistory.add(book);
        }
    }

    public Optional<BookCopy> getEntryFor(BookCopy book) {
        return Optional.empty();
    }

    public void removeEntry(BookCopy book) {
        bookHistory.remove(book);
    }
}
