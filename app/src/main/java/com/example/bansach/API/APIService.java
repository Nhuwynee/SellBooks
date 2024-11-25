package com.example.bansach.API;

import com.example.bansach.model.Book1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    // Định nghĩa phương thức gọi API
    @GET("bookapi.php") // Thay 'books' bằng đường dẫn API thực tế của bạn
    Call<List<Book1>> getBooks();
    @GET("bookapi.php")
    Call<Book1> getBookDetails(@Query("id") String bookId);

}
