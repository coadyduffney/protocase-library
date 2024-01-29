package com.protocase.protocaselibrary;

import com.dukescript.layouts.flexbox.FlexboxLayout;
import com.dukescript.layouts.jfxflexbox.FlexBoxPane;
import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.interactive.BookFilter;
import com.protocase.protocaselibrary.interactive.Librarian;
import com.protocase.protocaselibrary.management.Cart;
import com.protocase.protocaselibrary.uicomponents.BookCard;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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
    private Label cartItemsBadge;

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
    private FlexBoxPane bookGrid;

    public void init() {
        // Set up Librarian
        this.librarian = App.LIBRARY.getLibrarian();

        // Bind our number of cart items to our label badge inside Cart button.
        cartItemsBadge.textProperty().bind(Bindings.size(Cart.getInstance().getBooks()).asString());

        // Set up the responsive book grid.
        initializeBookGrid();
    }

    private void initializeBookGrid() {
        bookGrid = new FlexBoxPane();
        bookGrid.setAlignContent(FlexboxLayout.ALIGN_CONTENT_CENTER);
        bookGrid.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);
        bookGrid.setFlexWrap(FlexboxLayout.FLEX_WRAP_WRAP);
        mainBorderPane.setCenter(bookGrid);

        List<Book> books = App.LIBRARY.getInventory().getBooks();
        populateBookGrid(books);
    }

    @FXML
    void searchBooks(ActionEvent event) {
        bookGrid.getChildren().clear();

        String searchString = searchField.getText();
        List<Book> searchResults = librarian.searchBooks(new BookFilter(searchString));
        populateBookGrid(searchResults);
    }

    private void populateBookGrid(List<Book> books) {
        for (Book book : books) {
            BookCard bookCard = new BookCard(book);
            VBox node = bookCard.getNode();

            FlexBoxPane.setMargin(node, new Insets(5));
            bookGrid.getChildren().add(node);
        }
    }
}