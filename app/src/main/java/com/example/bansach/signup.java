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

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Cú pháp đúng của phương thức onCreate
        super.onCreate(savedInstanceState);  // Gọi phương thức onCreate của lớp cha
        setContentView(R.layout.signup);  // Đặt layout cho activity

        TextView login = findViewById(R.id.login);
        SpannableString spannableString = new SpannableString("Have an account? Login");

        ClickableSpan clickableSpan= new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Chuyển đến forgot_pass Activity
                Intent intent = new Intent(signup.this, login_main.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(login.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
            }
        };

        spannableString.setSpan(clickableSpan, 1, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        login.setText(spannableString);
        login.setMovementMethod(LinkMovementMethod.getInstance()); // Cho phép TextView có thể nhấn
    }
}
