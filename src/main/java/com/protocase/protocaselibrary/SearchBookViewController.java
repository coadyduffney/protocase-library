package com.protocase.protocaselibrary;

import com.protocase.protocaselibrary.components.BookCard;
import com.protocase.protocaselibrary.fundamental.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class SearchBookViewController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button searchButton;

    @FXML
    private TextField titleField;
    @FXML
    private Label bookAuthor;

    @FXML
    private Label bookDescription;

    @FXML
    private Label bookTitle;

    @FXML
    private HBox bookContainer;

    public void init() {

        List<Book> bookList = App.LIBRARY.getInventory().getBooks();
        bookList.forEach(book -> {
            BookCard card = new BookCard(book);
            bookContainer.getChildren().add(card);
        });
    }

    @FXML
    void onSearch(ActionEvent event) {

    }
}
