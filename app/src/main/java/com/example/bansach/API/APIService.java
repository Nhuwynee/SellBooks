package com.example.bansach.API;

import com.example.bansach.model.Book1;
import com.example.bansach.model.Cart;
import com.example.bansach.model.Cart1;
import com.example.bansach.model.LoginRequest;
import com.example.bansach.model.LoginResponse;
import com.example.bansach.model.Order;
import com.example.bansach.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
// Fetch books
public interface APIService {
    @GET("bookapi.php")
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
// Lưu Ngọc Yến Như
    @GET("categories")  // Endpoint to fetch categories
    Call<List<String>> getCategories();

    @GET("favouritebookapi.php")
    Call<List<Book1>> getFavouriteBooks(@Query("idUser") int idUser);

    @GET("orderapi.php")
    Call<List<Order>> getOrderHistory();

    @GET("orderapi.php") // Thay bằng endpoint API của bạn
    Call<List<Order>> getOrderHistoryByUser(@Query("idUser") int idUser);

    @GET("buyedaudio.php")
    Call<List<Book1>> getBuyedAudio(@Query("idUser") int idUser);

    @GET("getuser.php")
    Call<User> getUserById(@Query("idUser") int idUser);

    @POST("updateuser.php")
    Call<Void> updateUser(@Body User user);
}


