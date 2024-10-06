package com.example.bansach;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class login_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main); // Đảm bảo layout được đặt đúng

        TextView forgot = findViewById(R.id.forgot);
        TextView signup = findViewById(R.id.signup);

        // Spannable cho Forgot Password
        SpannableString spannableString_forgot = new SpannableString("Forgot password");
        ClickableSpan clickableSpan_forgot = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Chuyển đến forgot_pass Activity
                Intent intent = new Intent(login_main.this, forgot_pass.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(forgot.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
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
                Intent intent = new Intent(login_main.this, signup.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(signup.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
            }
        };
        spannableString_signup.setSpan(clickableSpan_signup, 20, spannableString_signup.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signup.setText(spannableString_signup);
        signup.setMovementMethod(LinkMovementMethod.getInstance()); // Cho phép TextView có thể nhấn
    }
}