package com.protocase.protocaselibrary.ui;

import com.protocase.protocaselibrary.App;
import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.interactive.UserSession;
import com.protocase.protocaselibrary.management.Cart;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Optional;

public class CartViewController {

    @FXML
    private VBox booksContainer;

    private CartView cartView;


    public void init(CartView cartView) {
        this.cartView = cartView;
        refresh();
    }

    public void refresh() {
        booksContainer.getChildren().clear();

        ObservableList<BookCopy> books = Cart.getInstance().getBooks();

        if (books.isEmpty()) {
            Label label = new Label("Your shopping cart is empty.");
            label.setFont(new Font("Segoe UI", 24));
            HBox labelContainer = new HBox();
            labelContainer.setAlignment(Pos.CENTER);
            labelContainer.getChildren().add(label);
            VBox.setVgrow(labelContainer, Priority.ALWAYS);

            booksContainer.getChildren().add(labelContainer);
        } else {
            for (BookCopy book : books) {
                booksContainer.getChildren().add(new BookCartItemContainer(book, this).getNode());
            }
        }
    }

    @FXML
    private void completeCheckout() {
        if (UserSession.getInstance().getUser() == null) {
            //prompt for login.
            LoginForm loginForm = new LoginForm();
            Optional<Boolean> loginResult = loginForm.showAndWait();

            if (loginResult.isPresent() && loginResult.get()) {
                finalizeCheckout();
            }
        } else {
            finalizeCheckout();
        }

    }

    private void finalizeCheckout() {
        App.LIBRARY.checkOutBooks(Cart.getInstance().getBooks());
        cartView.close();

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setHeaderText("Checkout Complete");
        successAlert.setContentText("Enjoy your new reads!");
        successAlert.show();
    }
}
