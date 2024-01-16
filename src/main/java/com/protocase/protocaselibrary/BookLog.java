package com.protocase.protocaselibrary;

public class BookLog {
    private String id;
    private String bookId;
    private String userId;
    private String checkOutDate;
    private String checkInDate;
    private String dueDate;

    public BookLog(String id, String bookId, String userId, String checkOutDate, String checkInDate, String dueDate) {
        this.id=id;
        this.bookId = bookId;
        this.userId = userId;
        this.checkOutDate = checkOutDate;
        this.checkInDate = checkInDate;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
