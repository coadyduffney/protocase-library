package com.protocase.protocaselibrary.uicomponents;

import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.management.Cart;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class CartViewController {

    @FXML
    private VBox booksContainer;


    public void init() {
        refresh();
    }

    public void refresh() {
        booksContainer.getChildren().clear();

        ObservableList<BookCopy> books = Cart.getInstance().getBooks();
        for (BookCopy book : books) {
            booksContainer.getChildren().add(new BookCartItemContainer(book, this).getNode());
        }
    }
}
