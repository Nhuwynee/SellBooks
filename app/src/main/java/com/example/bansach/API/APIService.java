package com.example.bansach.API;

import com.example.bansach.model.Book1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    // Định nghĩa phương thức gọi API
    @GET("connect.php") // Thay 'books' bằng đường dẫn API thực tế của bạn
    Call<List<Book1>> getBooks();
}
