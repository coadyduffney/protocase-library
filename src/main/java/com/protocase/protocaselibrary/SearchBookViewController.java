package com.protocase.protocaselibrary;

import com.protocase.protocaselibrary.components.BookCard;
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
//        bookContainer.setAlignment();

        List<Book> bookList = Librarian.fetchBooks();
        bookList.forEach(book -> {
            System.out.println(book.getTitle());
            System.out.println(book.getCover_image());
            BookCard card = new BookCard(book);
            bookContainer.getChildren().add(card);
        });
    }

    @FXML
    void onSearch(ActionEvent event) {

    }
}
