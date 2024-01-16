package com.protocase.protocaselibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class ProtocaseLibraryApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProtocaseLibraryApp.class.getResource("hello-view.fxml"));
        BorderPane borderPane = fxmlLoader.load();
        ProtocaseLibraryAppController controller = fxmlLoader.getController();
        controller.init();

        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Protocase Library");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}