package com.protocase.protocaselibrary.fundamental;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Coady Duffney
 */
public class BookInventory {
    private List<Book> books = new ArrayList<>();

    public BookInventory() {
        initialize();
    }

    private void initialize() {
        Gson gson = new Gson();
        Type bookListType = new TypeToken<List<Book>>() {}.getType();

        try (InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("database.json"))) {
            this.books = gson.fromJson(reader, bookListType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

}
