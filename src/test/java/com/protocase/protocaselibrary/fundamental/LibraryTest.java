package com.protocase.protocaselibrary.fundamental;

import com.protocase.protocaselibrary.interactive.BookCopy;
import com.protocase.protocaselibrary.interactive.BookFilter;
import com.protocase.protocaselibrary.interactive.UserSession;
import com.protocase.protocaselibrary.management.Cart;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    /**
     * -- WORK FLOWS --
     * 1. LOAD INVENTORY FROM A TEXT FILE
     * 2. LOG USER IN / LOG USER OUT
     * 3. SEARCH / FILTER BOOKS.
         * - Title
         * - Author
         * - ISBN
         * - Genre
         * - Location
     * 4. CHECK OUT BOOKS.
     * 5. CHECK IN BOOKS
     */

    @Test
    void testLoadInventory() {
        Library library = Library.getInstance();
        List<Book> inventory = library.getInventory().getBooks();
        assertFalse(inventory.isEmpty());
    }

    @Test
    void testUserLogIn() {
        Library library = Library.getInstance();
        library.logIn(new TestUser());
        assertNotNull(UserSession.getInstance().getUser());
    }

    @Test
    void testUserLogOut() {
        Library library = Library.getInstance();
        library.logIn(new TestUser());

        library.logOut();
        assertNull(UserSession.getInstance().getUser());
    }

    @Test
    void testSearchBookByTitle() {
        Library library = Library.getInstance();
        BookFilter filter = new BookFilter("The Hobbit");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        assertFalse(books.isEmpty());
    }

    @Test
    void testSearchBookByAuthor() {
        Library library = Library.getInstance();

        BookFilter filter = new BookFilter("J.D. Salinger");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        assertFalse(books.isEmpty());
    }

    @Test
    void testSearchBookByIsbn() {
        Library library = Library.getInstance();

        BookFilter filter = new BookFilter("978-0-06-112008-4");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        assertFalse(books.isEmpty());
    }

    @Test
    void testSearchBookByGenre() {
        Library library = Library.getInstance();

        BookFilter filter = new BookFilter("Classics");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        assertFalse(books.isEmpty());
        assertEquals(2, books.size());
    }

    @Test
    void testSearchBookByLocation() {
        Library library = Library.getInstance();

        BookFilter filter = new BookFilter("Shelf B");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        assertFalse(books.isEmpty());
        assertEquals(2, books.size());
    }

    @Test
    void testAddBookToCart() {
        Library library = Library.getInstance();
        library.logIn(new TestUser());

        BookFilter filter = new BookFilter("The Lord of the Rings");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        Book book = books.get(0);

        Cart cart = Cart.getInstance();
        cart.getBooks().clear();

        cart.addBook(new BookCopy(book));
        assertEquals(1, cart.getBooks().size());
    }

    @Test
    void testRemoveBookFromCart() {
        Library library = Library.getInstance();
        library.logIn(new TestUser());

        BookFilter filter = new BookFilter("The Lord of the Rings");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        Book book = books.get(0);
        BookCopy bookCopy = new BookCopy(book);

        Cart cart = Cart.getInstance();
        cart.getBooks().clear();

        cart.addBook(bookCopy);
        assertEquals(1, cart.getBooks().size());

        cart.removeBook(bookCopy);
        assertTrue(cart.getBooks().isEmpty());
    }

    @Test
    void testCheckoutBook() {
        Library library = Library.getInstance();
        library.getBookLog().getHistory().clear();

        library.logIn(new TestUser());

        BookFilter filter = new BookFilter("The Lord of the Rings");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        Book book = books.get(0);
        BookCopy bookCopy = new BookCopy(book);

        Cart cart = Cart.getInstance();
        cart.addBook(bookCopy);

        List<BookCopy> history = library.getBookLog().getHistory();
        assertEquals(0, history.size());

        library.checkOutBooks(cart.getBooks());
        assertEquals(1, history.size());

        BookCopy bookLogEntry = history.get(0);
        String checkInDate = bookLogEntry.getCheckInDate();
        String checkOutDate = bookLogEntry.getCheckOutDate();

        assertFalse(checkInDate.isEmpty());
        assertFalse(checkOutDate.isEmpty());
    }

    @Test
    void testCheckInBook() {
        Library library = Library.getInstance();
        library.getBookLog().getHistory().clear();

        TestUser user = new TestUser();
        library.logIn(user);

        BookFilter filter = new BookFilter("The Lord of the Rings");

        List<Book> books = library.getLibrarian().searchBooks(filter);
        Book book = books.get(0);
        BookCopy bookCopy = new BookCopy(book);

        Cart cart = Cart.getInstance();
        cart.addBook(bookCopy);

        List<BookCopy> history = library.getBookLog().getHistory();
        assertEquals(0, history.size());

        library.checkOutBooks(cart.getBooks());

        List<BookCopy> historyForUser = library.getBookLog().getHistoryForUser(user);
        assertEquals(1, historyForUser.size());

        library.checkInBooks(historyForUser);

        historyForUser = library.getBookLog().getHistoryForUser(user);
        assertEquals(0, historyForUser.size());
    }

}