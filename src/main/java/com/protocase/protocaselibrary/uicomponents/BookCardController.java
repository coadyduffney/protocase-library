package com.protocase.protocaselibrary.uicomponents;

import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.management.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
        Cart.getInstance().addBook(new BookCopy(book));
    }

    public void init(Book book) {
        this.book = book;

        titleLabel.setText(book.getTitle());
        authorLabel.setText(book.getAuthor());
        genreLabel.setText(book.getGenre());
        locationLabel.setText(book.getLocation());
    }

}
