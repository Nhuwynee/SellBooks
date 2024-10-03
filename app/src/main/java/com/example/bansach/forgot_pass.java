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

public class forgot_pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass);

        TextView returnbt = findViewById(R.id.returnbt);
        SpannableString spannableString = new SpannableString("Return");

        ClickableSpan clickableSpan= new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Chuyển đến forgot_pass Activity
                Intent intent = new Intent(forgot_pass.this, login_main.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Gạch chân chữ
                ds.setColor(returnbt.getCurrentTextColor()); // Giữ nguyên màu chữ hiện tại
            }
        };

        spannableString.setSpan(clickableSpan, 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        returnbt.setText(spannableString);
        returnbt.setMovementMethod(LinkMovementMethod.getInstance()); // Cho phép TextView có thể nhấn
    }
}