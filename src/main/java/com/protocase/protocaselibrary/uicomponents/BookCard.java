package com.protocase.protocaselibrary.uicomponents;

import com.protocase.protocaselibrary.fundamental.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class BookCard {
    private final VBox node;
    private BookCardController controller;

    public BookCard(Book book) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bookCard.fxml"));
            node = fxmlLoader.load();
            controller = fxmlLoader.getController();
            controller.init(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public VBox getNode() {
        return node;
    }

}
