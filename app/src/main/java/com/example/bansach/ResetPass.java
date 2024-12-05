package com.example.bansach;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.model.NewPassRequest;
import com.example.bansach.model.OtpRequest;

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
        String phoneNumberEditText = sharedPreferences.getString("PHONE_NUMBER_KEY", null);

        Button verifyOtpButton = findViewById(R.id.btn_signup);
        EditText otpEditText = findViewById(R.id.otp1);
        EditText newPasswordEditText = findViewById(R.id.newpass);

        verifyOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText;
                String otpCode = otpEditText.getText().toString();
                String newPassword = newPasswordEditText.getText().toString();
                String otp = "147852";
                if (phoneNumber == null || phoneNumber.isEmpty()) {
                    Toast.makeText(ResetPass.this, "Không tìm thấy số điện thoại.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (otpCode.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(ResetPass.this, "Vui lòng nhập đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (otpCode.equals(otp)) {
                    verifyOtpAndUpdatePassword(phoneNumber, newPassword);

                }
                else {
                    Log.d("Resetpass", "Otp ko đúng");

                }

            }
        });
    }

    public void verifyOtpAndUpdatePassword(String phoneNumber,  String newPassword) {
        NewPassRequest request = new NewPassRequest(phoneNumber,newPassword);
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<Void> call = apiService.updatePassword(request);
        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("Resetpass", "Quantity updated successfully");
                    Intent intent = new Intent(ResetPass.this, LoginMainPage.class);
                    startActivity(intent);
                } else {
                    Log.e("Resetpass", "Error updating quantity: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Resetpass", "Error: " + t.getMessage());
            }
        });
    }


}