package com.protocase.protocaselibrary.uicomponents;

import com.protocase.protocaselibrary.App;
import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.management.Cart;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class BookCardController {
    private Book book;

    @FXML
    private Button addToCartButton;

    @FXML
    private Label authorLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Label titleLabel;

    @FXML
    void addToCart(ActionEvent event) {
        if (Cart.getInstance().addBook(new BookCopy(book))) {
            Platform.runLater(() -> {
                Notifications
                        .create()
                        .text(book.getTitle() + " added to cart!")
                        .graphic(new ImageView(new Image(getClass().getResourceAsStream("/images/favicon-32x32.png"))))
                        .position(Pos.BOTTOM_RIGHT)
                        .owner(App.WINDOW)
                        .hideAfter(Duration.seconds(1))
                        .show();
            });
        }
    }

    public void init(Book book) {
        this.book = book;

        titleLabel.setText(book.getTitle());
        authorLabel.setText(book.getAuthor());
        genreLabel.setText(book.getGenre());
        locationLabel.setText(book.getLocation());

    }

}
