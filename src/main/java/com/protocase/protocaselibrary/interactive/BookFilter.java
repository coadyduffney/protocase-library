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
    public BookFilter(String stringToFilter) {
        filterStrategies.add(new TitleBookFilterStrategy(stringToFilter));
        filterStrategies.add(new AuthorBookFilterStrategy(stringToFilter));
        filterStrategies.add(new IsbnBookFilterStrategy(stringToFilter));
        filterStrategies.add(new GenreBookFilterStrategy(stringToFilter));
        filterStrategies.add(new LocationBookFilterStrategy(stringToFilter));
    }

    public boolean matches(Book book) {
        return filterStrategies
                .stream()
                .anyMatch(abstractBookFilterStrategy -> abstractBookFilterStrategy.checkMatch(book));
    }
}
