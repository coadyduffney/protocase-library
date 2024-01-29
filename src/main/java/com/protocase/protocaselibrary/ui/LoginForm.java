package com.protocase.protocaselibrary.ui;

import com.protocase.protocaselibrary.App;
import com.protocase.protocaselibrary.fundamental.User;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;

import java.util.UUID;

public class LoginForm extends Dialog<Boolean> {

    public LoginForm() {
        setTitle("Login");
        initOwner(App.WINDOW);
        initModality(Modality.WINDOW_MODAL);
        setOnCloseRequest(e -> hide());
        setResizable(false);

        initUI();
    }

    private void initUI() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 0);

        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Enter your email");
        emailTextField.setText("cduffney@protocase.com");
        GridPane.setConstraints(emailTextField, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setText("password");
        GridPane.setConstraints(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        gridPane.getChildren().addAll(emailLabel, emailTextField, passwordLabel, passwordField, loginButton);

        loginButton.setOnAction(e -> handleLogin(emailTextField.getText(), passwordField.getText()));

        getDialogPane().setContent(gridPane);
    }

    private void handleLogin(String email, String password) {
        if (email.equals("cduffney@protocase.com") && password.equals("password")) {
            User user = new User(UUID.randomUUID().toString(),
                    "Coady",
                    "Duffney",
                    "cduffney@protocase.com"
            );
            App.LIBRARY.logIn(user);
            setResult(true);
        }
    }

}
