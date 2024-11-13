package com.example.bansach;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.Admin.ListViewBookFragment;
import com.example.bansach.Admin.MenuActivityAdmin;

public class LoginMainPage extends AppCompatActivity {


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
                String username = textView.getText().toString();

                // Kiểm tra tên tài khoản
                if (username.equals("admin")) {
                    Intent adminIntent = new Intent(LoginMainPage.this, MenuActivityAdmin.class);
                    startActivity(adminIntent);
                } else if (username.equals("user")) {
                    Intent intent = new Intent(LoginMainPage.this, MenuActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}