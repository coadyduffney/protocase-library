package com.protocase.protocaselibrary.interactive;

/**
 * @author Coady Duffney
 */
public class BookCopy {
    private String id;
    private String bookId;
    private String userId;
    private String checkInDate;
    private String checkOutDate;

    public BookCopy(String id, String bookId, String userId, String checkInDate, String checkOutDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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
