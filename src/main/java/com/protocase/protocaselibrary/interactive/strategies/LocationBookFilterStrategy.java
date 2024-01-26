package com.protocase.protocaselibrary.interactive.strategies;

import com.protocase.protocaselibrary.fundamental.Book;

/**
 * @author Coady Duffney
 */
public class LocationBookFilterStrategy extends AbstractBookFilterStrategy {

    public LocationBookFilterStrategy(String fieldValue) {
        super(fieldValue);
    }

    @Override
    public boolean checkMatch(Book book) {
        String location = book.getLocation().toLowerCase();
        return location.contains(getSearchString().toLowerCase());
    }
}
