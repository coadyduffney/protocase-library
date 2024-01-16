package com.protocase.protocaselibrary;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class SearchBookView {
    private SearchBookViewController controller;
    private BorderPane component;

    public SearchBookView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchBooksView.fxml"));

        try {
            component = fxmlLoader.load();
            controller = fxmlLoader.getController();
            controller.init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BorderPane getComponent() {
        return component;
    }

    public SearchBookViewController getController() {
        return controller;
    }
}
