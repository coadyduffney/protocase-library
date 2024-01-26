package com.protocase.protocaselibrary.interactive.strategies;

import com.protocase.protocaselibrary.fundamental.Book;

/**
 * @author Coady Duffney
 */
public class GenreBookFilterStrategy extends AbstractBookFilterStrategy {

    public GenreBookFilterStrategy(String fieldValue) {
        super(fieldValue);
    }

    @Override
    public boolean checkMatch(Book book) {
        String genre = book.getGenre().toLowerCase();
        return genre.contains(getSearchString().toLowerCase());
    }
}
