package com.protocase.protocaselibrary.interactive.strategies;

import com.protocase.protocaselibrary.fundamental.Book;

/**
 * @author Coady Duffney
 */
public class AuthorBookFilterStrategy extends AbstractBookFilterStrategy {
    public AuthorBookFilterStrategy(String author) {
        super(author);
    }

    @Override
    public boolean checkMatch(Book book) {
        String bookAuthor = book.getAuthor().toLowerCase();
        return bookAuthor.toLowerCase().contains(getSearchString().toLowerCase());
    }
}
