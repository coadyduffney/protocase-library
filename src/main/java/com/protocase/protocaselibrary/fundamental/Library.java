package com.protocase.protocaselibrary.fundamental;

import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.interactive.Librarian;
import com.protocase.protocaselibrary.interactive.UserSession;
import com.protocase.protocaselibrary.management.BookLog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Coady Duffney
 */
public class Library {
    private final BookInventory inventory;
    private final BookLog bookLog;

    private final Librarian librarian;

    public Library() {
        bookLog = new BookLog();
        inventory = new BookInventory();
        librarian = new Librarian();
    }

    public void logIn(User user) {
        UserSession.getInstance().setUser(user);
    }

    public void logOut() {
        UserSession.getInstance().setUser(null);
    }

    public BookInventory getInventory() {
        return inventory;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public BookLog getBookLog() {
        return bookLog;
    }

    public void checkOutBooks(List<BookCopy> books) {
        for (BookCopy bookCopy : books) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate checkOutDate = LocalDate.now();
            String formattedCheckOut = checkOutDate.format(formatter);

            LocalDate checkInDate = checkOutDate.plusDays(14);
            String formattedCheckInDate = checkInDate.format(formatter);

            bookCopy.setUserId(UserSession.getInstance().getUser().getId());
            bookCopy.setCheckOutDate(formattedCheckOut);
            bookCopy.setCheckInDate(formattedCheckInDate);
            bookLog.addEntry(bookCopy);
        }

        books.clear();
    }
}
