package com.protocase.protocaselibrary;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Stage WINDOW;

    @Override
    public void start(Stage stage) throws IOException {
        WINDOW = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("appView.fxml"));
        BorderPane borderPane = fxmlLoader.load();
        AppController controller = fxmlLoader.getController();
        controller.init();

        stage.getIcons().add(new Image(
                getClass().getResourceAsStream("/images/favicon-32x32.png")
        ));

        Scene scene = new Scene(borderPane, 1150, 850);
        stage.setTitle("ProtoBooks");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        Platform.runLater(borderPane::requestFocus);
    }

    public static void main(String[] args) {
        launch();
    }
}