package com.example.bansach;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class Update_book_admin extends AppCompatActivity {

    // Khai báo các view trong giao diện
    private TextInputLayout bookNameLayout, authorNameLayout, categoryLayout, yearLayout, quantityLayout, descriptionLayout, priceLayout;
    private EditText editTextBookName, editTextAuthorName, editTextYear, editTextQuantity, editTextDescription, editTextPrice;
    private ImageView priceImage1, priceImage2;
    private Switch switchVisibility;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_admin);  // Gán giao diện từ file XML

        // Liên kết các view với mã
        bookNameLayout = findViewById(R.id.editTextBookNameLayout);
        authorNameLayout = findViewById(R.id.editTextAuthorNameLayout);
        categoryLayout = findViewById(R.id.editTextCategoryLayout);
        yearLayout = findViewById(R.id.editTextYearLayout);
        quantityLayout = findViewById(R.id.editTextQuantityLayout);
        descriptionLayout = findViewById(R.id.editTextDescriptionLayout);
        priceLayout = findViewById(R.id.editTextPriceLayout);

        editTextBookName = findViewById(R.id.editTextBookName);
        editTextAuthorName = findViewById(R.id.editTextAuthorName);
        editTextYear = findViewById(R.id.editTextYear);
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextPrice = findViewById(R.id.editTextPrice);

        priceImage1 = findViewById(R.id.priceImage1);
        priceImage2 = findViewById(R.id.priceImage2);

        switchVisibility = findViewById(R.id.switchVisibility);
        btnAdd = findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName = editTextBookName.getText().toString().trim();
                String authorName = editTextAuthorName.getText().toString().trim();
                String year = editTextYear.getText().toString().trim();
                String quantity = editTextQuantity.getText().toString().trim();
                String description = editTextDescription.getText().toString().trim();
                String price = editTextPrice.getText().toString().trim();

                if (!bookName.isEmpty() && !authorName.isEmpty()) {
                    Toast.makeText(Update_book_admin.this, "Đã cập nhật sách:\n" +
                            "Name: " + bookName + "\n" +
                            "Author: " + authorName + "\n" +
                            "Year: " + year + "\n" +
                            "Quantity: " + quantity + "\n" +
                            "Description: " + description + "\n" +
                            "Price: " + price, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Update_book_admin.this, "Vui lòng điền hết tất cả các trường.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
