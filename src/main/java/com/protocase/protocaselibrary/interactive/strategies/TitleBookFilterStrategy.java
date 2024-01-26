package com.protocase.protocaselibrary.interactive.strategies;

import com.protocase.protocaselibrary.fundamental.Book;

/**
 * @author Coady Duffney
 */
public class TitleBookFilterStrategy extends AbstractBookFilterStrategy {
    public TitleBookFilterStrategy(String valueToFilter) {
        super(valueToFilter);
    }

    @Override
    public boolean checkMatch(Book book) {
        String bookTitle = book.getTitle().toLowerCase();
        return bookTitle.contains(getSearchString().toLowerCase());
    }
}
