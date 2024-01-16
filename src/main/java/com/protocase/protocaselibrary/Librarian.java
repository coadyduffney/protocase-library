package com.protocase.protocaselibrary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Librarian {
    private static final String FETCH_BOOKS = "https://freetestapi.com/api/v1/books";

    public static List<Book> fetchBooks() {
        List<Book> books = new ArrayList<>();

        try {
            // Specify the URL you want to send the GET request to
            URL url = new URL(FETCH_BOOKS);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Print the response
            System.out.println("Response: " + response.toString());

            ObjectMapper objectMapper = new ObjectMapper();
            books = objectMapper.readValue(response.toString(), new TypeReference<List<Book>>() {
            });

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

}
