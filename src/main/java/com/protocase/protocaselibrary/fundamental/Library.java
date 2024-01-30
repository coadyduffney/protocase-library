package com.protocase.protocaselibrary.fundamental;

import com.protocase.protocaselibrary.App;
import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.interactive.Librarian;
import com.protocase.protocaselibrary.interactive.UserSession;
import com.protocase.protocaselibrary.management.BookLog;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

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
        Platform.runLater(() -> {
            Notifications
                    .create()
                    .text("Welcome, " + user.getFirstName() + " " + user.getLastName())
                    .graphic(new ImageView(new Image(getClass().getResourceAsStream("/images/favicon-32x32.png"))))
                    .position(Pos.BOTTOM_RIGHT)
                    .owner(App.WINDOW)
                    .hideAfter(Duration.seconds(1))
                    .show();
        });
    }

    public void logOut() {
        UserSession userSession = UserSession.getInstance();
        User user = userSession.getUser();
        userSession.setUser(null);
        Platform.runLater(() -> {
            Notifications
                    .create()
                    .text("Goodbye, " + user.getFirstName() + " " + user.getLastName())
                    .graphic(new ImageView(new Image(getClass().getResourceAsStream("/images/favicon-32x32.png"))))
                    .position(Pos.BOTTOM_RIGHT)
                    .owner(App.WINDOW)
                    .hideAfter(Duration.seconds(1))
                    .show();
        });
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
