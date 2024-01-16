package com.protocase.protocaselibrary;

public class Book {
    private double id;
    private String title;
    private String author;
    private String description;
    private String cover_image;

    private String publication_year;
    private String isbn;
    private String[] genre;
    private String location;

    public Book() {

    }

    public Book(double id, String title, String author, String description, String cover_image, String publication_year, String isbn, String[] genre, String location) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.cover_image = cover_image;
        this.publication_year = publication_year;
        this.isbn = isbn;
        this.genre = genre;
        this.location = location;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }
}
