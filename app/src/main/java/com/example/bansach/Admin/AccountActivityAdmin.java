package com.example.bansach.Admin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.R;


public class AccountActivityAdmin extends AppCompatActivity {
    private ImageView userImage;
    private TextView userName, userRole;
    private Button addBookButton, bookListButton, orderListButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view to the layout you created in XML
        setContentView(R.layout.activity_account_admin);

        // Initialize the views from the layout
        userImage = findViewById(R.id.user_image);
        userName = findViewById(R.id.user_name);
        userRole = findViewById(R.id.user_role);
        addBookButton = findViewById(R.id.button_add_book);
        bookListButton = findViewById(R.id.button_book_list);
        orderListButton = findViewById(R.id.button_order_list);
        logoutButton = findViewById(R.id.button_logout);

        // Set user info dynamically if needed
        userName.setText("Nguyễn Thị Hiếu");
        userRole.setText("Admin");

        // Set up click listeners for the buttons
        addBookButton.setOnClickListener(view -> {
            // Add your action for adding a book
        });

        bookListButton.setOnClickListener(view -> {
            // Add your action for viewing the book list
        });

        orderListButton.setOnClickListener(view -> {
            // Add your action for viewing the order list
        });

        logoutButton.setOnClickListener(view -> {
            // Add your action for logging out
        });
    }}

