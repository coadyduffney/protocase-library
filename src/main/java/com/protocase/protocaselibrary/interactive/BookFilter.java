package com.protocase.protocaselibrary.interactive;

import com.protocase.protocaselibrary.fundamental.Book;
import com.protocase.protocaselibrary.interactive.strategies.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Coady Duffney
 */
public class BookFilter {
    private final List<AbstractBookFilterStrategy> filterStrategies = new ArrayList();

    public BookFilter() {

    }

    public BookFilter withTitleFilter(String title) {
        filterStrategies.add(new TitleBookFilterStrategy(title));
        return this;
    }

    public BookFilter withAuthorFilter(String author) {
        filterStrategies.add(new AuthorBookFilterStrategy(author));
        return this;
    }

    public BookFilter withIsbnFilter(String isbn) {
        filterStrategies.add(new IsbnBookFilterStrategy(isbn));
        return this;
    }

    public BookFilter withGenreFilter(String genre) {
        filterStrategies.add(new GenreBookFilterStrategy(genre));
        return this;
    }

    public BookFilter withLocationFilter(String location) {
        filterStrategies.add(new LocationBookFilterStrategy(location));
        return this;
    }

    public BookFilter build() {
        return this;
    }

    public boolean matches(Book book) {
        return filterStrategies.stream()
                .anyMatch(abstractBookFilterStrategy -> abstractBookFilterStrategy.checkMatch(book));
    }
}
