package com.example.bansach.API;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;

    // HIẾU
    // private static final String BASE_URL = "http://192.168.138.1:8080/SellBooks/";

    // NHƯ:
    private static final String BASE_URL = "http://192.168.206.1:8080/READIFY/";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
