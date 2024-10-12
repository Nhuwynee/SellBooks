package com.example.bansach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1);
        Button signupButton = findViewById(R.id.signup_button);
        Button loginButton = findViewById(R.id.login_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sử dụng Intent để chuyển sang SignupActivity
                Intent intent = new Intent(MainActivity.this, SignUpPage.class);
                startActivity(intent);  // Bắt đầu SignupActivity
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sử dụng Intent để chuyển sang SignupActivity
                Intent intent = new Intent(MainActivity.this, LoginMainPage.class);
                startActivity(intent);  // Bắt đầu SignupActivity
            }
        });
    }
}






