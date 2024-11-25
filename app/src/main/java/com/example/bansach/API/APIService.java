package com.example.bansach.API;

import com.example.bansach.model.Book1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("bookapi.php")  // Fetch books
    Call<List<Book1>> getBooks();

    @GET("bookapi.php")
    Call<Book1> getBookDetails(@Query("id") String bookId);

    @GET("bookapi.php")
    Call<List<Book1>> getBooksByCategory(@Query("category") String category);

    @GET("categories")  // Endpoint to fetch categories
    Call<List<String>> getCategories();

}


