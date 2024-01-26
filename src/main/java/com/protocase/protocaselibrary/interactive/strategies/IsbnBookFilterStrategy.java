package com.protocase.protocaselibrary.interactive.strategies;

import com.protocase.protocaselibrary.fundamental.Book;

/**
 * @author Coady Duffney
 */
public class IsbnBookFilterStrategy extends AbstractBookFilterStrategy {

    public IsbnBookFilterStrategy(String fieldValue) {
        super(fieldValue);
    }

    @Override
    public boolean checkMatch(Book book) {
        String isbn = book.getIsbn().toLowerCase();
        return isbn.contains(getSearchString().toLowerCase());
    }
}
