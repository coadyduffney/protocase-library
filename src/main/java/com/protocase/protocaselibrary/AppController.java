package com.protocase.protocaselibrary;

import com.dukescript.layouts.flexbox.FlexboxLayout;
import com.dukescript.layouts.jfxflexbox.FlexBoxPane;
import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.fundamental.Library;
import com.protocase.protocaselibrary.interactive.BookFilter;
import com.protocase.protocaselibrary.interactive.Librarian;
import com.protocase.protocaselibrary.interactive.UserSession;
import com.protocase.protocaselibrary.management.Cart;
import com.protocase.protocaselibrary.ui.*;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.List;
import java.util.Optional;

public class AppController {
    private Librarian librarian;

    @FXML
    private Label cartItemsBadge;
    @FXML
    private Button logInButton;
    @FXML
    private FontIcon logInIcon;
    @FXML
    private Button profileButton;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextField searchField;
    private FlexBoxPane bookGrid;

    public void init() {
        // Set up Librarian
        this.librarian = Library.getInstance().getLibrarian();

        profileButton.setVisible(false);
        profileButton.setManaged(false);

        // Set up key listener on searchField
        searchField.setOnKeyTyped(keyEvent -> {
            searchBooks();
        });

        // Bind our number of cart items to our label badge inside Cart button.
        cartItemsBadge.textProperty().bind(Bindings.size(Cart.getInstance().getBooks()).asString());

        // Add listener to our LoggedInProperty of UserSession
        UserSession.getInstance().getUserLoggedInProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                logInButton.setText("Log Out");
                logInIcon.setIconLiteral("fas-sign-out-alt");
                userNameLabel.setText("Welcome, " + UserSession.getInstance().getUser().getFirstName());
                profileButton.setVisible(true);
                profileButton.setManaged(true);
            } else {
                logInButton.setText("Log In");
                logInIcon.setIconLiteral("fas-sign-in-alt");
                userNameLabel.setText("");
                profileButton.setVisible(false);
                profileButton.setManaged(false);
            }
        });

        // Set up the responsive book grid.
        initializeBookGrid();
    }

    private void initializeBookGrid() {
        bookGrid = new FlexBoxPane();
        bookGrid.setAlignContent(FlexboxLayout.ALIGN_CONTENT_CENTER);
        bookGrid.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);
        bookGrid.setFlexWrap(FlexboxLayout.FLEX_WRAP_WRAP);
        mainBorderPane.setCenter(bookGrid);

        List<Book> books = Library.getInstance().getInventory().getBooks();
        populateBookGrid(books);
    }

    @FXML
    void searchBooks() {
        bookGrid.getChildren().clear();

        String searchString = searchField.getText();
        List<Book> searchResults = librarian.searchBooks(new BookFilter(searchString));
        populateBookGrid(searchResults);
    }

    @FXML
    void onProfile() {
        ProfileView profileView = new ProfileView();
        profileView.show();
    }

    @FXML
    void openCart() {
        CartView cartView = new CartView();
        cartView.show();
    }

    @FXML
    void onLoginLogout() {
        if (UserSession.getInstance().isUserLoggedIn()) {
            handleLogOut();
        } else {
            handleLogIn();
        }
    }

    private void handleLogOut() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Log Out?");
        confirm.setContentText("Are you sure you want to log out?");
        Optional<ButtonType> buttonType = confirm.showAndWait();

        if (buttonType.isPresent() && buttonType.get() == ButtonType.OK) {
            NotificationHelper.showLogOutNotification();
            Library.getInstance().logOut();
        }
    }

    private void handleLogIn() {
        Optional<Boolean> loginResult = new LoginForm().showAndWait();
        if (loginResult.isPresent() && loginResult.get()) {
            NotificationHelper.showLogInNotification();
        }
    }

    private void populateBookGrid(List<Book> books) {

        if (books.isEmpty()) {
            // show no results found.
            Label label = new Label("No results found");
            label.setFont(new Font("Segoe UI", 24));
            HBox labelContainer = new HBox();
            labelContainer.setAlignment(Pos.CENTER);
            labelContainer.getChildren().add(label);

            bookGrid.getChildren().add(labelContainer);

        } else {
            for (Book book : books) {
                BookCard bookCard = new BookCard(book);
                VBox node = bookCard.getNode();

                FlexBoxPane.setMargin(node, new Insets(5));
                bookGrid.getChildren().add(node);
            }
        }

    }
}