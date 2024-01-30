package com.protocase.protocaselibrary.ui;

import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.management.Cart;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;

public class BookCartItemContainer {

    private final VBox node;
    private final BookCopy bookCopy;
    private final CartViewController cartViewController;

    public BookCartItemContainer(BookCopy bookCopy, CartViewController cartViewController) {
        this.bookCopy = bookCopy;
        this.cartViewController = cartViewController;

        node = buildView();
    }

    public VBox getNode() {
        return node;
    }

    private VBox buildView() {
        VBox container = new VBox();
        container.setSpacing(5.);
        container.setPadding(new Insets(5));

        HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.setPadding(new Insets(5));
        hBox.setPrefWidth(575);

        VBox imageContainer = new VBox();
        imageContainer.setAlignment(Pos.CENTER_LEFT);

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/images/book.png")));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
        imageContainer.getChildren().add(imageView);

        VBox detailsContainer = new VBox();
        detailsContainer.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(detailsContainer, Priority.ALWAYS);

        Label titleLabel = new Label(bookCopy.getOriginal().getTitle());
        titleLabel.setFont(Font.font("System", 14));

        Label authorLabel = new Label(bookCopy.getOriginal().getAuthor());
        Label genreLabel = new Label(bookCopy.getOriginal().getGenre());
        Label locationLabel = new Label(bookCopy.getOriginal().getLocation());
        detailsContainer.getChildren().addAll(
                titleLabel,
                authorLabel,
                genreLabel,
                locationLabel
        );

        VBox buttonContainer = new VBox();
        buttonContainer.setAlignment(Pos.CENTER_RIGHT);

        Button deleteBtn = new Button("Remove");
        deleteBtn.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        deleteBtn.setOnAction(ev -> deleteBookFromCart());

        FontIcon icon = new FontIcon();
        icon.setIconLiteral("fas-trash");
        icon.setIconColor(Color.WHITE);
        deleteBtn.setGraphic(icon);

        buttonContainer.getChildren().add(deleteBtn);

        hBox.getChildren().addAll(
                imageContainer, detailsContainer, buttonContainer
        );

        container.getChildren().addAll(
                hBox,
                new Separator()
        );

        return container;
    }

    private void deleteBookFromCart() {
        Cart.getInstance().removeBook(bookCopy);
        cartViewController.refresh();
    }

}
