package com.protocase.protocaselibrary.ui;

import com.protocase.protocaselibrary.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CartView extends Stage {
    private CartViewController controller;

    public CartView() {
        setTitle("Cart");
        initOwner(App.WINDOW);
        initModality(Modality.WINDOW_MODAL);
        setOnCloseRequest(e -> hide());
        setResizable(false);

        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cartView.fxml"));
            BorderPane borderPane = fxmlLoader.load();
            controller = fxmlLoader.getController();
            controller.init(this);

            setScene(new Scene(borderPane));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
