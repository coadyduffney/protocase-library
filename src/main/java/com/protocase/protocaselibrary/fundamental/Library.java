package com.protocase.protocaselibrary.fundamental;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.protocase.protocaselibrary.interactive.BookFilter;
import com.protocase.protocaselibrary.interactive.Librarian;
import com.protocase.protocaselibrary.interactive.UserSession;
import com.protocase.protocaselibrary.management.BookLog;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Coady Duffney
 */
public class Library {
    private List<Book> inventory;
    private BookLog bookLog;

    private Librarian librarian;

    public Library() {
        bookLog = new BookLog();
        librarian = new Librarian();
        initializeInventory();
    }

    public void logIn(User user) {
        UserSession.getInstance().setUser(user);
    }

    public void logOut() {
        UserSession.getInstance().setUser(null);
    }

    private void initializeInventory() {
        this.inventory = new ArrayList<>();

        Gson gson = new Gson();
        Type bookListType = new TypeToken<List<Book>>() {}.getType();

        try (InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("database.json"))) {
            this.inventory = gson.fromJson(reader, bookListType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getInventory() {
        return new ArrayList<>(inventory);
    }

    public List<Book> searchBooks(BookFilter bookFilter) {
        return librarian.searchBooks(bookFilter);
    }
}
