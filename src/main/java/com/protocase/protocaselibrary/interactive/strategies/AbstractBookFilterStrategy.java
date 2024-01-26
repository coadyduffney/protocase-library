package com.protocase.protocaselibrary.interactive.strategies;

import com.protocase.protocaselibrary.fundamental.Book;

/**
 * @author Coady Duffney
 */
public abstract class AbstractBookFilterStrategy {
    private final String searchString;

    protected AbstractBookFilterStrategy(String fieldValue) {
        this.searchString = fieldValue;
    }

    protected String getSearchString() {
        return searchString;
    }

    public abstract boolean checkMatch(Book book);
}
