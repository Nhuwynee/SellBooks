package com.example.bansach;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.Admin.ListViewBookFragment;
import com.example.bansach.model.Book1;
import com.example.bansach.model.LoginRequest;
import com.example.bansach.model.LoginResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class LoginMainPage extends AppCompatActivity {
    List<LoginResponse> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        TextView forgot = findViewById(R.id.forgot);
        TextView signup = findViewById(R.id.signup);
        Button btn_login = findViewById(R.id.btn_login);
        // Spannable cho Forgot Password
        SpannableString spannableString_forgot = new SpannableString("Forgot password");
        ClickableSpan clickableSpan_forgot = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Chuyển đến forgot_pass Activity
                Intent intent = new Intent(LoginMainPage.this, FogotPassPage.class);
                startActivity(intent);
                // Xóa màu nền khi nhấn vào
                forgot.setBackgroundColor(Color.TRANSPARENT);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(forgot.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
                ds.bgColor = Color.TRANSPARENT; // Màu nền trong suốt
            }
        };
        spannableString_forgot.setSpan(clickableSpan_forgot, 0, spannableString_forgot.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        forgot.setText(spannableString_forgot);
        forgot.setMovementMethod(LinkMovementMethod.getInstance()); // Cho phép TextView có thể nhấn


        // Spannable cho Sign up
        SpannableString spannableString_signup = new SpannableString("Haven't an account? Sign up");
        ClickableSpan clickableSpan_signup = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Chuyển đến signup Activity
                Intent intent = new Intent(LoginMainPage.this, SignUpPage.class);
                startActivity(intent);
                signup.setBackgroundColor(Color.TRANSPARENT);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(signup.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
                ds.bgColor = Color.TRANSPARENT; // Màu nền trong suốt
            }
        };
        spannableString_signup.setSpan(clickableSpan_signup, 20, spannableString_signup.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signup.setText(spannableString_signup);
        signup.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView = findViewById(R.id.edittextlogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên người dùng và mật khẩu từ EditText
                EditText editUsername = findViewById(R.id.edittextlogin); // EditText tên đăng nhập
                EditText editPassword = findViewById(R.id.edittext_password); // EditText mật khẩu

                // Lấy tên người dùng và mật khẩu nhập vào
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                // Kiểm tra nếu người dùng nhập đủ tên và mật khẩu
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginMainPage.this, "Vui lòng nhập tên người dùng và mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tạo request
                LoginRequest loginRequest = new LoginRequest(username, password);

                // Gọi API
                APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
                Call<List<LoginResponse>> call = apiService.login(loginRequest);

                call.enqueue(new retrofit2.Callback<List<LoginResponse>>() {
                    @Override
                    public void onResponse(Call<List<LoginResponse>> call, Response<List<LoginResponse>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            list = response.body();  // Lưu dữ liệu vào danh sách
                            boolean isLoginSuccessful = false;

                            // Duyệt qua tất cả các phần tử trong danh sách
                            for (LoginResponse loginResponse : list) {
                                // Kiểm tra xem tên và mật khẩu có khớp không
                                if (loginResponse.getName().equals(username) && loginResponse.getPassword().equals(password)) {
                                    isLoginSuccessful = true;  // Đánh dấu là đăng nhập thành công
                                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putInt("userId", loginResponse.getIdUser());
                                    editor.apply();
                                    int savedUserId = sharedPreferences.getInt("userId", -1);
                                    Log.d("UserId", "Saved User ID: " + savedUserId);
                                    // Xử lý thông tin người dùng
                                    String name = loginResponse.getName();
                                    String phone = loginResponse.getPhone();
                                    String avatar = loginResponse.getAvatarImage();

                                    // Kiểm tra vai trò hoặc cấp độ
                                    if (loginResponse.getLevel() == 2) {
                                        // Điều hướng đến trang người dùng
                                        Intent intent = new Intent(LoginMainPage.this, MenuActivity.class);
                                        startActivity(intent);
                                    } else if (loginResponse.getLevel() == 1) {
                                        // Điều hướng đến trang quản trị viên
                                        Toast.makeText(LoginMainPage.this, "Đây là tài khoản của Admin, App ko hỗ trợ.", Toast.LENGTH_SHORT).show();
                                    }
                                    break;  // Dừng vòng lặp sau khi tìm thấy tài khoản phù hợp
                                }
                            }

                            if (!isLoginSuccessful) {
                                // Thông báo đăng nhập thất bại nếu không tìm thấy tài khoản phù hợp
                                Toast.makeText(LoginMainPage.this, "Tên người dùng hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Thông báo lỗi khi API không trả về kết quả hợp lệ
                            Toast.makeText(LoginMainPage.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<LoginResponse>> call, Throwable t) {
                        if (t instanceof IOException) {
                            Toast.makeText(LoginMainPage.this, "Không có kết nối mạng. Vui lòng kiểm tra lại kết nối.", Toast.LENGTH_LONG).show();
                            Log.e("LoginMainPage", "Lỗi kết nối mạng: " + t.getMessage(), t); // Ghi log lỗi kết nối mạng
                        } else {
                            Toast.makeText(LoginMainPage.this, "Lỗi mạng: " + t.getMessage(), Toast.LENGTH_LONG).show();
                            Log.e("LoginMainPage", "Lỗi mạng: " + t.getMessage(), t); // Ghi log thông báo lỗi chung
                        }
                    }
                });
            }
        });
    }
}