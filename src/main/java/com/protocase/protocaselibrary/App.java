package com.protocase.protocaselibrary;

import com.protocase.protocaselibrary.fundamental.Library;
import com.protocase.protocaselibrary.fundamental.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;

public class App extends Application {
    public static final Library LIBRARY = new Library();

    @Override
    public void start(Stage stage) throws IOException {
        User user = new User(UUID.randomUUID().toString(),
                "Coady",
                "Duffney",
                "cduffney@protocase.com"
        );
        LIBRARY.logIn(user);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("appView.fxml"));
        BorderPane borderPane = fxmlLoader.load();
        AppController controller = fxmlLoader.getController();
        controller.init();

        Scene scene = new Scene(borderPane);
        stage.setTitle("Protocase Library");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        Platform.runLater(borderPane::requestFocus);
    }

    public static void main(String[] args) {
        launch();
    }
}