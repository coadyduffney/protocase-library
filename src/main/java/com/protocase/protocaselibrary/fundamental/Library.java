package com.protocase.protocaselibrary.fundamental;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.protocase.protocaselibrary.interactive.Librarian;
import com.protocase.protocaselibrary.management.BookLog;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Coady Duffney
 */
public class Library {
    private List<Book> bookCollection;
    private BookLog bookLog;

    public Library() {
        bookLog = new BookLog();
        initializeInventory();
    }

    private void initializeInventory() {
        this.bookCollection = new ArrayList<>();

        Gson gson = new Gson();
        Type bookListType = new TypeToken<List<Book>>() {}.getType();

        try (InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("database.json"))) {
            this.bookCollection = gson.fromJson(reader, bookListType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
