package com.example.bansach;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.API.APIService;
import com.example.bansach.model.OtpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResetPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpass);

        SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCES_FILE", MODE_PRIVATE);
        String phoneNumberEditText = sharedPreferences.getString("PHONE_NUMBER_KEY", "");

        Button verifyOtpButton = findViewById(R.id.btn_signup);
        final EditText otpEditText = findViewById(R.id.otp1);

        verifyOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText;
                String otpCode = otpEditText.getText().toString();

                if (phoneNumber != null && !phoneNumber.isEmpty() && !otpCode.isEmpty()) {
                    verifyOtp(phoneNumber, otpCode);
                } else {
                    Toast.makeText(ResetPass.this, "Vui lòng nhập số điện thoại và mã OTP.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void verifyOtp(String phoneNumber, String otpCode) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.4.112:8080/READIFY/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        OtpRequest otpRequest = new OtpRequest(phoneNumber, otpCode);

        Call<String> call = apiService.verifyOtp(otpRequest);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body());
                        String result = jsonObject.getString("result"); // Tuỳ thuộc vào server trả về
                        Log.d("VerifyOtp", "OTP verification result: " + result);
                        Toast.makeText(ResetPass.this, result, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        Log.e("VerifyOtp", "JSON Parsing Error: " + e.getMessage());
                    }
                } else {
                    Log.e("VerifyOtp", "Failed to verify OTP: " + response.message());
                    Toast.makeText(ResetPass.this, "Xác thực OTP thất bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("VerifyOtp", "Error: " + t.getMessage());
                Toast.makeText(ResetPass.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
