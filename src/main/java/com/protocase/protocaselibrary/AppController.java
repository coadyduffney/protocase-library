package com.protocase.protocaselibrary;

import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.interactive.BookFilter;
import com.protocase.protocaselibrary.interactive.Librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class AppController {
    private Librarian librarian;

    @FXML
    private VBox bookContainer;

    @FXML
    private HBox buttonContainer;

    @FXML
    private Button cartButton;

    @FXML
    private Button logInButton;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Button searchButton;

    @FXML
    private HBox searchContainer;

    @FXML
    private TextField searchField;

    @FXML
    void searchBooks(ActionEvent event) {
        bookContainer.getChildren().clear();

        String searchString = searchField.getText();

        List<Book> bookResults = librarian.searchBooks(new BookFilter(searchString));
        for (Book bookResult : bookResults) {
            bookContainer.getChildren().add(new Label(bookResult.getTitle()));
        }

    }

    public void init() {
        this.librarian = App.LIBRARY.getLibrarian();
    }
}