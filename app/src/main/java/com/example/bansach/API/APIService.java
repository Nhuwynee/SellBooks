package com.example.bansach.API;

import com.example.bansach.model.Book1;
import com.example.bansach.model.Cart;
import com.example.bansach.model.Cart1;
import com.example.bansach.model.LoginRequest;
import com.example.bansach.model.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @GET("bookapi.php")  // Fetch books
    Call<List<Book1>> getBooks();

    @GET("bookapi.php")
    Call<Book1> getBookDetails(@Query("id") String bookId);
    @POST("userapi.php") // Thay "login" bằng endpoint của bạn
    Call<List<LoginResponse>> login(@Body LoginRequest loginRequest);
    @GET("cartapi.php") // Thay 'books' bằng đường dẫn API thực tế của bạn
    Call<List<Cart>> getBooksbyIdUser(@Query("id") int idUser);
    @POST("add_to_cart.php")
    Call<Void> addToCart(@Body Cart1 cart);

    @GET("bookapi.php")
    Call<List<Book1>> getBooksByCategory(@Query("category") String category);

    @GET("categories")  // Endpoint to fetch categories
    Call<List<String>> getCategories();

}


