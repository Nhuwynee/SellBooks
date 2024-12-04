package com.example.bansach;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.API.APIService;
import com.example.bansach.model.OtpRequest;

public class FogotPassPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass);
        Button sendOtpButton = findViewById(R.id.btn_signup);
        final EditText phoneNumberEditText = findViewById(R.id.sdt1);

        sendOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                if (!phoneNumber.isEmpty()) {
                    // Gọi API gửi OTP
                    savePhoneNumberToSharedPreferences(phoneNumber);
                    sendOtpToServer(phoneNumber);
//                    Intent intent = new Intent(FogotPassPage.this, ResetPass.class);
//                    startActivity(intent);
                } else {
                    Toast.makeText(FogotPassPage.this, "Vui lòng nhập số điện thoại.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void savePhoneNumberToSharedPreferences(String phoneNumber) {
        SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCES_FILE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PHONE_NUMBER_KEY", phoneNumber);  // Lưu số điện thoại vào SharedPreferences
        editor.apply();  // Áp dụng thay đổi
    }
    public void sendOtpToServer(String phoneNumber) {
        // Khởi tạo Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.5.237:8080/READIFY/")  // Thay "your-server-url" bằng URL thực tế của bạn
                .addConverterFactory(GsonConverterFactory.create()) // Sử dụng Gson để chuyển đổi JSON
                .build();

        APIService apiService = retrofit.create(APIService.class);

        // Tạo request gửi đi
        OtpRequest otpRequest = new OtpRequest(phoneNumber);

        // Gửi yêu cầu POST
        Call<String> call = apiService.sendOtp(otpRequest);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    // Xử lý nếu phản hồi thành công
                    Log.d("SendOtp", "OTP sent successfully: " + response.body());
                    Toast.makeText(FogotPassPage.this, "Mã OTP đã được gửi!", Toast.LENGTH_SHORT).show();
                } else {
                    // Xử lý nếu có lỗi từ server
                    Log.e("SendOtp", "Failed to send OTP: " + response.message());
                    Toast.makeText(FogotPassPage.this, "Gửi OTP thất bại: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // Xử lý khi có lỗi kết nối hoặc yêu cầu không thành công
                Log.e("SendOtp", "Error: " + t.getMessage());

                Toast.makeText(FogotPassPage.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}