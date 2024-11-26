package com.example.bansach;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpPage extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword, editTextRePassword, editTextPhone, editTextAddress;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        editTextUsername = findViewById(R.id.edittext_username);
        editTextPassword = findViewById(R.id.edittext_password);
        editTextRePassword = findViewById(R.id.edittext_re_enter_password);
        editTextPhone = findViewById(R.id.edittext_phone);
        editTextAddress = findViewById(R.id.edittext_address);
        btnSignUp = findViewById(R.id.btn_signup);

        btnSignUp.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();
            String rePassword = editTextRePassword.getText().toString();
            String phone = editTextPhone.getText().toString();
            String address = editTextAddress.getText().toString();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(address)) {
                Toast.makeText(SignUpPage.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(rePassword)) {
                Toast.makeText(SignUpPage.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tạo đối tượng User từ thông tin nhập vào
            User newUser = new User(username, phone, address, password);

            // Tạo API Service để gọi API
            APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
            Call<Void> call = apiService.registerUser(newUser);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(SignUpPage.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpPage.this, LoginMainPage.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SignUpPage.this, "Đăng ký thất bại: " + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(SignUpPage.this, "Lỗi kết nối!", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
