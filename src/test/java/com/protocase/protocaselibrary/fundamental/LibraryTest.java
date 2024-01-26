package com.protocase.protocaselibrary.fundamental;

import com.protocase.protocaselibrary.interactive.BookFilter;
import com.protocase.protocaselibrary.interactive.UserSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    /**
     * -- WORK FLOWS --
     * 1. LOAD INVENTORY FROM A TEXT FILE
     * 2. LOG USER IN / LOG USER OUT
     * 3. SEARCH / FILTER BOOKS.
     *      - Title
     *      - Author
     *      - ISBN
     *      - Genre
     *      - Location
     * 4. CHECKOUT BOOKS.
     */

    @Test
    void testLoadInventory() {
        Library library = new Library();
        List<Book> inventory = library.getInventory();
        assertFalse(inventory.isEmpty());
    }

    @Test
    void testUserLogIn() {
        Library library = new Library();

        User user = new User(UUID.randomUUID().toString(),
                "Coady",
                "Duffney",
                "cduffney@protocase.com");
        library.logIn(user);

        assertNotNull(UserSession.getInstance().getUser());
    }

    @Test
    void testUserLogOut() {
        Library library = new Library();

        User user = new User(UUID.randomUUID().toString(),
                "Coady",
                "Duffney",
                "cduffney@protocase.com");
        library.logIn(user);

        library.logOut();
        assertNull(UserSession.getInstance().getUser());
    }

    @Test
    void testSearchBookByTitle() {
        Library library = new Library();

        BookFilter filter = new BookFilter()
                .withTitleFilter("The Hobbit")
                .build();

        List<Book> books = library.searchBooks(filter);
        assertFalse(books.isEmpty());
    }

    @Test
    void testSearchBookByAuthor() {
        Library library = new Library();

        BookFilter filter = new BookFilter()
                .withAuthorFilter("J.D. Salinger")
                .build();

        List<Book> books = library.searchBooks(filter);
        assertFalse(books.isEmpty());
    }

    @Test
    void testSearchBookByIsbn() {
        Library library = new Library();

        BookFilter filter = new BookFilter()
                .withIsbnFilter("978-0-06-112008-4")
                .build();

        List<Book> books = library.searchBooks(filter);
        assertFalse(books.isEmpty());
    }

    @Test
    void testSearchBookByGenre() {
        Library library = new Library();

        BookFilter filter = new BookFilter()
                .withGenreFilter("Classics")
                .build();

        List<Book> books = library.searchBooks(filter);
        assertFalse(books.isEmpty());
        assertEquals(2, books.size());
    }

    @Test
    void testSearchBookByLocation() {
        Library library = new Library();

        BookFilter filter = new BookFilter()
                .withLocationFilter("Shelf B")
                .build();

        List<Book> books = library.searchBooks(filter);
        assertFalse(books.isEmpty());
        assertEquals(2, books.size());
    }
}