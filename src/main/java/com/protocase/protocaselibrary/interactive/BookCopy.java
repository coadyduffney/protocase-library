package com.protocase.protocaselibrary.interactive;

import com.protocase.protocaselibrary.fundamental.Book;

import java.util.UUID;

/**
 * @author Coady Duffney
 */
public class BookCopy {
    private String id;
    private final Book originalBook;
    private String userId;
    private String checkInDate;
    private String checkOutDate;

    public BookCopy(Book book) {
        this.id = UUID.randomUUID().toString();
        this.originalBook = book;
        this.checkInDate = "";
        this.checkOutDate = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getOriginal() {
        return originalBook;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
