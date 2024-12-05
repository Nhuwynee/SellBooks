package com.example.bansach.API;

import com.example.bansach.model.Book1;
import com.example.bansach.model.Cart;
import com.example.bansach.model.Cart1;
import com.example.bansach.model.FavouriteBook;
import com.example.bansach.model.LoginRequest;
import com.example.bansach.model.LoginResponse;
import com.example.bansach.model.NewPassRequest;
import com.example.bansach.model.Order;
import com.example.bansach.model.OrderDetail;
import com.example.bansach.model.OrderRequest;
import com.example.bansach.model.OrderResponse;
import com.example.bansach.model.Order_User;
import com.example.bansach.model.OtpRequest;
import com.example.bansach.model.OtpResponse;
import com.example.bansach.model.User;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
// Fetch books

public interface APIService {

    @GET("bookapi.php")
    Call<List<Book1>> getBooks();

    @GET("bookapi.php")
    Call<Book1> getBookDetails(@Query("id") String bookId);
    @POST("userapi.php")
    Call<List<User>> getUser(@Query("id") int IdUser);

    @POST("userapi.php")
    Call<List<LoginResponse>> login(@Body LoginRequest loginRequest);

    @GET("cartapi.php")
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

//    @GET("order_confirmapi.php")
//    Call<Order> getOrder(@Query("idOrder") int idOrder);  // Sửa thành idOrder

    @GET("order_confirmapi.php")
    Call<Order_User> getOrder(@Query("IdUser") int idOrder);

    // Lịch sử đơn hàng
    @GET("orderapi.php")
    Call<List<Order>> getOrderHistoryByUser(@Query("idUser") int idUser);

    @GET("buyedaudioapi.php")
    Call<List<Book1>> getBuyedAudio(@Query("idUser") int idUser);

    @GET("getuserapi.php")
    Call<User> getUserById(@Query("idUser") int idUser);

    // đăng ký
    @POST("insertuserapi.php") // đăng ký
    Call<Void> registerUser(@Body User user);
    @POST("updateuserapi.php")
    Call<Void> updateUser(@Body User user);

    @DELETE("deletecartapi.php")
    Call<Void> deleteBookFromCart(@Query("idBook") int bookId, @Query("idUser") int userId);

    @POST("insertOrderapi.php")
    Call<Void> createOrder(@Body OrderRequest orderRequest);
    @GET("orderdetailapi.php")
    Call<List<OrderDetail>> getOrderbyId(@Query("idOrder") int idUser);

    @POST("addfavouritebookapi.php")
    Call<Void> addBookToFavourite(@Body FavouriteBook favouriteBook);

    @GET("deletefavouritebookapi.php")
    Call<Void> deleteFavouriteBook(@Query("idUser") int userId, @Query("idBook") String bookId);
    @GET("OTP.php")
    Call<Void> sendOtp();

    @POST("verifyOtp.php")  // URL API xác nhận OTP
    Call<String> verifyOtp(@Body OtpRequest otpRequest);
    @POST("update_password_api.php")
    Call<Void> updatePassword(@Body NewPassRequest newpass);

}


