package com.protocase.protocaselibrary.management;

import com.protocase.protocaselibrary.App;
import com.protocase.protocaselibrary.interactive.BookCopy;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

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

            Platform.runLater(() -> {
                Notifications
                        .create()
                        .text("Book added to cart!")
                        .graphic(new ImageView(new Image(getClass().getResourceAsStream("/images/favicon-32x32.png"))))
                        .position(Pos.BOTTOM_RIGHT)
                        .owner(App.WINDOW)
                        .hideAfter(Duration.seconds(1))
                        .show();
            });
        }
    }

    public void removeBook(BookCopy book) {
        this.bookList.add(book);
    }

    public ObservableList<BookCopy> getBooks() {
        return bookList;
    }

}
