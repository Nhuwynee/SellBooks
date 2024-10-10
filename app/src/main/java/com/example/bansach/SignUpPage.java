package com.example.bansach;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity {

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
                Intent intent = new Intent(SignUpPage.this, LoginMainPage.class);
                startActivity(intent);
                login.setBackgroundColor(Color.TRANSPARENT);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(login.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
                ds.bgColor = Color.TRANSPARENT; //màu nền trong suốt
            }
        };

        spannableString.setSpan(clickableSpan, 1, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        login.setText(spannableString);
        login.setMovementMethod(LinkMovementMethod.getInstance()); // Cho phép TextView có thể nhấn
        login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Hành động khi nhấn giữ
                login.setBackgroundColor(getResources().getColor(R.color.yourPressedColor));

                // Trả về true để chỉ định rằng sự kiện đã được xử lý
                return true;
            }
        });
    }
}
