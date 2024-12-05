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
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.model.OtpRequest;
import com.example.bansach.model.OtpResponse;

import org.json.JSONException;
import org.json.JSONObject;

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
                    Intent intent = new Intent(FogotPassPage.this, ResetPass.class);
                    startActivity(intent);
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


        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        // Tạo request gửi đi
        Call<Void> call = apiService.sendOtp();
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Xử lý thành công
                    Log.d("API Response", "OTP sent successfully");
                    Toast.makeText(getApplicationContext(), "OTP sent successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Xử lý lỗi
                    Log.e("API Error", "Error: " + response.code());
                    Toast.makeText(getApplicationContext(), "Failed to send OTP", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Xử lý khi có lỗi kết nối
                Log.e("API Failure", "Error: " + t.getMessage());
                Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}