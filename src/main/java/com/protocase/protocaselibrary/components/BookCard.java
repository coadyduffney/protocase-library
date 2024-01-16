package com.protocase.protocaselibrary.components;

import com.protocase.protocaselibrary.Book;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BookCard extends VBox {
    private Book book;
    private Label titleLabel = new Label();
    private Label authorLabel = new Label();
    private Label descriptionLabel = new Label();
    private ImageView imageView = new ImageView();


    public BookCard(Book book) {
        this.book = book;

        titleLabel.setText(book.getTitle());
        authorLabel.setText(book.getAuthor());
        descriptionLabel.setText(book.getDescription());
        imageView.setImage(new Image(book.getCover_image()));
        imageView.setFitHeight(200);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        setAlignment(Pos.CENTER);
        getChildren().addAll(
                titleLabel,
                imageView,
                authorLabel,
                descriptionLabel
        );
    }



}
